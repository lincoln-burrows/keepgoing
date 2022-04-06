package com.sparta.keepgoing.service;

import com.sparta.keepgoing.dto.FoodDto;
import com.sparta.keepgoing.models.Food;
import com.sparta.keepgoing.models.Restaurants;
import com.sparta.keepgoing.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
    public void registerFood(Long restaurantId, List<FoodDto> foodDtos) {
            List<Food> checkedFood = new ArrayList<>();
//        for (FoodDto foodDto : foodDtos) {
        for (int i = 0; i<foodDtos.size(); i++){
                FoodDto foodDto = foodDtos.get(i);
            String temp = foodDto.getName();
            System.err.println("name= "+ temp);
            Long pay = foodDto.getPrice();
            if (pay<100 || pay>1000000) {
                throw new IllegalArgumentException();}
            else if (pay%100 !=0) {
                throw new IllegalArgumentException();}

            Optional<Food> found = foodRepository.findByRestaurantIdAndName(restaurantId, temp);

//            System.err.println("size= "+ found.size());
            if(found.isPresent()){throw new IllegalArgumentException();}
            for(int j = i+1; j < foodDtos.size(); j++) {
                FoodDto foodDto2 = foodDtos.get(j);
                if(foodDto.getName().equals(foodDto2.getName())){
                    throw new IllegalArgumentException();
                }


            }

            Food food = new Food(restaurantId, foodDto);
            checkedFood.add(food);
        }
        for (Food passedFood : checkedFood ){
            foodRepository.save(passedFood);
        }
    }

    public List<Food> showFood(Long restaurantId) {

    return foodRepository.findAllByRestaurantId(restaurantId);


        //        List<Food> temp = foodRepository.findAll();
//        FoodDto[] foodsResponse = temp.getBody();
//        for (int i = 0; i < temp.size(); i++) {
//            FoodDto temp2 = Arrays.stream(foodsResponse)
//                    .filter(food -> "food"+i.getRestaurantId().equals(food.getRestaurantId()))
//                    .findAny()
//                    .orElse(null);
//            return
        }
    }
