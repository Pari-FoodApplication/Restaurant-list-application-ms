package com.pari.foodapp.restaurantlistingapp.repo;

import com.pari.foodapp.restaurantlistingapp.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant,Integer> {
}
