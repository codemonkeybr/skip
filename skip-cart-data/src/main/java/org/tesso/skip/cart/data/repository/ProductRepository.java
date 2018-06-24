package org.tesso.skip.cart.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tesso.skip.cart.common.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
