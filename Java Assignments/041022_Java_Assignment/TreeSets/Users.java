package ArrayList;

// Implements Comparable
public class Users implements Comparable<Users> {
    // Function String Getter and Setter for Name
    public String getName(){
        return Name;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    // Function Getter and Setter for Integer Age
    public int getAge() {
        return Age;
    }

    public void setAge(int Age){
        this.Age = Age;
    }

    // Declaring String Name and Integer Age
    String Name;
    int Age;

    // Sort the Array with Name
    public int compareTo(Users s1){
        return this.getName().compareToIgnoreCase(s1.getName());
    }

}
