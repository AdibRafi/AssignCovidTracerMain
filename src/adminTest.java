import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class adminTest {
    public static void main(String[] args) throws IOException {
        System.out.println("1. List of Customers");
        System.out.println("2. List of Shops");
        System.out.print("Press the number = ");

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        Admin x = new Admin();
        String[] adminName = x.getName().toArray(new String[0]);
        String[] adminPhone = x.getPhone().toArray(new String[0]);
        String[] adminShop = x.getShop().toArray(new String[0]);

        if (userInput.equals("1")) {
            x.displayCustomer(adminName,adminPhone);

        } else if (userInput.equals("2")) {
            x.displayShops(adminName,adminPhone,adminShop);
        } else {
            System.out.println("Input Error... try again");
        }

    }
}