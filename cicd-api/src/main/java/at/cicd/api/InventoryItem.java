package at.cicd.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "inventoryBuilder")
public class InventoryItem extends Item
{
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Price costPrice;
    @Getter
    @Setter
    private int stockQuantity;
}
