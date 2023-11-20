package models.Taxes;

import models.Product;

import java.math.BigDecimal;

public interface TaxCalculator {

    Product getProduct();

    BigDecimal calc();
}
