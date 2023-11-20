package models.Cart;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ShoppingBasket {

    private final List<ShoppingBasketItem> itemList;

    private BigDecimal totalTaxes;

    private BigDecimal totalPrices;

    public ShoppingBasket(List<ShoppingBasketItem> itemList) {
        this.itemList = itemList;
    }

    public void computeTaxes() {
        // Pour chaque entrée, on calcule les taxes et le coût total
        this.itemList.forEach(item -> {
            item.calculateTax();
            item.setTotalCost();
        });
        this.totalTaxes = itemList.stream()
                .map(x -> new BigDecimal(x.getQuantity()).multiply(x.getTax()))
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.DOWN);
        this.totalPrices = itemList.stream()
                .map(x -> new BigDecimal(x.getQuantity()).multiply(x.getTotalCost()))
                .reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2,RoundingMode.DOWN);
    }

    public String print() {
        StringBuilder builder = new StringBuilder();
        this.itemList.forEach(item ->
                builder.append(item.toString()).append("\n"));
        builder.append(String.format("Sales Taxes : %s Total : %s", this.totalTaxes, this.totalPrices));
        return builder.toString();
    }
    public BigDecimal getTotalTaxes() {
        return totalTaxes;
    }

    public BigDecimal getTotalPrices() {
        return totalPrices;
    }

}
