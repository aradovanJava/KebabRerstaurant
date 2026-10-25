package hr.algebra.brjakpo._2026.project.kebabrerstaurant.service;

import hr.algebra.brjakpo._2026.project.kebabrerstaurant.model.Meal;
import hr.algebra.brjakpo._2026.project.kebabrerstaurant.repository.MealRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MealServiceImpl implements MealService {

    private MealRepository mealRepository;

    @Override
    public List<Meal> getMeals() {
        return mealRepository.getAllMeals();
    }

    @Override
    public Meal saveNewMeal(Meal theMeal) {
        return mealRepository.addMeal(theMeal);
    }

    @Override
    public void deleteMeal(Meal theMealToDelete) {
        mealRepository.deleteMeal(theMealToDelete);
    }

    @Override
    public Optional<Meal> getMealById(Long id) {
        return mealRepository.getMealById(id);
    }

    @Override
    public void updateMeal(Long id, Meal theMealToUpdate) {
        mealRepository.updateMeal(id, theMealToUpdate);
    }


}
