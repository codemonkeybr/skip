package org.tesso.skip.product.message.handler;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.tesso.skip.product.common.entities.ProductEntity;

@Component
public class ProductDispatcher {

    private final RabbitTemplate rabbitTemplate;


    public ProductDispatcher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void dispatch(ProductEntity entity, boolean state){
        org.tesso.skip.infrastructure.event.Product product =
                new org.tesso.skip.infrastructure.event.Product(entity.getId(), entity.getDescription(), entity.getSize(), entity.getPrice(), entity.getDateCreated(), state);
        rabbitTemplate.convertAndSend("product-exchange", "foo.bar.baz", product);
    }
}


