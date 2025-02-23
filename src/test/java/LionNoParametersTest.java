import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionNoParametersTest {

    private Feline felineMock;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        felineMock = mock(Feline.class);
        lion = new Lion("Самец", felineMock);
    }

    @Test
    public void testInvalidSexThrowException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Другие", felineMock));
        assertEquals("Исключение выдало неверное значение", "Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void testGetKittensCallsGetKittensMethod() throws Exception {
        lion.getKittens();
        verify(felineMock, times(1)).getKittens();
    }

    @Test
    public void testGetKittensReturnsExpectedValue() throws Exception {
        int kittensCount = 3;
        when(felineMock.getKittens()).thenReturn(kittensCount);
        assertEquals("Ожидаемое значение " + kittensCount, kittensCount, lion.getKittens());
    }

    @Test
    public void testGetFoodCallsFelineGetFoodMethod() throws Exception {
        lion.getFood();
        verify(felineMock, times(1)).getFood("Хищник");
    }

    @Test
    public void testGetFoodReturnsExpectedValue() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        assertEquals("Ожидаемое значение " + expectedFood, expectedFood, lion.getFood());
    }
}