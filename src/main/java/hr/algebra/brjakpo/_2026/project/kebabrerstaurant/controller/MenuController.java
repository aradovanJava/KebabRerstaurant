package hr.algebra.brjakpo._2026.project.kebabrerstaurant.controller;

import hr.algebra.brjakpo._2026.project.kebabrerstaurant.form.MealForm;
import hr.algebra.brjakpo._2026.project.kebabrerstaurant.model.Allergen;
import hr.algebra.brjakpo._2026.project.kebabrerstaurant.model.Meal;
import hr.algebra.brjakpo._2026.project.kebabrerstaurant.model.Menu;
import hr.algebra.brjakpo._2026.project.kebabrerstaurant.service.MealService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

        //mealForm.setAllergen(List.of(Allergen.MILK.toString()));
        mealForm.setAllergen(
                Arrays.stream(
                        Allergen.values()).toList()
                        .stream().map(
                                al -> al.getDisplayName()).toList());
        //mealForm.setSelectedAllergen(List.of(Allergen.MILK.toString()));


        model.addAttribute("mealForm", mealForm);
        return  "new-meal";
    }

    @PostMapping("new-meal")
    public String createNewMeal(@Valid MealForm mealForm, BindingResult result,
                                RedirectAttributes redirect) {

        mealForm.setAllergen(
                Arrays.stream(
                                Allergen.values()).toList()
                        .stream().map(
                                al -> al.getDisplayName()).toList());

        if(result.hasErrors()) {
            return "new-meal";
        }

        Meal newOrUpdatedMeal = new Meal();
        newOrUpdatedMeal.setId(mealForm.getId());
        newOrUpdatedMeal.setName(mealForm.getName());
        newOrUpdatedMeal.setDescription(mealForm.getDescription());
        newOrUpdatedMeal.setPrice(mealForm.getPrice());
        newOrUpdatedMeal.setNormative(mealForm.getNormative());

        List<Allergen> selectedAllergens = new ArrayList<>();

        for(String allergen : mealForm.getSelectedAllergen()) {
            Arrays.stream(Allergen.values())
                    .filter(a -> a.getDisplayName().equals(allergen))
                    .findFirst()
                    .ifPresent(selectedAllergens::add);
        }

        newOrUpdatedMeal.setAllergen(selectedAllergens);

        if(Optional.ofNullable(newOrUpdatedMeal.getId()).isPresent()) {
            mealService.updateMeal(mealForm.getId(), newOrUpdatedMeal);
        }
        else {
            mealService.saveNewMeal(newOrUpdatedMeal);
        }


        return "redirect:/menu";
    }

    @GetMapping("{id}/update")
    public String getUpdateMeal(Model model, @PathVariable long id) {
        Optional<Meal> mealOptional = mealService.getMealById(id);
        if(mealOptional.isPresent()) {
            Meal meal = mealOptional.get();
            MealForm mealForm = new MealForm();
            mealForm.setId(meal.getId());
            mealForm.setName(meal.getName());
            mealForm.setDescription(meal.getDescription());
            mealForm.setPrice(meal.getPrice());
            mealForm.setNormative(meal.getNormative());
            mealForm.setAllergen(
                    Arrays.stream(
                                    Allergen.values()).toList()
                            .stream().map(
                                    al -> al.getDisplayName()).toList());
            mealForm.setSelectedAllergen(meal.getAllergen().stream().map(a -> a.getDisplayName()).toList());
            model.addAttribute("mealForm", mealForm);
        }

        return "new-meal";
    }

    @PostMapping("{id}/delete")
    public String removeMeal(@PathVariable Long id
                             /*RedirectAttributes flash*/) {
        Optional<Meal> mealToDeleteOptional = mealService.getMealById(id);

        if(mealToDeleteOptional.isPresent()) {
            mealService.deleteMeal(mealToDeleteOptional.get());
            //flash.addFlashAttribute("message", "item.removed");
        }
        else {
            //flash.addFlashAttribute("message", "item.removed");
        }

        return "redirect:/menu";
    }

    @PostMapping("{id}/update")
    public String updateMeal(@PathVariable Long id, MealForm mealForm
            /*RedirectAttributes flash*/) {
        Optional<Meal> mealToUpdateOptional = mealService.getMealById(id);

        if(mealToUpdateOptional.isPresent()) {
            Meal newMeal = new Meal();
            newMeal.setName(mealForm.getName());
            newMeal.setDescription(mealForm.getDescription());
            newMeal.setPrice(mealForm.getPrice());
            newMeal.setNormative(mealForm.getNormative());
            mealService.updateMeal(id, newMeal);
            //flash.addFlashAttribute("message", "item.removed");
        }
        else {
            //flash.addFlashAttribute("message", "item.removed");
        }

        return "redirect:/menu";
    }


}
