package com.sparta.keepgoing.models;

import com.sparta.keepgoing.dto.RestaurantsDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Entity
@Getter
@NoArgsConstructor
public class Restaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Long minOrderPrice;

    @Column
    private Long deliveryFee;

    public Restaurants(RestaurantsDto restaurantsDto){
        this.name = restaurantsDto.getName();
        this.minOrderPrice = restaurantsDto.getMinOrderPrice();
        this.deliveryFee = restaurantsDto.getDeliveryFee();
    }
}