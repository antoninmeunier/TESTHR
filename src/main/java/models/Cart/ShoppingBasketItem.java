package models.Cart;

import models.Category;
import models.Product;
import models.Taxes.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class ShoppingBasketItem {

    private final Product product;
    private final int quantity;
    private BigDecimal tax;
    private BigDecimal totalCost;

    public ShoppingBasketItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void calculateTax() {
        TaxCalculator calculator = new NoTaxCalculator(this.product);
        if (Arrays.stream(Category.class.getEnumConstants()).noneMatch(this.product::isExempted)) {
            calculator = new BasicTaxCalculator(calculator);
        }
        if (this.product.isImported()) {
            calculator = new ImportedTaxCalculator(calculator);
        }
        calculator = new RounderTax(calculator);
        this.tax = calculator.calc();

    }

    public void setTotalCost() {
        this.totalCost = this.product.price().add(this.getTax()).setScale(2, RoundingMode.DOWN);
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %s", this.getQuantity(), this.getProduct().name(), this.getTotalCost());
    }
}
