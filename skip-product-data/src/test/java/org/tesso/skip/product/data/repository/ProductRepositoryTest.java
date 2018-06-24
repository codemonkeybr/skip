package org.tesso.skip.product.data.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tesso.skip.product.common.entities.ProductEntity;
import org.tesso.skip.product.data.common.DataBaseTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ProductRepositoryTest extends DataBaseTest {

    @Autowired
    private ProductRepository productRepository;


    @Test
    public void testProductRepository(){
        ProductEntity productEntity = new ProductEntity("Just a product!", "10x10 inch", BigDecimal.valueOf(10.5), LocalDateTime.now());

        productRepository.save(productEntity);

        List<ProductEntity> listProducts = productRepository.findAll();

        Assert.assertTrue(listProducts.size() > 0);
    }
}
