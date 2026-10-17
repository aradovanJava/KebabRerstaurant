package hr.algebra.brjakpo._2026.project.kebabrerstaurant.repository;

import hr.algebra.brjakpo._2026.project.kebabrerstaurant.model.Allergen;
import hr.algebra.brjakpo._2026.project.kebabrerstaurant.model.Meal;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MockMealRepository implements  MealRepository {

    private List<Meal> allMeals;

    public MockMealRepository() {
        allMeals = new ArrayList<Meal>();
        Meal theFirstKebab = new Meal();
        theFirstKebab.setId(1L);
        theFirstKebab.setName("Döner Kebab");
        theFirstKebab.setDescription("""
                Spiced lamb, beef
                "or chicken roasted on a vertical
                "rotisserie and shaved into thin
                "slices, commonly served in flatbreads,
                wraps, or rice plates.
                """);
        theFirstKebab.setPrice(new BigDecimal(7));
        theFirstKebab.setNormative(new BigDecimal(200));
        theFirstKebab.setAllergen(List.of(Allergen.WHEAT, Allergen.MILK));

        Meal theSecondKebab = new Meal();
        theSecondKebab.setId(2L);
        theSecondKebab.setName("Shish Kebab");
        theSecondKebab.setDescription("""
                Spiced lamb, beef
                "or chicken roasted on a vertical
                "rotisserie and shaved into thin
                "slices, commonly served in flatbreads,
                wraps, or rice plates.
                """);
        theSecondKebab.setPrice(new BigDecimal(7));
        theSecondKebab.setNormative(new BigDecimal(200));
        theSecondKebab.setAllergen(List.of(Allergen.WHEAT, Allergen.MILK));

        allMeals.add(theFirstKebab);
        allMeals.add(theSecondKebab);
    }

    @Override
    public List<Meal> getAllMeals() {
        return allMeals;
    }

    @Override
    public Meal addMeal(Meal theMeal) {
        Optional<Long> theLastId = allMeals.stream()
                .map(Meal::getId)
                .max((id1, id2) -> id1.compareTo(id2));

        if(theLastId.isPresent()) {
            theMeal.setId(theLastId.get() + 1);
        }
        else {
            theMeal.setId(1L);
        }

        allMeals.add(theMeal);
        return theMeal;
    }
}
