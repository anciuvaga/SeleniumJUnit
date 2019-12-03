package com.myproject.application.task2_junit_jupiter;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    Calculator arithmeticOper;


    /**
     * String csvFile;
     * String line;
     * String cvsSplitBy;
     */


    @BeforeEach
    void init() {
        arithmeticOper = new Calculator();


        /**csvFile = System.getProperty("user.dir") + "\\src\\resources\\test.csv";
         * line = "";
         * cvsSplitBy = ",";
         */

    }

    @DisplayName("Multiply positive flow")
    @Test
    void multiplyPositiveFlow() {
        double expectedResult = 25;
        double actualResult = arithmeticOper.multiply(5, 5);
        String msg = String.format("%nExpected result is: %s but must be %s%n", expectedResult, actualResult);
        assertThat(msg, actualResult, is(expectedResult));
    }

    @DisplayName("Subtract positive flow")
    @Test
    void subtractPositiveFlow() {
        int expectedResult = 5;
        int actualResult = arithmeticOper.subtract(10, 5);
        assertThat("Expected result: ", actualResult, is(expectedResult));
    }

    @DisplayName("Multiply parametrized test positive")
    @ParameterizedTest(name = "{index} -> firstNumer={0}, secondNumber={1}")
    @MethodSource("source")
    void multiplyTest(int a, int b) {
        double expected = a * b;
        double actual = arithmeticOper.multiply(a, b);
        assertThat("Asserting results: ", actual, is(expected));
    }
    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(75, 2),
                Arguments.of(2, 50)
        );
    }

    @DisplayName("Divide positive flow")
    @Test
    void dividePositiveFlow() {
        double expectedResult = 20;
        double actualResult = arithmeticOper.divide(80, 4);
        assertThat("Expected result: ", actualResult, is(expectedResult));
    }

    @DisplayName("Multiply parametrized negative tests ")
    @ParameterizedTest(name = "{index} -> firstnumber={0}, secondNumber{1}")
    @CsvSource({"-1,2", "101,2", "1,-1", "2,101", "-1,-1", "101,101"})
    void multiplyNegativeFlow(double a, double b) {
        double expected = 0;
        double actual = arithmeticOper.multiply(a, b);
        assertThat("Result: ", actual, is(expected));
    }

    @DisplayName("Subtract negative parametrized tests")
    @ParameterizedTest(name = "{index} -> firstnumber={0}, secondNumber{1}")
    @CsvSource({"1,3", "-1,2", "-1,-1", "2,-1"})
    void subtractNegativeFlow(int a, int b) {
        int expected = -1;
        int actual = arithmeticOper.subtract(a, b);
        assertThat("Assert result: ", actual, is(expected));
    }


    @ParameterizedTest
    @DisplayName("From file tests")
    @CsvFileSource(resources = "/mult.csv", numLinesToSkip = 1)
    void devideFromCsv(int operator1, int operator2, int result) {

        assertThat("Assert result: ", operator1 * operator2, is(result));
    }

    @DisplayName("Divide be Zero")
    @Test
    void divideByZeroFlow() {
        assertThrows(ArithmeticException.class, () -> arithmeticOper.divide(2, 0), "Divided By 0");
    }


    /**CSV another example
     *
     *  @DisplayName("Divide negative tests")
     *     @Test
     *     void divideNegativeFlow() {
     *         try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
     *             while ((line = br.readLine()) != null) {
     *                 String[] testItems = line.split(cvsSplitBy);
     *                 MatcherAssert.assertThat(
     *                         "Expected result: ",
     *                         arithmeticOper.divide(Double.parseDouble(testItems[0]), Double.parseDouble(testItems[1])),
     *                         is(not(Double.parseDouble(testItems[2])))
     *                 );
     *             }
     *         } catch (IOException e) {
     *             e.printStackTrace();
     *         }
     *     }
     *
     */


}