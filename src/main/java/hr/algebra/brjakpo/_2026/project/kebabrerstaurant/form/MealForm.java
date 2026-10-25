package hr.algebra.brjakpo._2026.project.kebabrerstaurant.form;

import hr.algebra.brjakpo._2026.project.kebabrerstaurant.model.Allergen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MealForm {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal normative;
    private List<String> allergen;
}
