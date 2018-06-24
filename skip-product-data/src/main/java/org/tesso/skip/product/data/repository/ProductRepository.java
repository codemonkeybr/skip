package org.tesso.skip.product.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.tesso.skip.product.common.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
