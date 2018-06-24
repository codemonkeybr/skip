package org.tesso.skip.cart.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tesso.skip.cart.common.entities.ProductEntity;
import org.tesso.skip.infrastructure.resource.RestGenericData;

import static org.tesso.skip.cart.resources.common.Path.PRODUCT_PATH;

@RestController
@RequestMapping(PRODUCT_PATH)
public class ProductResource extends RestGenericData<ProductEntity, Long> {
}
