import com.example.Cat;
import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CatTest {

    @Test
    public void testCatSound() {
        Feline felineMock = mock(Feline.class);
        Cat cat = new Cat(felineMock);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testCatFoodCallsFelineMethod() throws Exception {
        Feline felineMock = mock(Feline.class);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(felineMock);
        assertEquals(expectedFood, cat.getFood());

        verify(felineMock, times(1)).eatMeat();
    }
}