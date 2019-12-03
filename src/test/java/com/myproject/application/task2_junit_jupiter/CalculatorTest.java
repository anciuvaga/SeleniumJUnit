package com.myproject.application.task2_junit_jupiter;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class CalculatorTest {
    Calculator arithmeticOper;
    String csvFile;
    String line;
    String cvsSplitBy;

    @BeforeEach
    void init() {
        arithmeticOper = new Calculator();
        csvFile = System.getProperty("user.dir") + "\\src\\resources\\test.csv";
        line = "";
        cvsSplitBy = ",";
    }

    @Test
    void multiplyPositiveFlow() {
        double expectedResult = 25;
        double actualResult = arithmeticOper.multiply(5, 5);
        MatcherAssert.assertThat("Expected result: ", actualResult, is(expectedResult));
    }

    @Test
    void subtractPositiveFlow() {
        int expectedResult = 5;
        int actualResult = arithmeticOper.subtract(10, 5);
        MatcherAssert.assertThat("Expected result: ", actualResult, is(expectedResult));

    }

    @Test
    void dividePositiveFlow() {
        double expectedResult = 20;
        double actualResult = arithmeticOper.divide(80, 4);
        MatcherAssert.assertThat("Expected result: ", actualResult, is(expectedResult));
    }

    @Test
    void multiplyNegativeFlow() {
        assertAll(
                () -> assertNotEquals(-2, arithmeticOper.multiply(-1, 2), ""),
                () -> assertNotEquals(202, arithmeticOper.multiply(101, 2), ""),
                () -> assertNotEquals(-1, arithmeticOper.multiply(1, -1), ""),
                () -> assertNotEquals(202, arithmeticOper.multiply(2, 101), ""),
                () -> assertNotEquals(1, arithmeticOper.multiply(-1, -1), ""),
                () -> assertNotEquals(10201, arithmeticOper.multiply(101, 101), "")
        );
    }

    @Test
    void subtractNegativeFlow() {
        assertAll(
                () -> assertNotEquals(-2, arithmeticOper.subtract(1, 3), ""),
                () -> assertNotEquals(-3, arithmeticOper.subtract(-1, 2), ""),
                () -> assertNotEquals(-2, arithmeticOper.subtract(-1, -1), ""),
                () -> assertNotEquals(3, arithmeticOper.subtract(2, -1), "")
        );
    }

    @Test
    void divideNegativeFlow() {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] testItems = line.split(cvsSplitBy);
                MatcherAssert.assertThat(
                        "Expected result: ",
                        arithmeticOper.divide(Double.parseDouble(testItems[0]), Double.parseDouble(testItems[1])),
                        is(not(Double.parseDouble(testItems[2])))
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void divideByZeroFlow() {
        assertThrows(ArithmeticException.class, () -> arithmeticOper.divide(2, 0), "Divided By 0");
    }
}