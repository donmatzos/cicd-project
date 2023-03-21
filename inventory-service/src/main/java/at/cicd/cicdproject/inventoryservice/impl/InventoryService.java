package at.cicd.cicdproject.inventoryservice.impl;

import at.cicd.cicdproject.impl.model.InventoryItem;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Service
public interface InventoryService
{
    @GetMapping("/check-item")
    InventoryItem checkItem(@RequestParam final String itemId);
}
