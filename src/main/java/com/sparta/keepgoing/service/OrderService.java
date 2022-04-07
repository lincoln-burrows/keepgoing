package com.sparta.keepgoing.service;

import com.sparta.keepgoing.dto.*;

import com.sparta.keepgoing.models.FoodOrder;
import com.sparta.keepgoing.models.OrderList;
import com.sparta.keepgoing.repository.FoodRepository;
import com.sparta.keepgoing.repository.OrderListRepository;
import com.sparta.keepgoing.repository.OrderRepository;
import com.sparta.keepgoing.repository.RestaurantsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;
    private final RestaurantsRepository restaurantsRepository;
    private final FoodRepository foodRepository;
    private final OrderListRepository orderListRepository;

    public OrderList registerOrder(OrderRequestDto orderRequestDto) {
        Long restaurantId = orderRequestDto.getRestaurantId();
        Long minOrderPrice = restaurantsRepository.findMinOrderPriceById(restaurantId).getMinOrderPrice();
        List<FoodOrder> orders = new ArrayList(0);
        List<FoodOrderRequestDto> orderRequestDtos = orderRequestDto.getFoods();
        int orderSize = orderRequestDto.getFoods().size();
        String cafeName = restaurantsRepository.findRestaurantsById(restaurantId).getName();
        int deliveryFee = Math.toIntExact(restaurantsRepository.findRestaurantsById(restaurantId).getDeliveryFee());
        int totalPrice = 0;
        int quantity = 0;
        int price=0;

        for (int i=0; i<orderSize; i++) {
            FoodOrderRequestDto foodOrderRequestDto = orderRequestDtos.get(i);
            FoodOrderDto foodOrderDto = new FoodOrderDto();
            Long foodId = foodOrderRequestDto.getId();
            quantity =foodOrderRequestDto.getQuantity();
            price = Math.toIntExact(foodRepository.findByRestaurantIdAndId(restaurantId, foodId).getPrice());
            foodOrderDto.setName(foodRepository.findByRestaurantIdAndId(restaurantId, foodId).getName());
            foodOrderDto.setQuantity(quantity);
            if(quantity<1 ||quantity>100){throw new IllegalArgumentException("주문하기 - 음식 주문 수량 1 미만 100초과 에러");}
            foodOrderDto.setPrice(price*quantity);
//            foodOrderDtos.add(foodOrderDto);
            totalPrice= totalPrice + quantity*price;
            FoodOrder order = new FoodOrder(foodOrderDto);
            orderRepository.save(order);
            orders.add(order);
        }
        if(totalPrice<minOrderPrice){throw new IllegalArgumentException("최소주문가격 미만 에러");}
        totalPrice += deliveryFee;

        OrderList orderList = new OrderList(cafeName, deliveryFee, totalPrice, orders);
        orderListRepository.save(orderList);
        return orderList;

    }
    public List<OrderList> findOrders() {
        return orderListRepository.findAll();


    }

//    public OrderDto makeOrderDto(OrderRequestDto orderRequestDto) {
//        Long restaurantId = orderRequestDto.getRestaurantId();
//        Long minOrderPrice = restaurantsRepository.findMinOrderPriceById(restaurantId).getMinOrderPrice();
//        List<FoodOrder> orders = new ArrayList(0);
//        List<FoodOrderDto> foodOrderDtos = new ArrayList(0);
//        List<FoodOrderRequestDto> orderRequestDtos = orderRequestDto.getFoods();
//        int orderSize = orderRequestDto.getFoods().size();
//        String cafeName = restaurantsRepository.findRestaurantsById(restaurantId).getName();
//        int deliveryFee = Math.toIntExact(restaurantsRepository.findRestaurantsById(restaurantId).getDeliveryFee());
//        int totalPrice = 0;
//
//        for (int i=0; i<orderSize; i++) {
//            FoodOrderRequestDto foodOrderRequestDto = orderRequestDtos.get(i);
//            FoodOrderDto foodOrderDto = new FoodOrderDto();
//            Long foodId = foodOrderRequestDto.getId();
//            int quantity = foodOrderRequestDto.getQuantity();
//            if(foodOrderDto.getQuantity()<1 ||foodOrderDto.getQuantity()>100){throw new IllegalArgumentException("주문하기 - 음식 주문 수량 1 미만 100초과 에러");}
//            int price = Math.toIntExact(foodRepository.findByRestaurantIdAndId(restaurantId, foodId).getPrice());
//            if(i == orderSize-1 && totalPrice<minOrderPrice){throw new IllegalArgumentException("최소주문가격 미만 에러");}
//            foodOrderDto.setName(foodRepository.findByRestaurantIdAndId(restaurantId, foodId).getName());
//            foodOrderDto.setQuantity(quantity);
//            foodOrderDto.setPrice(price*quantity);
//            foodOrderDtos.add(foodOrderDto);
//            totalPrice= totalPrice + quantity*price;
//            if(i == orderSize-1 && totalPrice<minOrderPrice){throw new IllegalArgumentException("최소주문가격 미만 에러");}
//            FoodOrder order = new FoodOrder(foodOrderDto);
//            orderRepository.save(order);
//            orders.add(order);
//
//        }
//        totalPrice += deliveryFee;
//
//        OrderList orderList = new OrderList(cafeName, deliveryFee, totalPrice, orders);
//        orderListRepository.save(orderList);
//        OrderDto orderDto = new OrderDto();
//        orderDto.setRestaurantName(cafeName);
//        orderDto.setDeliveryFee(deliveryFee);
//        orderDto.setTotalPrice(totalPrice);
//        orderDto.setFoods(foodOrderDtos);
//
//        return orderDto;

//    }


}