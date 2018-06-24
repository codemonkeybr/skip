package org.tesso.skip.product.data;

import org.springframework.stereotype.Component;
import org.tesso.skip.infrastructure.data.JpaGenericData;
import org.tesso.skip.product.common.entities.ProductEntity;
import org.tesso.skip.product.data.repository.ProductRepository;

@Component
public class ProductData extends JpaGenericData<ProductEntity, Long> {

    private ProductRepository productRepository;
}
