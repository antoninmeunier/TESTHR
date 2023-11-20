package models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public record Product(String name, BigDecimal price) {

    private static final Map<Category, List<String>> itemsAssociations = Map.of(
            Category.BOOK, List.of("book"),
            Category.FOOD, Arrays.asList("chocolate", "chocolates"),
            Category.MEDICAL, List.of("pills"));

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price.setScale(2, RoundingMode.DOWN);
    }

    public boolean isExempted(Category category) {
        if (itemsAssociations.containsKey(category)) {
            return itemsAssociations.get(category)
                    .stream()
                    .anyMatch(name::contains);
        } else return false;
    }

    public boolean isImported() {
        return this.name.contains("imported");
    }

    @Override
    public String toString() {
        return String.format("%s : %s", this.name, this.price);
    }
}
