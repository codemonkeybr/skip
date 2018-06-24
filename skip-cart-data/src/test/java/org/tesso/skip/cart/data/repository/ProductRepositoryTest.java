package org.tesso.skip.cart.data.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tesso.skip.cart.common.entities.ProductEntity;
import org.tesso.skip.cart.data.common.DataBaseTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ProductRepositoryTest extends DataBaseTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testProductRepository(){
        ProductEntity productEntity = new ProductEntity("The Hitchhiker's Guide to the Galaxy", "Bigger than the biggest thing ever and then some", BigDecimal.valueOf(42.0), LocalDateTime.of(2005, 4, 28, 0,0,0), true);

        productRepository.save(productEntity);

        List<ProductEntity> listProducts = productRepository.findAll();

        Assert.assertTrue(listProducts.size() > 0);
    }
}
