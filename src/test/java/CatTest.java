import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CatTest {

    private Feline felineMock;
    private Cat cat;

    @Before
    public void setUp() {
        felineMock = mock(Feline.class);
        cat = new Cat(felineMock);
    }

    @Test
    public void testCatSound() {
        assertEquals("Cat Издаёт неверный звук", "Мяу", cat.getSound());
    }

    @Test
    public void testCatFoodCallsEatMeatMethod() throws Exception {
        cat.getFood();
        verify(felineMock, times(1)).eatMeat();
    }

    @Test
    public void testCatFoodReturnsExpectedValue() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        assertEquals("Ожидаемое значение " + expectedFood, expectedFood, cat.getFood());
    }

}