import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void testFelineEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals("Ожидаемое значение " + expectedFood, expectedFood, feline.eatMeat());
    }

    @Test
    public void testFelineGetFamily() {
        assertEquals("Ожидается Кошачьи", "Кошачьи", feline.getFamily());
    }

    @Test
    public void testFelineGetKittensDefault() {
        final int defaultKittensCount = 1;
        assertEquals("Ожидается стандартное значение котят - " + defaultKittensCount ,defaultKittensCount, feline.getKittens());
    }

    @Test
    public void testFelineGetKittensWithParam() {
        int kittensCount = 3;
        assertEquals("Ожидается стандартное значение котят - " + kittensCount,kittensCount, feline.getKittens(kittensCount));
    }
}