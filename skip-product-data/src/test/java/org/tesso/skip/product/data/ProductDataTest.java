package org.tesso.skip.product.data;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tesso.skip.product.common.entities.ProductEntity;
import org.tesso.skip.product.data.common.DataBaseTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ProductDataTest extends DataBaseTest {

    @Autowired
    private ProductData productData;


    @Test
    public void productDataTest(){
        ProductEntity productEntity = new ProductEntity("Just a product!", "10x10 inch", BigDecimal.valueOf(10.5), LocalDateTime.now());

        productData.add(productEntity);

        List<ProductEntity> listProducts = productData.findAll();

        Assert.assertTrue(listProducts.size() > 0);

    }
}
