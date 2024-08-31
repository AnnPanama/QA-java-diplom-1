package praktikum;

import org.junit.*;

import static org.junit.Assert.*;

public class BunTest {
    private Bun bun;
    private String nameBun = "black bun";
    private float priceBun = 100;

    @Before
    public void setup() {
        bun = new Bun(nameBun, priceBun);
    }

    @Test
    public void successGetNameOfBun() {
        assertEquals(nameBun, bun.getName());
    }

    @Test
    public void successGetPriceOfBun() {
        assertEquals(priceBun, bun.getPrice(), 0);
    }
}