package hr.algebra.brjakpo._2026.project.kebabrerstaurant.model;

/**
 * Java enum containing major allergen categories in 2026.
 * Includes the "Big 9" regulated food allergens, environmental triggers, and medications.
 */
public enum Allergen {
    // === THE "BIG 9" FOOD ALLERGENS ===
    MILK("Milk"),
    EGGS("Eggs"),
    FISH("Fish"),
    CRUSTACEAN_SHELLFISH("Crustacean Shellfish"),
    TREE_NUTS("Tree Nuts (e.g., almonds, walnuts, pecans)"),
    PEANUTS("Peanuts"),
    WHEAT("Wheat"),
    SOYBEANS("Soybeans"),
    SESAME("Sesame"),

    // === OTHER REGULATED / COMMON FOOD ALLERGENS ===
    CELERY("Celery"),
    MUSTARD("Mustard"),
    LUPIN("Lupin"),
    SULPHITES("Sulphites / Sulphur Dioxide"),
    MOLLUSCS("Molluscs"),

    // === ENVIRONMENTAL ALLERGENS ===
    POLLEN("Pollen (grass, trees, weeds)"),
    DUST_MITES("Dust Mites"),
    ANIMAL_DANDER("Animal Dander (cats, dogs, etc.)"),
    MOLD("Mold"),

    // === OTHER COMMON ALLERGENS ===
    LATEX("Latex"),
    PENICILLIN("Penicillin / Antibiotics"),
    INSECT_VENOM("Insect Venom (bees, wasps)");

    private final String displayName;

    // Enum constructor
    Allergen(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Returns the user-friendly display name of the allergen.
     */
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

