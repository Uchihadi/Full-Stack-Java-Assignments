package OOPS;

// Child class inherits from the Protected Abstract Class
// Public Classes Interface1 & Interface2 is inherited over here

public class ChildAbstract extends AbstractClass implements Interface1, Interface2 {

    public static void main(String[] Args){

        // Creating a new class from AbstractClass
        // Declaring values for the Abstract Class perimeter_rectangle
        AbstractClass perimeter1 = new ChildAbstract();
        perimeter1.perimeter_rectangle(5, 8);

        //Prints Message from Abstract Class with values declared on line 12
        perimeter1.printMessage();

        // Creating a new class from Interface1
        // Declaring values through perimeter2 class
        Interface1 perimeter2 = new ChildAbstract();
        perimeter2.perimeter_triangle(4, 5, 6);

        // Creating a new class from Interface2
        // Declaring values through perimeter3 class
        Interface2 perimeter3 = new ChildAbstract();
        perimeter3.perimeter_pentagon(8);
    }

    @Override //Overriding the value retrieved from the line 12 above
    protected void printMessage() {
        System.out.println("Value Have Been Override from Abstract Class");
    }

    @Override //Retrieving values from above for Triangle Perimeter Calculation
    public void perimeter_triangle(int a, int b, int c) {
        int triangle = a + b + c;
        System.out.println("The Perimeter of Triangle: " + triangle + " cm");
    }

    @Override //Retrieving values from above for Pentagon Perimeter Calculation
    public void perimeter_pentagon(int z) {
        int pentagon = 5*z;
        System.out.println("The Perimeter of the Pentagon: " + pentagon + " cm");
    }
}
