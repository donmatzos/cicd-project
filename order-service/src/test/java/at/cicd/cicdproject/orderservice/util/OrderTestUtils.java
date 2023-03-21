package at.cicd.cicdproject.orderservice.util;

import at.cicd.api.Address;
import at.cicd.api.Item;
import at.cicd.api.Order;
import at.cicd.api.Price;
import at.cicd.api.enumeration.CalculationType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;

public final class OrderTestUtils
{
    private OrderTestUtils() {}

    /**
     * Order contains 5 Items with a net price of 1000 each and 20% vat rate.
     *
     * @return Order.
     */
    public static Order createDemoTestOrder()
    {
        return Order.builder()
                .calculationType(CalculationType.GROSS)
                .items(buildDemoItemList())
                .deliveryAddress(buildDemoDeliveryAddress())
                .orderDate(Date.from(Instant.now()))
                .paymentDate(Date.from(Instant.now()))
                .build();
    }

    public static Order createOrder(final CalculationType calculationType, final BigDecimal priceAmount, final BigDecimal vatRate)
    {
        final Order order = Order.builder()
                .calculationType(calculationType)
                .items(new ArrayList<>())
                .orderDate(Date.from(Instant.now()))
                .paymentDate(Date.from(Instant.now()))
                .build();
        addItemToOrder(order, priceAmount, vatRate);

        return order;
    }

    private static void addItemToOrder(final Order order, final BigDecimal priceAmount, final BigDecimal vatRate)
    {
        if (CalculationType.NET.equals(order.getCalculationType()))
        {
            final Item item = Item.builder()
                    .externalId("net item")
                    .price(createNetPrice(priceAmount, vatRate))
                    .build();
            order.getItems().add(item);
        }
        else if (CalculationType.GROSS.equals(order.getCalculationType()))
        {
            final Item item = Item.builder()
                    .externalId("gross item")
                    .price(createGrossPrice(priceAmount, vatRate))
                    .build();
            order.getItems().add(item);
        }
    }

    private static Price createNetPrice(final BigDecimal netAmount, final BigDecimal vatRate)
    {
        return Price.builder()
                .netAmount(netAmount)
                .vatRate(vatRate)
                .currency(Currency.getInstance("EUR"))
                .build();
    }

    private static Price createGrossPrice(BigDecimal grossAmount, BigDecimal vatRate)
    {
        return Price.builder()
                .grossAmount(grossAmount)
                .vatRate(vatRate)
                .currency(Currency.getInstance("EUR"))
                .build();
    }

    private static List<Item> buildDemoItemList()
    {
        final List<Item> items = new ArrayList<>();
        final Price price = Price.builder()
                .netAmount(BigDecimal.valueOf(1000.))
                .grossAmount(BigDecimal.valueOf(1200.))
                .vatAmount(BigDecimal.valueOf(200.))
                .vatRate(BigDecimal.valueOf(.20))
                .currency(Currency.getInstance("EUR"))
                .build();
        for (int i = 0; i < 5; i++)
        {
            final Item item = Item.builder()
                    .externalId("Item " + i)
                    .price(price)
                    .build();
            items.add(item);
        }
        return items;
    }

    private static Address buildDemoDeliveryAddress()
    {
        return Address.builder()
                .name("Foo Fighter")
                .street("Bar Street")
                .country("Austria")
                .zipCode(4400)
                .build();
    }

}
