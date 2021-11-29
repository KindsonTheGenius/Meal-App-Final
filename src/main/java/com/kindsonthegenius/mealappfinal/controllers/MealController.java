package com.kindsonthegenius.mealappfinal.controllers;
import com.kindsonthegenius.mealappfinal.models.Meal;
import com.kindsonthegenius.mealappfinal.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping("")
    public ResponseEntity<String>  index(){
        return new ResponseEntity<>("Welcome to the meal application with new Swagger!.", HttpStatus.OK);
    }

    //Get all meals
    @GetMapping("/meals")
    public ResponseEntity<List<Meal>> getMeals() {
        List<Meal> result = mealService.findAll();
        if (result.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok().body(result);
    }

    //Get a meal by id
    @GetMapping("/meal/{id}")
    public ResponseEntity<Meal> getMeal(@PathVariable("id") Integer id) {
        Meal meal = mealService.findById(id);
        if (meal == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok().body(meal);
    }

    //Save a meal
    @PostMapping("/meals")
    public ResponseEntity<Meal> addMeal(@RequestBody Meal meal) {
        Meal newMeal = mealService.save(meal);
        if (newMeal != null) {
            return new ResponseEntity<>(newMeal,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Update a meal
    @PutMapping("/meal/{id}")
    public  ResponseEntity<Meal> save(@PathVariable("id") Integer id, @RequestBody Meal meal){
        Meal updatedMeal = mealService.save(meal);
        if (updatedMeal != null) {
            return new ResponseEntity<>(updatedMeal, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>( HttpStatus.NOT_MODIFIED);
        }
    }

    //Delete a single meal
    @DeleteMapping("/meal/{id}")
    public ResponseEntity<String> deleteMeal(@PathVariable("id") Integer id) {
        if (mealService.delete(id)) {
            return new ResponseEntity<>("You have successfully removed the meal.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error occurred while removing a meal.", HttpStatus.BAD_REQUEST);
        }
    }

}
