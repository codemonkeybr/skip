package org.tesso.skip.cart.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tesso.skip.cart.common.entities.ItemEntity;
import org.tesso.skip.infrastructure.resource.RestGenericData;

import static org.tesso.skip.cart.resources.common.Path.ITEM_PATH;

@RestController
@RequestMapping(ITEM_PATH)
public class ItemResource extends RestGenericData<ItemEntity, Long> {
}
