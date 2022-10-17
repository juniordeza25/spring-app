package com.example.springapp.domain.service.implementation;

import com.example.springapp.common.dto.ProductDto;
import com.example.springapp.domain.entity.Product;
import com.example.springapp.domain.service.CategoryService;
import com.example.springapp.domain.service.ProductService;
import com.example.springapp.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Override
    public List<Product> findAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        //para validar que el producto no este eliminado se busca por id y por deleted en false
        Product product = productRepository.findProductByIdAndDeleted(id, false);
        if (product == null) {
            throw new EntityNotFoundException("The product with id " + id + " is not found");
        }
        return product;
    }

    @Override
    public Product createProduct(ProductDto productDto) {
        Product product = new Product();
        /*Se setea una categoria, pero primero se busca la categoia, si no existe
        arroja un error y se evitará la creaccion del producto*/
        product.setCategory(categoryService.findCategoryById(productDto.getCategoryId()));
        BeanUtils.copyProperties(productDto, product);
        product.setDeleted(false);//siempre que se cree un producto se setea a false
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return productRepository.save(product);
    }

    @Override
    public Product updateProductPriceById(Long id, BigDecimal price) {
        Product product = this.findProductById(id);
        product.setPrice(price.setScale(2, RoundingMode.HALF_EVEN));
        return productRepository.save(product);
    }

    @Override
    public void disableProductById(Long id) {
        Product product = this.findProductById(id);
        product.setDeleted(true);
        productRepository.save(product);//se actualiza el producto para que quede como eliminado en la BD
    }
}
