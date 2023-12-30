package com.pari.foodapp.restaurantlistingapp.service;

import com.pari.foodapp.restaurantlistingapp.dto.RestaurantDto;
import com.pari.foodapp.restaurantlistingapp.entity.Restaurant;
import com.pari.foodapp.restaurantlistingapp.mapper.RestaurantMapper;
import com.pari.foodapp.restaurantlistingapp.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;

    public List<RestaurantDto> getAllRestaurants(){
        List<Restaurant> restaurants = restaurantRepo.findAll();
        List<RestaurantDto> restaurantDtoList = restaurants.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant)).collect(Collectors.toList());
        return  restaurantDtoList;
    }

    public RestaurantDto addRestaurant(RestaurantDto restaurantDto){
        Restaurant restaurant = RestaurantMapper.INSTANCE.mapRestaurantDtoToRestaurant(restaurantDto);
        Restaurant addedRestaurant = restaurantRepo.save(restaurant);
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(addedRestaurant);
    }
    public ResponseEntity<RestaurantDto> getRestaurantById(Integer id){
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        if(restaurant.isPresent()){
            RestaurantDto restaurantDto = RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant.get());
            return new ResponseEntity<>(restaurantDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
