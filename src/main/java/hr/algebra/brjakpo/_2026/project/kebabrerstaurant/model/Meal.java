package hr.algebra.brjakpo._2026.project.kebabrerstaurant.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Meal {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal normative;
    private List<Allergen> allergen;
}
