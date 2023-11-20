import models.Cart.ShoppingBasket;
import models.Cart.ShoppingBasketItem;
import models.Product;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;

public class TaxesTest {


    @Test
    void test() {

        Product book = new Product("book", new BigDecimal("12.49"));
        Product music = new Product("imported music CD", new BigDecimal("14.99"));
        Product tv = new Product("tv", new BigDecimal("50"));

        ShoppingBasketItem shoppingBasketBook = new ShoppingBasketItem(book, 2);
        ShoppingBasketItem shoppingBasketMusic = new ShoppingBasketItem(music, 2);
        ShoppingBasketItem shoppingBasketTV = new ShoppingBasketItem(tv, 1);
        ShoppingBasket shoppingBasket = new ShoppingBasket(Arrays.asList(shoppingBasketBook, shoppingBasketMusic,shoppingBasketTV));
        shoppingBasket.computeTaxes();

        assertThat(shoppingBasketBook.getTax(), Matchers.comparesEqualTo(new BigDecimal("0.00")));
        assertThat(shoppingBasketMusic.getTax(), Matchers.comparesEqualTo(new BigDecimal("2.25")));
        assertThat(shoppingBasketTV.getTax(), Matchers.comparesEqualTo(new BigDecimal("5.00")));
        assertThat(shoppingBasket.getTotalTaxes(), Matchers.comparesEqualTo(new BigDecimal("9.50")));
        assertThat(shoppingBasket.getTotalPrices(), Matchers.comparesEqualTo(new BigDecimal("114.46")));
    }
}
