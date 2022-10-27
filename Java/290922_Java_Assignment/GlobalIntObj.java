public class GlobalIntObj {
    // Global Variables: Declaring Int Array
    int[] age = {45, 40, 35, 30, 25, 15};

    public static void main(String[] args) {
        GlobalIntObj sample = new GlobalIntObj(); // Declaring Objects

        for (int age : sample.age) { //Array Iteration
            if (age > 35) { //If-Else Statement
                //%n is included to print sentence in a new Line
                System.out.printf("You are old because your age is greater than 35.%n", age);

            } else {
                //%n is included to print sentence in a new Line
                System.out.printf("You are young because your age is lesser than 35.%n", age);
            }
        }
    }
}
