package com.kindsonthegenius.mealappfinal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "meal", schema = "public")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String meal_name;
    private Double price;
    private String ingredients;
    private Boolean spicy;
    private Boolean gluton_free;
    private String description;
    private Double kcal;
    private String imageUrl;
}
