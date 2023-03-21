package at.cicd.cicdproject.orderservice.impl;

import at.cicd.api.Item;
import at.cicd.api.Order;
import at.cicd.api.enumeration.CalculationType;
import at.cicd.api.output.OrderCalculationResult;
import at.cicd.cicdproject.orderservice.util.OrderCalculationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.List;

@Component("orderService")
@RequestMapping("/order")
public class OrderServiceImpl implements OrderService
{
    @Override
    public OrderCalculationResult calculateOrder(@RequestBody final Order order)
    {
        verifyOrder(order);
        return CalculationType.NET.equals(order.getCalculationType())
                ? OrderCalculationUtils.calculateNetOrder(order)
                : OrderCalculationUtils.calculateGrossOrder(order);
    }

    private void verifyOrder(final Order order)
    {
        if (order.getItems().isEmpty() || hasIncorrectPrices(order.getCalculationType(), order.getItems()))
        {
            throw new InputMismatchException("Unprocessable Order - Invalid Input.");
        }
        verifyVat(order.getItems());
    }

    private void verifyVat(final List<Item> items)
    {
        final BigDecimal vatRate = items.get(0).getPrice().getVatRate();
        for (Item item : items)
        {
            if (item.getPrice().getVatRate() == null || !vatRate.equals(item.getPrice().getVatRate()))
            {
                throw new InputMismatchException();
            }
        }
    }

    private boolean hasIncorrectPrices(final CalculationType calculationType, final List<Item> items)
    {
        return CalculationType.NET.equals(calculationType) ? checkNetPrices(items) : checkGrossPrices(items);
    }

    private boolean checkNetPrices(final List<Item> items)
    {
        return items.stream().anyMatch(item -> item.getPrice().getNetAmount() == null);
    }

    private boolean checkGrossPrices(final List<Item> items)
    {
        return items.stream().anyMatch(item -> item.getPrice().getGrossAmount() == null);
    }

}
