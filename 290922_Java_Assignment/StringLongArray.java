public class StringLongArray {
    //Declaring String Array
    String [] people = {"Jack", "Jill", "Mary", "Andreas"};
    //Declaring Long Array
    long [] age = {40, 45, 48, 52};

    public static void main(String[] args){
        StringLongArray sample = new StringLongArray(); //Declaring Objects

        for (String people : sample.people){ //Array Iteration
            //%s is for String
            //%n is included to print sentence in a new Line
            System.out.printf("String Array: %s %n", people);
        }

        for (long age : sample.age){ //Array Iteration
            //%d for Decimal Integer
            //%n is included to print sentence in a new Line
            System.out.printf("Long Array: %d %n", age);
        }
    }
}
