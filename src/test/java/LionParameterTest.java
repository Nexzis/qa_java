import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class LionParameterTest {

    private final String sex;
    private final boolean expectedHasMane;

    public LionParameterTest(String sex, boolean expectedHasMane) {
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
}