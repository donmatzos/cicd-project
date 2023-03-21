package at.cicd.cicdproject.inventoryservice.impl;

import at.cicd.cicdproject.impl.model.InventoryItem;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component("inventoryService")
@RequestMapping("/inventory")
public class InventoryServiceImpl implements InventoryService
{

    @Override
    public InventoryItem checkItem(@RequestParam final String itemId)
    {
        return new InventoryItem();
    }
}
