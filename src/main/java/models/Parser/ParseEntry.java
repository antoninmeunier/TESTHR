package models.Parser;

import models.Cart.ShoppingBasketItem;

import java.util.List;

public interface ParseEntry {

    List<ShoppingBasketItem> getEntries(List<String> rawValues);
}
