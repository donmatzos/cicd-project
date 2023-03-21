package at.cicd.api;

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
public class Stock implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    private List<InventoryItem> items;
    @Getter
    @Setter
    private Date informationDate;
}
