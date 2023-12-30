package com.pari.foodapp.restaurantlistingapp.mapper;
import com.pari.foodapp.restaurantlistingapp.dto.RestaurantDto;
import com.pari.foodapp.restaurantlistingapp.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantDtoToRestaurant(RestaurantDto restaurantDto);
    RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);

}
