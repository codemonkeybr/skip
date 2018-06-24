package org.tesso.skip.cart.data;

import org.springframework.stereotype.Component;
import org.tesso.skip.cart.common.entities.CartEntity;
import org.tesso.skip.cart.data.repository.CartRepository;
import org.tesso.skip.infrastructure.data.JpaGenericData;

@Component
public class CartData  extends JpaGenericData<CartEntity, Long> {

    private CartRepository cartRepository;
}
