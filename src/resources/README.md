As I promised here is a new task for you on JUnit Jupiter:

Add Maven support to your project
Add JUnit Jupiter and Hamcrest(2.x) to your project
Implement following methods:
a. public double multiply(double firstNumber, double secondNumber) – where numbers could not be smaller than 0 and bigger then 100(0=> ? <= 100), if conditions are not matched return 0
b. public int subtract(int firstNumber, int secondNumber) – where both numbers could not be smaller than 0 and firstNumber could not be smaller than secondNumber, if conditions are not matched return -1
c. public double divide(double numberToBeDivided, double divisor) – where numbers could not be smaller than 0 and numberToBeDivided could not be smaller than divisor, if conditions are not matched return 0

Please cover all methods described before with unit tests using JUnit Jupiter and Hamcrest
Happy path tests (values are in accepted value range and matches given conditions)
Negative tests(values are outside of given range or doesn’t match to given conditions)
Other cases(divide by 0)
Task will be considered as done only if:
All 3 given methods will be covered with one happy Parameterized test and at least one negative Test
You have at least one usage of assertThat with matcher, you could use Matcher’s assertThat or you can write a wrapper for Matcher’s assertThat(optional task, ask me for additional details)
You have at least two different argument sources for your Parameterized tests(Method source, Enum source, CSV source, Value source,…)
You have at least one usage of assertThrows