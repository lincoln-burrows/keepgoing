package com.sparta.keepgoing.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class FoodOrderDto {
    private String name;
    private int quantity;
    private int price;
}