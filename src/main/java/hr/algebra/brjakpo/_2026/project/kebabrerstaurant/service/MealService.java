package hr.algebra.brjakpo._2026.project.kebabrerstaurant.service;

import hr.algebra.brjakpo._2026.project.kebabrerstaurant.model.Meal;

import java.util.List;
import java.util.Optional;

public interface MealService {
    List<Meal> getMeals();
    Meal saveNewMeal(Meal theMeal);
    void deleteMeal(Meal theMealToDelete);
    Optional<Meal> getMealById(Long id);
    void updateMeal(Long id, Meal theMealToUpdate);
}
