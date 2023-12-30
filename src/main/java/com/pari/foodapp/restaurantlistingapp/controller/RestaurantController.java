package com.pari.foodapp.restaurantlistingapp.controller;

import com.pari.foodapp.restaurantlistingapp.dto.RestaurantDto;
import com.pari.foodapp.restaurantlistingapp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping(path = "/restaurants")
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants(){
        List<RestaurantDto> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK) ;
    }

    @PostMapping(path = "/restaurant")
    public ResponseEntity<RestaurantDto> addRestaurant(@RequestBody RestaurantDto restaurantDto){
         RestaurantDto addedRestaurant = restaurantService.addRestaurant(restaurantDto);
        return new ResponseEntity<>(addedRestaurant, HttpStatus.OK) ;
    }

    @GetMapping(path = "/restaurant/id/{id}")
    public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable Integer id){
        return restaurantService.getRestaurantById(id);
    }

}
