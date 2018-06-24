package org.tesso.skip.cart.data.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tesso.skip.cart.common.entities.ItemEntity;
import org.tesso.skip.cart.data.common.DataBaseTest;

import java.util.List;

public class ItemRepositoryTest extends DataBaseTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void testItemRepository(){
        ItemEntity itemEntity = new ItemEntity(1L, 1L, "without mostard");

        itemRepository.save(itemEntity);

        List<ItemEntity> listItems = itemRepository.findAll();

        Assert.assertTrue(listItems.size() > 0);
    }
}
