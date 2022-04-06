package com.sparta.keepgoing.repository;

import com.sparta.keepgoing.models.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderListRepository extends JpaRepository<OrderList, Long> {
//    List<Food> findAllByRestaurantId(Long restaurantId);
//    Optional<Food> findByRestaurantIdAndName(Long restaurantId, String name);
}
