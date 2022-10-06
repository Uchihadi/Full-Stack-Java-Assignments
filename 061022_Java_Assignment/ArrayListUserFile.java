package FileWriting;

import FileWriting.Names;
import FileWriting.DateTime;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDateTime; //Importing LocalDateTime Class

// File Writing User --> Name & Address
// Create 10 Users in List
// Using Iteration, Write User Data into File along with Date & Time

public class ArrayListUserFile {
    public static void main(String[] args) {
        ArrayList<Names> names = new ArrayList<Names>();

        names.add(new Names("Fumio Kishida", "Japan"));
        names.add(new Names("Joe Biden", "United States"));
        names.add(new Names("Lee Hsien Loong", "Singapore"));
        names.add(new Names("Ismail Sabri", "Malaysia"));
        names.add(new Names("Narendra Modi", "India"));
        names.add(new Names("Xi Jinping", "China"));
        names.add(new Names("Vladimir Putin", "Russia"));
        names.add(new Names("Liz Truss", "United Kingdom"));
        names.add(new Names("Jair Bolsonaro", "Brazil"));
        names.add(new Names("Joko Widodo", "Indonesia"));

        names.forEach((obj) ->{
            System.out.println("His Name is " + obj.getName() + " & he is from " +obj.getAddress());
                });

        try (FileOutputStream fileout = new FileOutputStream("/Users/saiar/Downloads/User.txt", true)) {
            for (Names leaders:names) {
                LocalDateTime myDateTime = LocalDateTime.now();
                String pattern = "MM-dd-yyyy HH:mm:ss";
                String Time = myDateTime.format(DateTimeFormatter.ofPattern(pattern));
                String Message = "\nHis Name is " + leaders.getName() + " & he is from " + leaders.getAddress() + "\t" + Time;
                fileout.write(Message.getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
