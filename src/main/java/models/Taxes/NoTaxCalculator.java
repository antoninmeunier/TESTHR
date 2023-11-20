package models.Taxes;

import models.Product;

import java.math.BigDecimal;

public class NoTaxCalculator implements TaxCalculator {

    private final Product product;

    public NoTaxCalculator(Product product) {
        this.product = product;
    }

    @Override
    public Product getProduct() {
        return this.product;
    }

    @Override
    public BigDecimal calc() {
        return BigDecimal.ZERO;
    }
}
