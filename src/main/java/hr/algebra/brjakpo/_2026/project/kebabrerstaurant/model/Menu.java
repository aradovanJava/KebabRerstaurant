package hr.algebra.brjakpo._2026.project.kebabrerstaurant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Menu {
    private List<Meal> meals;
    private List<Drink> drinks;
}
