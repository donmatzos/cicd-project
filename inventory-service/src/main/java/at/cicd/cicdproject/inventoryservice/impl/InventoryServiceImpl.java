package at.cicd.cicdproject.inventoryservice.impl;

import at.cicd.api.InventoryItem;
import at.cicd.api.Stock;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component("inventoryService")
@RequestMapping("/inventory")
public class InventoryServiceImpl implements InventoryService
{

    @Override
    public InventoryItem getStockForItem(@RequestParam final String itemId)
    {
        return new InventoryItem();
    }

    @Override
    public Stock getStock()
    {
        return new Stock();
    }
}
