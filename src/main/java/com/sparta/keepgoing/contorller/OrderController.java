package com.sparta.keepgoing.contorller;

import com.sparta.keepgoing.dto.OrderDto;
import com.sparta.keepgoing.dto.OrderRequestDto;
import com.sparta.keepgoing.models.Food;
import com.sparta.keepgoing.models.OrderList;
import com.sparta.keepgoing.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class OrderController {


    private final OrderService orderService;

    @PostMapping("/order/request")
    public OrderDto orderFood(@RequestBody OrderRequestDto orderRequestDto){
        orderService.registerOrder(orderRequestDto);
        return orderService.makeOrderDto(orderRequestDto);
    }

    @GetMapping("/orders")
    public List<OrderList> showOrders(){
        return orderService.findOrders();
    }


}
