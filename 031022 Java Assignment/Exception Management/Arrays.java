package ExceptionMgmt;

public class Arrays {
    public static void main(String[] args){

        // String Arrays of Name List
        System.out.println("Here are members of Full Stack Java Development Class");
        String[] Name = new String[] {"Erling", "John", "Phil", "Harry"};

        // To check if the index of the Name is inside the List No. using Try-Catch
        try {
            checkName(8, Name);
        }
        catch (CustomException e) {
            //Print Stack Trace will be printed with error Reports after Final Statement
            e.printStackTrace();

            //If Error Occurs, Custom Exception msg prints here with +e.getMessage()
            System.out.println("Please double check your arrays" +e.getMessage());
        }

        // Final Statement
        System.out.println("End of Program");
    }

    public static void checkName (int index, String[] Name) throws CustomException {

        if (index >= 0 && index <= 3) {
            System.out.println("The Index of the Name is within the Array");
            return; // If index is within the List, the value will return correctly
        }
        else {
            // If the return is error, the statement below will return to the Try-Catch declared earlier
            throw new CustomException (" As the Index does not exist");
        }
    }
}
