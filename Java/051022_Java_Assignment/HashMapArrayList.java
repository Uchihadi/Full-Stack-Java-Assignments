package HashMap;
import java.util.HashMap;
import java.util.ArrayList;

// Create HashMap with ArrayList<User> & Iterate

public class HashMapArrayList {
    public static void main (String[] args){
        HashMap <String, ArrayList<String>> User = new HashMap <String, ArrayList<String>>();

        ArrayList<String> user1 = new ArrayList<String>();
        user1.add("Jose Mourinho");

        ArrayList<String> user2 = new ArrayList<String>();
        user2.add("Harry Redknapp");

        ArrayList<String> user3 = new ArrayList<String>();
        user3.add("Josep Guardiola");

        User.put("user1", user1);
        User.put("user2", user2);
        User.put("user3", user3);

        // System.out.println(user1);
        // System.out.println(user2);
        // System.out.println(user3);

        System.out.println("Here are top 3 Football Managers: ");

        for (ArrayList<String> usr: User.values()) {
            for (String users: usr){
                System.out.println(users);
            }
        }
    }
}
