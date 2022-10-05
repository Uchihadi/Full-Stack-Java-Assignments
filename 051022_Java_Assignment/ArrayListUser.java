package HashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Create ArrayList with User
// Filter out Users age < 20
// Filter out Users whose Name starts with "a" and return the First User

public class ArrayListUser {
    public static void main (String[] args){
        ArrayList <Name> names = new ArrayList<Name>();

        Name name1 = new Name();
        Name name2 = new Name();
        Name name3 = new Name();
        Name name4 = new Name();
        Name name5 = new Name();

        name1.setName("Aaron");
        name1.setAge(18);

        name2.setName("Jonathan");
        name2.setAge(25);

        name3.setName("Artemis");
        name3.setAge(28);

        name4.setName("Bobby");
        name4.setAge(29);

        name5.setName("Maverick");
        name5.setAge(20);

        names.add(name1);
        names.add(name2);
        names.add(name3);
        names.add(name4);
        names.add(name5);

        names.forEach((obj) ->{
            System.out.println("His Name is " + obj.getName() + " & he is " + obj.getAge());
                });

        List <Name> Age20 = names.stream().filter((obj) -> obj.getAge() <= 20).collect(Collectors.toList());
        Age20.forEach((obj) -> {
            System.out.println(obj.getAge());
        });

        Name filterA = names.stream().filter((obj) -> obj.getName().startsWith("A")).findFirst().get();
        System.out.println(filterA.getName());
    }
}
