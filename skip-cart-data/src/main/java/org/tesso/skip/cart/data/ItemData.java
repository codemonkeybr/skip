package org.tesso.skip.cart.data;

import org.springframework.stereotype.Component;
import org.tesso.skip.cart.common.entities.ItemEntity;
import org.tesso.skip.cart.data.repository.ItemRepository;
import org.tesso.skip.infrastructure.data.JpaGenericData;

@Component
public class ItemData extends JpaGenericData<ItemEntity, Long> {

    private ItemRepository itemRepository;
}
