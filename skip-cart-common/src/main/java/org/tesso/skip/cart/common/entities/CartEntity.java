package org.tesso.skip.cart.common.entities;

import org.tesso.skip.infrastructure.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "cart")
public class CartEntity extends BaseEntity<Long> {

    @Column(name="costumer_id")
    private Long costumerId;
    @Column(name="delivery_id")
    private Long deliveryId;

    private BigDecimal discount;

    public CartEntity() {
    }

    public CartEntity(Long costumerId, Long deliveryId, BigDecimal discount) {
        this.costumerId = costumerId;
        this.deliveryId = deliveryId;
        this.discount = discount;
    }

    public Long getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(Long costumerId) {
        this.costumerId = costumerId;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
