package ExceptionMgmt;

// Creating a Custom Exception Class that will inherit Exception from Java Libraries
public class CustomException extends Exception {

    // If errors occurs, the super command will print out the Message in the Array Page
    // The Error Message will inherit from the checkName section statement
    CustomException(String Message){
        super(Message);
    }
}
