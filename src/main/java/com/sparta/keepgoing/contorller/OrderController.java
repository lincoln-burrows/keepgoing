package com.sparta.keepgoing.contorller;

import com.sparta.keepgoing.dto.FoodDto;
import com.sparta.keepgoing.models.Food;
import com.sparta.keepgoing.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class OrderController {


    private final FoodService foodService;

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodDtos){
        foodService.registerFood(restaurantId, foodDtos);

    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> showFood(@PathVariable Long restaurantId){return foodService.showFood(restaurantId);
    }


}
