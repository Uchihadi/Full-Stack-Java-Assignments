package OOPS;

//Creates abstract class
public abstract class AbstractClass {

    int length;
    int height;

    // Perimeter of a Rectangle
    public void perimeter_rectangle(int length, int height){

        int perimeter_rectangle = 2*length + 2*height;
        System.out.println("The Perimeter of the Rectangle is: " + perimeter_rectangle + " cm");
    }
    //Method Declaration --> No Definition, hence the Definition should be in the Child Class
    //Definition has to be added to the Child Class
    abstract protected void printMessage();

 }
