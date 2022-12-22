import StaticClassesEnumsExceptions.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {

    @BeforeAll
    public static void classSetup(){
        System.out.println("Before all method");
    }
    @AfterAll
    public static void classTearDown(){
        System.out.println("After all method");
    }
    @BeforeEach
    public void beforeTest(){
        System.out.println("Before each method");
    }


    @ParameterizedTest
    @ValueSource(ints={-10,0, 27,67803039, -4567899})
    public void summaryParamsTest(int a){
        double b=6;
        double expectedResult=b+a;
        double actualResult = Calculator.calculate(a,b, Calculator.Type.SUMMARY);
        assertEquals(expectedResult,actualResult,"Summary result is incorrect");
    }



    @ParameterizedTest
    @EnumSource(Calculator.Type.class)
    public void calculationTypesTest(Calculator.Type type){
        double a=5;
        double b=6;
        double actualResult = Calculator.calculate(a,b,type);
        assertNotNull(actualResult);
        assertTrue(actualResult>0);
    }

    @ParameterizedTest
    @CsvSource ({"2,2,4, SUMMARY","4,2,2, DIVISION"})

    public void csvSourceTest(double a,double b, double expectedResult, Calculator.Type type){
        double actualResult=Calculator.calculate(a,b,type);
        assertEquals(expectedResult, actualResult);
    }


    static Stream<Arguments> dataProvider(){
        return Stream.of(
                Arguments.of(2,2,4,Calculator.Type.SUMMARY),
                Arguments.of(5,2,3,Calculator.Type.SUBTRACTION),
                Arguments.of(2,3,6,Calculator.Type.MULTIPLICATION),
                Arguments.of(4,2,2,Calculator.Type.DIVISION)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")

    public void methodSourceTest(double a,double b, double expectedResult, Calculator.Type type){
      double actualResult=Calculator.calculate(a,b,type);
      assertEquals(expectedResult, actualResult);
    }


    @Test
    public void summaryTest(){
        double a=5;
        double b=6;
        double expectedResult=10;
        double actualResult = Calculator.calculate(a,b, Calculator.Type.SUMMARY);
        assertEquals(expectedResult,actualResult,"Summary result is incorrect");
    }
    @Test
    public void divisionTest(){
        double a=10;
        double b=5;
        double expectedResult=2;

        double actualResult = Calculator.calculate(a,b, Calculator.Type.DIVISION);
        //assertNull();
        assertNotNull(actualResult,"null was returned");
        assertEquals(expectedResult,actualResult,"Division result is incorrect");
        assertTrue(expectedResult==actualResult);
        assertTrue(actualResult>0);
        assertFalse(actualResult==0);
    }
    @Test
    @DisplayName("NullPointer Exception test")
    public void errorTst(){
        double a=10;
        double b=2;
        double expectedResult=7;

        assertThrows(NullPointerException.class,() ->{Calculator.calculate(a,b, null);});

    }
}
