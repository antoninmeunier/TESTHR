package models.Taxes;

import models.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RounderTax implements TaxCalculator {

    private final TaxCalculator taxCalculator;

    public RounderTax(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    @Override
    public Product getProduct() {
        return this.taxCalculator.getProduct();
    }

    @Override
    public BigDecimal calc() {
        BigDecimal divided = this.taxCalculator.calc().divide(new BigDecimal("0.05"), 0, RoundingMode.UP);
        BigDecimal result = divided.multiply(new BigDecimal("0.05"));
        return result.setScale(2,RoundingMode.DOWN);
    }
}
