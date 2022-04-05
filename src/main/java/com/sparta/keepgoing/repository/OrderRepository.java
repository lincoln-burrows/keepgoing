package com.sparta.keepgoing.repository;

import com.sparta.keepgoing.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Food, Long> {
    List<Food> findAllByRestaurantId(Long restaurantId);
    Optional<Food> findByRestaurantIdAndName(Long restaurantId, String name);
}
