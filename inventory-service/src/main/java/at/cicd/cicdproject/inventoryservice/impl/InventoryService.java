package at.cicd.cicdproject.inventoryservice.impl;

import at.cicd.api.InventoryItem;
import at.cicd.api.Stock;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Service
public interface InventoryService
{
    @GetMapping("/get-item-stock")
    InventoryItem getStockForItem(@RequestParam final String itemId);

    @GetMapping("/get-stock")
    Stock getStock();
}
