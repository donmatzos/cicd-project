package at.cicd.cicdproject.orderservice.impl;

import at.cicd.api.Order;
import at.cicd.api.output.OrderCalculationResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Service
public interface OrderService
{
    @PostMapping("/calculate-order")
    OrderCalculationResult calculateOrder(@RequestBody final Order order);
}
