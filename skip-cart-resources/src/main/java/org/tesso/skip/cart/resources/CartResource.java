package org.tesso.skip.cart.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tesso.skip.cart.common.entities.CartEntity;
import org.tesso.skip.infrastructure.resource.RestGenericData;

import static org.tesso.skip.cart.resources.common.Path.CART_PATH;

@RestController
@RequestMapping(CART_PATH)
public class CartResource extends RestGenericData<CartEntity, Long> {
}
