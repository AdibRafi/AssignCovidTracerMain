import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class adminTest {
    public static void main(String[] args) {
        System.out.println("1. List of Customers");
        System.out.println("2. List of Shops");
        System.out.print("Press the number = ");

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        // TESTING ARRAY
        String[] adminName = {"Ali", "Adib", "Darwisy"};
        long[] adminPhone = {0103442345, 324523543, 435645345};
        String[] adminShop={"Tesco", "Giant" , "Jaya Grocer"};



        Admin x = new Admin();
        if (userInput.equals("1")) {
            System.out.println(String.format("%-5s %-15s %-15s %s", "No",
                    "Name", "Phone", "Status"));
            for (int i = 0; i < adminName.length; i++) {
                System.out.println(String.format("%-5s %-15s %-15s %s",
                        i, adminName[i], adminPhone[i], "Normal"));
            }
        } else if (userInput.equals("2")) {
            System.out.println(String.format("%-5s %-15s %-15s %-10s %s","No",
                    "Name", "Phone", "Manager","Status"));
            for (int i = 0; i <adminName.length; i++) {
                System.out.println(String.format("%-5s %-15s %-15s %-10s %s"
                , i,adminShop[i],adminPhone[i],adminName[i],"Normal"));
            }

        } else {
            System.out.println("Input Error... try again");

        }

    }
}