package com.sparta.keepgoing.service;

import com.sparta.keepgoing.dto.RestaurantsDto;
import com.sparta.keepgoing.models.Restaurants;
import com.sparta.keepgoing.repository.RestaurantsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantsService {

    private final RestaurantsRepository restaurantsRepository;

    public Restaurants registerRestaurants(RestaurantsDto restaurantsDto) {
        if(restaurantsDto.getMinOrderPrice() < 1000 || restaurantsDto.getMinOrderPrice() > 100000) {
            throw new IllegalArgumentException("주문금액은 1000원 이상 100000원 미만입니다.");}
        if(restaurantsDto.getMinOrderPrice() % 100 != 0) {
            throw new IllegalArgumentException("100원 단위만 입력해주세요.");}
        if(restaurantsDto.getDeliveryFee() < 0 || restaurantsDto.getDeliveryFee() > 10000) {
            throw new IllegalArgumentException("배달비는 10000원 이하 입니다.");}
        if(restaurantsDto.getDeliveryFee() % 500 != 0) {
            throw new IllegalArgumentException("배달비는 500원 단위로 입력해주세요.");
        }
        Restaurants restaurants = new Restaurants(restaurantsDto);
        restaurantsRepository.save(restaurants);
        return restaurants;
    }

    public List<Restaurants> showRestaurants() {
        return restaurantsRepository.findAll();
    }
}