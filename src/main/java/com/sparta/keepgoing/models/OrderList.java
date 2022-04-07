package com.sparta.keepgoing.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Setter
@Entity
@Getter
@NoArgsConstructor
@ToString
@Table
public class OrderList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String restaurantName;

    @Column
    private int deliveryFee;

    @Column
    private int totalPrice;

    @OneToMany
    @JoinColumn
    private List<FoodOrder> foods;


    public OrderList(String cafeName, int deliveryFee, int totalPrice, List<FoodOrder> foods){
        this.restaurantName = cafeName;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
        this.foods = foods;
    }
//    public OrderList(OrderDto orderDto){
//        this.restaurantName = orderDto.getRestaurantName();
//        this.foods = orderDto.getFoods();
//        this.deliveryFee = orderDto.getDeliveryFee();
//        this.totalPrice = orderDto.getTotalPrice();
//    }

}