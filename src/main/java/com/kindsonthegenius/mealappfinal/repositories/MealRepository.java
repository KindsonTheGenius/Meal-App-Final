package com.kindsonthegenius.mealappfinal.repositories;

import com.kindsonthegenius.mealappfinal.models.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {

    List<Meal> findMealByDescription(String description);

}
