package org.tesso.skip.cart.data;

import org.springframework.stereotype.Component;
import org.tesso.skip.cart.common.data.ProductDataService;
import org.tesso.skip.cart.common.entities.ProductEntity;
import org.tesso.skip.cart.data.repository.ProductRepository;
import org.tesso.skip.infrastructure.data.JpaGenericData;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductData extends JpaGenericData<ProductEntity, Long> implements ProductDataService {

    private ProductRepository productRepository;

    @Override
    public List<ProductEntity> findAll() {
        //Just a little bit of java 8 stream to get a tast of its amaziness
        //on real life i would just filter it out as a parameter on the jpa query
        // we just want make avaliable the products that exists on the 'product' api
        return productRepository.findAll().stream().filter(ProductEntity::isEnabled).collect(Collectors.toList());
    }
}
