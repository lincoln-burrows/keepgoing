package com.sparta.keepgoing.repository;

import com.sparta.keepgoing.models.Food;
import com.sparta.keepgoing.models.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantsRepository extends JpaRepository<Restaurants, Long> {
    Restaurants findRestaurantsById(Long restaurantId);
    Restaurants findMinOrderPriceById(Long restaurantId);
}