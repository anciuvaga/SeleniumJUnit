package com.myproject.application.task2_junit_jupiter;

public class Calculator {

    public  double multiply(double firstNumber, double secondNumber) {
        if (firstNumber >= 0 && firstNumber <= 100 && secondNumber >= 0 && secondNumber <= 100) {
            return firstNumber * secondNumber;
        } else {
            return 0;
        }
    }

    public int subtract(int firstNumber, int secondNumber) {
        if (firstNumber > secondNumber && secondNumber >= 0) {
            return firstNumber - secondNumber;
        } else {
            return -1;
        }
    }

    public  double divide(double numberToBeDivided, double numberDivisor) {
        if (numberToBeDivided > numberDivisor && numberDivisor >= 0) {
            return numberToBeDivided / numberDivisor;
        } else {
            return 0;
        }
    }
}