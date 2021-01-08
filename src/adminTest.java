import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class adminTest{
    public static void main(String[] args) throws IOException, ParseException {
        adminTest a = new adminTest();
        a.adminStart();
    }
    public void adminStart() throws IOException, ParseException {
        editStuff e = new editStuff("MasterFileAdmin");
        System.out.println("+=============================+");
        System.out.println("|      ADMIN SELECTION        |");
        System.out.println("+=============================+");
        System.out.println("| Options:                    |");
        System.out.println("|       1. List of Customers  |");
        System.out.println("|       2. List of Shops      |");
        System.out.println("|       3. Master             |");
        System.out.println("|       4. Exit               |");
        System.out.println("+=============================+");

        System.out.print("Press the number = ");

        adminTest adminSelect = new adminTest();
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        Admin y = new Admin();
        switch (userInput) {
            case "1" -> y.displayCustomer();
            case "2" -> y.displayShops();
            case "3" -> y.displayMaster();
            case "4" -> {
                System.out.println("Thank you For using our program.");
                System.exit(0);
            } // break
            case "random" -> {
                e.randomGeneratorMaster();
                e.sortDate();
                System.out.println("Random generate complete...");
                System.out.println("Press Enter to continue");
                input.nextLine();
                adminSelect.adminStart();
            }
            default -> System.out.println("Input Error... try again");
        }

    }
}