import java.io.IOException;
import java.util.Scanner;

public class adminTest extends MainMenu {
    public void adminStart() throws IOException {
        editStuff e = new editStuff("MasterFilelol");
        System.out.println("+=============================+");
        System.out.println("|      ADMIN SELECTION        |");
        System.out.println("+=============================+");
        System.out.println("| Options:                    |");
        System.out.println("|       1. List of Customers  |");
        System.out.println("|       2. List of Shops      |");
        System.out.println("|       3. Master             |");
        System.out.println("|       4. Back to main menu  |");
        System.out.println("+=============================+");

        System.out.print("Press the number = ");

        MainMenu mMenu = new MainMenu();
        adminTest adminSelect = new adminTest();
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        Admin y = new Admin();
        switch (userInput) {
            case "1" -> y.displayCustomer();
            case "2" -> y.displayShops();
            case "3" -> y.displayMaster();
            case "4" -> adminSelect.adminStart();
            case "random" -> {
                e.randomGeneratorMaster();
                e.sortDate();
            }
            default -> System.out.println("Input Error... try again");
        }

    }
}