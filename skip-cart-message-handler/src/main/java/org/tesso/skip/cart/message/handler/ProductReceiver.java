package org.tesso.skip.cart.message.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tesso.skip.cart.common.data.ProductDataService;
import org.tesso.skip.cart.common.entities.ProductEntity;
import org.tesso.skip.infrastructure.event.Product;

import java.util.concurrent.CountDownLatch;

@Component
public class ProductReceiver {

    @Autowired
    private ProductDataService productDataService;

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(Product product){
        System.out.println("Message Received: ID: "+product.getId() + " Status: "+product.isEnabled());
        latch.countDown();

        ProductEntity productEntity = new ProductEntity(product.getDescription(), product.getSize(), product.getPrice(), product.getDateCreated(), product.isEnabled());
        productEntity.setId(product.getId());
        productDataService.update(productEntity);
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
