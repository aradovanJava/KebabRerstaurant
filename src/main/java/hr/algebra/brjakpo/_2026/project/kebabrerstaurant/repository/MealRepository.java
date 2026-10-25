package hr.algebra.brjakpo._2026.project.kebabrerstaurant.repository;

import hr.algebra.brjakpo._2026.project.kebabrerstaurant.model.Meal;

import java.util.List;
import java.util.Optional;

public interface MealRepository {
    List<Meal> getAllMeals();
    Meal addMeal(Meal theMeal);
    void deleteMeal(Meal theMealToDelete);
    Optional<Meal> getMealById(Long id);
    void updateMeal(Long id, Meal theMealToUpdate);
}
