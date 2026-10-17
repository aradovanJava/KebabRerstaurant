package hr.algebra.brjakpo._2026.project.kebabrerstaurant.service;

import hr.algebra.brjakpo._2026.project.kebabrerstaurant.model.Meal;

import java.util.List;

public interface MealService {
    List<Meal> getMeals();
    Meal saveNewMeal(Meal theMeal);
}
