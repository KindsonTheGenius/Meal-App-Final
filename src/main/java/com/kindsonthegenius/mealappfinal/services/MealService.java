package com.kindsonthegenius.mealappfinal.services;

import com.kindsonthegenius.mealappfinal.models.Meal;
import com.kindsonthegenius.mealappfinal.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository repository;

    //Get All
    public List<Meal> findAll(){
        return repository.findAll();
    }

    //Get by Id
    public Meal findById(int id){
        return repository.findById(id).orElse(null);
    }

    //Post new meal
    public Meal save(Meal meal){
        Meal newMeal = repository.save(meal);
        return newMeal;
    }

    //Delete Meal
    public boolean delete(int id){
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

}
