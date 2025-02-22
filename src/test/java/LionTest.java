import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean expectedHasMane;

    public LionTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void testLionManeWithDifferentSex() throws Exception {
        Feline felineMock = mock(Feline.class);
        Lion lion = new Lion(sex , felineMock);
        assertEquals(expectedHasMane, lion.doesHaveMane());

    }

    @Test
    public void testInvalidSexThrowException() throws Exception {
        Feline felineMock = mock(Feline.class);
        Lion lion = new Lion("Самка", felineMock);
        Exception exception = assertThrows(Exception.class, () -> new Lion("Другие", felineMock));
        assertEquals("Не соответствует ", "Используйте допустимые значения пола животного - самец или самка" , exception.getMessage());
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
}
