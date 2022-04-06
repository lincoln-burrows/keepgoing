package com.sparta.keepgoing.models;

import com.sparta.keepgoing.dto.FoodOrderDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Entity
@Getter
@NoArgsConstructor
@ToString
@Table
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int quantity;

    @Column
    private int price;

    @ManyToOne
    @JoinColumn (name = "OrderList_Id")
    private OrderList orderList;



    public FoodOrder(FoodOrderDto foodOrderDto){
        this.name = foodOrderDto.getName();
        this.quantity = foodOrderDto.getQuantity();
        this.price = foodOrderDto.getPrice();
    }

}