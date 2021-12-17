package HomeWork4;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static HomeWork4.TriangleCalculation.triangleCalculation;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    private static Logger logger = (Logger) LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAll(){
        logger.info("Test started");
        System.out.println("Метод выполнился перед всеми тестами 1 раз");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Метод выполнился перед каждым тестом");
    }

    @Test
    @DisplayName("Проверка метода Triangle при передаче отрицательного либо нулевого значения")
    void testGivenNullOrMinusSideWhenTriangleThenException(){
        assertAll(
                () -> assertThatExceptionOfType(IncorectSideException.class).isThrownBy(() -> triangleCalculation(0, 1, 1)),
                () -> assertThatExceptionOfType(IncorectSideException.class).isThrownBy(() -> triangleCalculation(-1, 1, 1)),
                () -> assertThatExceptionOfType(IncorectSideException.class).isThrownBy(() -> triangleCalculation(-1, -1, 1)),
                () -> assertThatExceptionOfType(IncorectSideException.class).isThrownBy(() -> triangleCalculation(0, -1, 0))
        );
    }

    @Test
    @DisplayName("Проверка метода Triangle с целыми числами и целым результатом")
    void testGivenIntegersSidesWhenTriangleThenCorrectResult() throws IncorectSideException{
        assertEquals(triangleCalculation(6,8,10), 24);
    }

    @Test
    @DisplayName("Проверка метода Triangle при получении нецелового значения")
    void testGivenSidesWhenTriangleThenDoubleResult() throws IncorectSideException {
        assertEquals(triangleCalculation(6,5,2.2), 5.279999999999998);
    }

    @Test
    @DisplayName("Проверка метода Triangle при передаче сторон не образующих треугольник")
    void testGivenIncorrectSidesWhenTriangleThenException(){
        assertThatExceptionOfType(IncorectSideException.class).isThrownBy(() -> triangleCalculation(1,2, 1));
    }

    @AfterEach
    void afterEach(){
        System.out.println("Метод выполнился после каждого теста");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Метод выполнился после всех тестов");
        logger.info("Tests completeds");
    }
}
