package at.cicd.cicdproject.orderservice.impl;

import at.cicd.api.Item;
import at.cicd.api.Order;
import at.cicd.api.Price;
import at.cicd.api.enumeration.CalculationType;
import at.cicd.api.output.OrderCalculationResult;
import at.cicd.cicdproject.orderservice.util.OrderTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.InputMismatchException;

@SpringBootTest
@EnableAutoConfiguration
@Test
public class OrderServiceTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private OrderService orderService;

    @Test
    public void testNetCalculation()
    {
        final Order order = OrderTestUtils.createOrder(CalculationType.NET, BigDecimal.valueOf(2000.), BigDecimal.valueOf(.20));

        final OrderCalculationResult result = orderService.calculateOrder(order);

        Assert.assertEquals(result.getOrderPrice().getGrossAmount().doubleValue(), 2400.);
        Assert.assertEquals(result.getOrderPrice().getVatAmount().doubleValue(), 400.);
        Assert.assertEquals(result.getOrderPrice().getCurrency(), Currency.getInstance("EUR"));
    }

    @Test
    public void testGrossCalculation()
    {
        final Order order = OrderTestUtils.createOrder(CalculationType.GROSS, BigDecimal.valueOf(2400.), BigDecimal.valueOf(.20));

        final OrderCalculationResult result = orderService.calculateOrder(order);

        Assert.assertEquals(result.getOrderPrice().getNetAmount().doubleValue(), 2000.);
        Assert.assertEquals(result.getOrderPrice().getVatAmount().doubleValue(), 400.);
        Assert.assertEquals(result.getOrderPrice().getCurrency(), Currency.getInstance("EUR"));
    }

    @Test(expectedExceptions = InputMismatchException.class)
    public void testNullVatInput()
    {
        final Order order = new Order();
        order.setCalculationType(CalculationType.NET);
        order.setItems(new ArrayList<>());

        orderService.calculateOrder(order);
    }

    @Test(expectedExceptions = InputMismatchException.class)
    public void testWrongVatInput()
    {
        final Order order = new Order();
        order.setCalculationType(CalculationType.NET);
        order.setItems(new ArrayList<>());
        final Price initialPrice = Price.builder().vatRate(BigDecimal.valueOf(0.2)).build();
        order.getItems().add(Item.builder().price(initialPrice).build());
        final Price wrongPrice = Price.builder().vatRate(BigDecimal.valueOf(0.21)).build();
        order.getItems().add(Item.builder().price(wrongPrice).build());

        orderService.calculateOrder(order);
    }
}
