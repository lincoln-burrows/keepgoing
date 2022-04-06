package com.sparta.keepgoing.dto;

import com.sparta.keepgoing.models.FoodOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class OrderDto {
    private String restaurantName;
    private List<FoodOrderDto> foods;
    private int totalPrice;
    private int deliveryFee;
}