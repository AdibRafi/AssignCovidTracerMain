import java.io.IOException;
import java.util.Scanner;

public class adminTest {
    public static void main(String[] args) throws IOException {
        editStuff e = new editStuff("MasterFilelol");
        System.out.println("1. List of Customers");
        System.out.println("2. List of Shops");
        System.out.println("3. Master");
        System.out.print("Press the number = ");


        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        Admin y = new Admin();
        switch (userInput) {
            case "1" -> y.displayCustomer();
            case "2" -> y.displayShops();
            case "3" -> y.displayMaster();
            case "random" -> {
                e.randomGeneratorMaster();
                e.sortDate();
            }
            default -> System.out.println("Input Error... try again");
        }

    }
}