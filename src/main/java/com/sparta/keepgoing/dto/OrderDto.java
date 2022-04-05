package com.sparta.keepgoing.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OrderDto {
    private String name;
    private Long price;
}