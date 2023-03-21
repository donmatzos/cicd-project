package at.cicd.api.output;

import at.cicd.api.Address;
import at.cicd.api.Item;
import at.cicd.api.Price;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class OrderCalculationResult implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    private Price orderPrice;
    @Getter
    @Setter
    private List<Item> calculatedItems;
    @Getter
    @Setter
    private Address deliveryAddress;
    @Getter
    @Setter
    private Date orderDate;
    @Getter
    @Setter
    private Date paymentDate;
    @Getter
    @Setter
    private Date calculationDate;
}
