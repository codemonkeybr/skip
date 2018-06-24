package org.tesso.skip.product.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tesso.skip.infrastructure.resource.RestGenericData;
import org.tesso.skip.product.common.entities.ProductEntity;

import static org.tesso.skip.product.resources.common.Path.PRODUCT_PATH;

@RestController
@RequestMapping(PRODUCT_PATH)
public class ProductResource extends RestGenericData<ProductEntity, Long> {
}
