package org.tesso.just.food.infraestructure.event;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Product implements Serializable {

    private Long id;

    private String description;
    private String size;
    private BigDecimal price;
    private LocalDateTime dateCreated;
    private boolean enabled;

    public Product(Long id, String description, String size, BigDecimal price, LocalDateTime dateCreated, boolean enabled) {
        this.id = id;
        this.description = description;
        this.size = size;
        this.price = price;
        this.dateCreated = dateCreated;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
