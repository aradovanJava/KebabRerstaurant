package hr.algebra.brjakpo._2026.project.kebabrerstaurant.form;

import hr.algebra.brjakpo._2026.project.kebabrerstaurant.model.Allergen;
import jakarta.validation.constraints.*;
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
    @NotEmpty
    @Size(min = 3, max = 100)
    private String name;

    @NotEmpty
    @Size(min = 5, max = 200)
    private String description;

    @Positive
    private BigDecimal price;

    @NotNull
    @Positive
    private BigDecimal normative;
    private List<String> allergen;
    private List<String> selectedAllergen;
}
