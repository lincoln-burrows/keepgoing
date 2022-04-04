package com.sparta.keepgoing.contorller;


import com.sparta.keepgoing.dto.FoodDto;
import com.sparta.keepgoing.dto.RestaurantsDto;
import com.sparta.keepgoing.models.Food;
import com.sparta.keepgoing.models.Restaurants;
import com.sparta.keepgoing.service.FoodService;
import com.sparta.keepgoing.service.RestaurantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantsController {

    private final RestaurantsService restaurantsService;

    @PostMapping("restaurant/register")
    public Restaurants registerRestaurants(@RequestBody RestaurantsDto restaurantsDto){
        return restaurantsService.registerRestaurants(restaurantsDto);
    }

    @GetMapping("restaurants")
    public List<Restaurants> showRestaurants(){
        return restaurantsService.showRestaurants();
    }


}