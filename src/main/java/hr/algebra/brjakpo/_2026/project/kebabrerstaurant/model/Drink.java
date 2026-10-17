package hr.algebra.brjakpo._2026.project.kebabrerstaurant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Drink {
    private String name;
    private BigDecimal volume;
    private BigDecimal price;
    private String description;
}
