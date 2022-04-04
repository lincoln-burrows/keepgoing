package com.sparta.keepgoing.models;

import com.sparta.keepgoing.dto.FoodDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Setter
@Entity
@Getter
@NoArgsConstructor
public class Food {

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

    public Food(Long restaurantId, FoodDto foodDto){
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
        this.restaurantId = restaurantId;

    }

}