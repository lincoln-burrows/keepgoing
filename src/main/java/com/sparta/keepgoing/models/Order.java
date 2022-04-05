package com.sparta.keepgoing.models;

import com.sparta.keepgoing.dto.FoodDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Entity
@Getter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Long price;

    @Column
    private Long restaurantId;

//    public Food(Long restaurantId, FoodDto foodDto){
//        this.name = foodDto.getName();
//        this.price = foodDto.getPrice();
//        this.restaurantId = restaurantId;

//    }

    public Order(Long restaurantId, FoodDto foodDto){
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
        this.restaurantId = restaurantId;

    }

}