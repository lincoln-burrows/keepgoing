package com.sparta.keepgoing.repository;

import com.sparta.keepgoing.models.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<FoodOrder, Long> {
//    List<Food> findAllByRestaurantId(Long restaurantId);
//    Optional<Food> findByRestaurantIdAndName(Long restaurantId, String name);
}