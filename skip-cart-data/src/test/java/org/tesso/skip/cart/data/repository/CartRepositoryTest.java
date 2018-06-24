package org.tesso.skip.cart.data.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tesso.skip.cart.common.entities.CartEntity;
import org.tesso.skip.cart.data.common.DataBaseTest;

import java.math.BigDecimal;
import java.util.List;

public class CartRepositoryTest extends DataBaseTest {

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void testProductRepository(){
        CartEntity cartEntity = new CartEntity(1L, 1L, BigDecimal.ZERO);

        cartRepository.save(cartEntity);

        List<CartEntity> listCart = cartRepository.findAll();

        Assert.assertTrue(listCart.size() > 0);
    }
}
