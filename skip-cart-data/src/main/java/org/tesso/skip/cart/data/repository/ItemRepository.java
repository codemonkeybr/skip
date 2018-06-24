package org.tesso.skip.cart.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tesso.skip.cart.common.entities.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}
