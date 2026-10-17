package hr.algebra.brjakpo._2026.project.kebabrerstaurant.repository;

import hr.algebra.brjakpo._2026.project.kebabrerstaurant.model.Meal;

import java.util.List;

public interface MealRepository {
    List<Meal> getAllMeals();
    Meal addMeal(Meal theMeal);
}
