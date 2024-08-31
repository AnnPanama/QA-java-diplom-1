package praktikum;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;

    @Before
    public void setup() {
        burger = new Burger();
    }

    @Test
    public void successSetBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void successAddIngredient() {
        burger.addIngredient(ingredient);
        assertFalse(burger.ingredients.isEmpty());
    }

    @Test
    public void successRemoveIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void successMoveIngredient() {
        Ingredient ingredient2 = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);

        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void successGetPrice() {
        float expectedPrice = 400F;

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(200F);

        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void successGetReceipt() {
        String expectedReceipt ="(==== black bun ====)" + "\r\n"
                + "= filling cutlet =" + "\r\n"
                + "(==== black bun ====)" + "\r\n"
                + "\r\n"
                + "Price: 400,000000"+ "\r\n";

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(burger.getPrice()).thenReturn(400F);

        assertEquals(expectedReceipt,burger.getReceipt());
    }
}