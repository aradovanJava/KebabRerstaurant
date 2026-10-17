package hr.algebra.brjakpo._2026.project.kebabrerstaurant.controller;

import hr.algebra.brjakpo._2026.project.kebabrerstaurant.form.MealForm;
import hr.algebra.brjakpo._2026.project.kebabrerstaurant.model.Allergen;
import hr.algebra.brjakpo._2026.project.kebabrerstaurant.model.Meal;
import hr.algebra.brjakpo._2026.project.kebabrerstaurant.model.Menu;
import hr.algebra.brjakpo._2026.project.kebabrerstaurant.service.MealService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("menu")
public class MenuController {

    private MealService mealService;

    @GetMapping
    private String getMenu(Model model) {

        List<Meal> meals = mealService.getMeals();

        Menu menu = new Menu();
        menu.setMeals(meals);

        model.addAttribute("menu", menu);

        return "menu";
    }

    @GetMapping("new-meal")
    public String getNewMeal(Model model) {

        MealForm mealForm = new MealForm();
        mealForm.setAllergen(
                Arrays.stream(
                        Allergen.values()).toList()
                        .stream().map(
                                al -> al.getDisplayName()).toList());

        model.addAttribute("mealForm", mealForm);
        return  "new-meal";
    }

    @PostMapping("new-meal")
    public String createNewMeal(MealForm mealForm, Model model) {
        Meal newMeal = new Meal();
        newMeal.setName(mealForm.getName());
        newMeal.setDescription(mealForm.getDescription());
        newMeal.setPrice(mealForm.getPrice());
        newMeal.setNormative(mealForm.getNormative());

        List<Allergen> allergens = new ArrayList<>();

        for(String allergen : mealForm.getAllergen()) {

            Arrays.stream(Allergen.values())
                    .filter(a -> a.getDisplayName().equals(allergen))
                    .findFirst()
                    .ifPresent(allergens::add);
        }

        newMeal.setAllergen(allergens);

        mealService.saveNewMeal(newMeal);

        return "redirect:/menu";
    }


}
