package at.cicd.api;

import at.cicd.api.enumeration.CalculationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    private CalculationType calculationType;
    @Getter
    @Setter
    private List<Item> items;
    @Getter
    @Setter
    private Address deliveryAddress;
    @Getter
    @Setter
    private Date orderDate;
    @Getter
    @Setter
    private Date paymentDate;
}
