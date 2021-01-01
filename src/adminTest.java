import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;

public class adminTest {
    public static void main(String[] args) throws IOException {
        System.out.println("1. List of Customers");
        System.out.println("2. List of Shops");
        System.out.println("3. Master");
        System.out.print("Press the number = ");


        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        fileStuff x = new fileStuff();
        String[][] customertest = x.getFileReading("CustomerFileAdmin");
        String[][] shoptest = x.getFileReading("ShopFileAdmin");
        String[][] mastertest= x.getFileReading("MasterFileAdmin");
        String[][] test =  {{"adib","3"},
                            {"darwisy","5"},
                            {"ahmad","6"},
                {"Azri","10"},
                {"Abu","23"}};

        x.fileWriting("MEKDIBUTO",test);

        Admin y = new Admin();
        switch (userInput) {
            case "1" -> y.displayCustomer(customertest);
            case "2" -> y.displayShops(shoptest);
            case "3" -> y.displayMaster(mastertest);
            default -> System.out.println("Input Error... try again");
        }

    }
}