package models.Taxes;

import models.Product;

import java.math.BigDecimal;

public class ImportedTaxCalculator implements TaxCalculator {

    private final TaxCalculator taxCalculator;

    public ImportedTaxCalculator(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    @Override
    public Product getProduct() {
        return this.taxCalculator.getProduct();
    }

    @Override
    public BigDecimal calc() {
        return this.taxCalculator.calc().add(this.getProduct().price().multiply(new BigDecimal("0.05")));
    }
}
