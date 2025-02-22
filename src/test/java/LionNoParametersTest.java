import com.example.Feline;
import com.example.Lion;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionNoParametersTest {

    @Test
    public void testInvalidSexThrowExceptionCatchingManually() {
        Feline felineMock = mock(Feline.class);
        try {
            new Lion("Другие", felineMock);
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }


    @Test
    public void testGetKittensCallsFelineMethod() throws Exception {
        Feline felineMock = mock(Feline.class);
        when(felineMock.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", felineMock);
        assertEquals(3, lion.getKittens());

        verify(felineMock, times(1)).getKittens();
    }

    @Test
    public void testGetFoodCallsFelineMethod() throws Exception {
        Feline felineMock = mock(Feline.class);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", felineMock);
        assertEquals(expectedFood, lion.getFood());
        verify(felineMock, times(1)).getFood("Хищник");
    }


    @Test
    public void testLionRealObject() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
        assertEquals(1, lion.getKittens());
        assertNotNull(lion.getFood());
    }


}