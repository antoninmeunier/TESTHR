import models.Cart.ShoppingBasket;
import models.Cart.ShoppingBasketItem;
import models.Parser.ParseEntry;
import models.Parser.ParseEntryImplementation;

import java.util.Arrays;
import java.util.List;

public class main {

    public static void main(String[] args) {

        // INPUTS
        List<String> entry1 = Arrays.asList(
                "1 book at 12.49",
                "1 music CD at 14.99",
                "1 chocolate bar at 0.85");

        List<String> entry2 = Arrays.asList(
                "1 imported box of chocolates at 10.00",
                "1 imported bottle of perfume at 47.50"
        );

        List<String> entry3 = Arrays.asList(
                "1 imported bottle of perfume at 27.99",
                "1 bottle of perfume at 18.99",
                "1 packet of headache pills at 9.75",
                "1 box of imported chocolates at 11.25");

        // On parse nos entrées
        ParseEntry entry = new ParseEntryImplementation();
        List<ShoppingBasketItem> entries1 = entry.getEntries(entry1);
        ShoppingBasket shoppingBasket = new ShoppingBasket(entries1);
        shoppingBasket.computeTaxes();
        System.out.println("--------------------------------------");
        System.out.println("input 1");
        System.out.println(shoppingBasket.print());
        System.out.println("--------------------------------------");
        System.out.println("input 2");
        List<ShoppingBasketItem> entries2 = entry.getEntries(entry2);
        ShoppingBasket shoppingBasket2 = new ShoppingBasket(entries2);
        shoppingBasket2.computeTaxes();
        System.out.println(shoppingBasket2.print());
        System.out.println("--------------------------------------");
        System.out.println("input 3");
        List<ShoppingBasketItem> entries3 = entry.getEntries(entry3);
        ShoppingBasket shoppingBasket3 = new ShoppingBasket(entries3);
        shoppingBasket3.computeTaxes();
        System.out.println(shoppingBasket3.print());
    }
}
