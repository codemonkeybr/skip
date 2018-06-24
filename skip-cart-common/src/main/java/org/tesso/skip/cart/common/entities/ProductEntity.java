package org.tesso.skip.cart.common.entities;

import org.tesso.skip.infrastructure.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="product")
public class ProductEntity extends BaseEntity<Long> {

    private String description;
    private String size;
    private BigDecimal price;
    private LocalDateTime dateCreated;
    private boolean enabled;

    public ProductEntity() {
    }

    public ProductEntity(String description, String size, BigDecimal price, LocalDateTime dateCreated, boolean enabled) {
        this.description = description;
        this.size = size;
        this.price = price;
        this.dateCreated = dateCreated;
        this.enabled = enabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
