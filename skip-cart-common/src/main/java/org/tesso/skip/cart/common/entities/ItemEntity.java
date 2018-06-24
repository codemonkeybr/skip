package org.tesso.skip.cart.common.entities;

import org.tesso.skip.infrastructure.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="item")
public class ItemEntity extends BaseEntity<Long> {

    @Column(name = "cart_id")
    private Long cartId;
    @Column(name = "product_id")
    private Long productId;

    private String observation;

    public ItemEntity() {
    }

    public ItemEntity(Long cartId, Long productId, String observation) {
        this.cartId = cartId;
        this.productId = productId;
        this.observation = observation;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
