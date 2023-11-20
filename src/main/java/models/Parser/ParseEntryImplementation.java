package models.Parser;

import models.Cart.ShoppingBasketItem;
import models.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseEntryImplementation implements ParseEntry {

    public static final Pattern linePattern = Pattern.compile("(\\d+) ([\\w\\s]* )at (\\d+.\\d{2})");

    @Override
    public List<ShoppingBasketItem> getEntries(List<String> rawValues) {
        List<ShoppingBasketItem> items = new ArrayList<>();
        rawValues.forEach(raw -> {
            Matcher m = linePattern.matcher(raw);
            if (m.find()) {
                int quantity = Integer.parseInt(m.group(1));
                String name = m.group(2);
                BigDecimal price = new BigDecimal(m.group(3));
                Product product = new Product(name, price);
                items.add(new ShoppingBasketItem(product, quantity));
            } else {
                throw new RuntimeException("Can't parse the given line");
            }
        });
        return items;
    }
}
