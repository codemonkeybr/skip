package org.tesso.skip.product.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tesso.skip.infrastructure.data.JpaGenericData;
import org.tesso.skip.product.common.entities.ProductEntity;
import org.tesso.skip.product.data.repository.ProductRepository;
import org.tesso.skip.product.message.handler.ProductDispatcher;

@Component
public class ProductData extends JpaGenericData<ProductEntity, Long> {

    private ProductRepository productRepository;

    @Autowired
    private ProductDispatcher productDispatcher;

    @Override
    public ProductEntity add(ProductEntity productEntity) {
        super.add(productEntity);
        productDispatcher.dispatch(productEntity, true);
        return productEntity;
    }

    @Override
    public void update(ProductEntity productEntity) {
        super.update(productEntity);
        productDispatcher.dispatch(productEntity, true);
    }

    @Override
    public void delete(ProductEntity productEntity) {
        super.delete(productEntity);
        productDispatcher.dispatch(productEntity, false);
    }
}
