package praktikum;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {
    private Ingredient ingredient;
    private IngredientType ingredientType;
    private String ingredientName;
    private float ingredientPrice;

    public IngredientTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters
    public static Object[] dataIngredient() {
        return new Object[][]{
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "dinosaur", 200}
        };
    }

    @Before
    public void setup() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @Test
    public void successGetPriceOfIngredient() {
        assertEquals(ingredientPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void successGetNameOfIngredient() {
        assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void successGetIngredientTypeOfIngredient() {
        assertEquals(ingredientType, ingredient.getType());
    }
}