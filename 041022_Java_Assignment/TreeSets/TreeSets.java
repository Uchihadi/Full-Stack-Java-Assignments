package ArrayList;
import java.util.TreeSet;

public class TreeSets {
    public static void main (String[] args){
        // Declaring UserList Array
        TreeSet<Users> UserList = new TreeSet<Users>();

        // Setting Users' Names and Ages
        Users User1 = new Users();
        User1.setName("John");
        User1.setAge(35);

        Users User2 = new Users();
        User2.setName("Connor");
        User2.setAge(42);

        Users User3 = new Users();
        User3.setName("Nick");
        User3.setAge(28);

        Users User4 = new Users();
        User4.setName("Matt");
        User4.setAge(32);

        Users User5 = new Users();
        User5.setName("Jenny");
        User5.setAge(40);

        // Adding Users' Information to the Array List of UserList
        UserList.add(User1);
        UserList.add(User2);
        UserList.add(User3);
        UserList.add(User4);
        UserList.add(User5);

        // Printing our the Array List, sorted out by Names declared in Users file
        for (Users User:UserList){
            System.out.println("Name is: " + User.getName() + " & he is " + User.getAge() + " years old.");
        }
    }
}
