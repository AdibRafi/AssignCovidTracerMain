import java.io.IOException;
import java.util.Scanner;

public class adminTest {
    public static void main(String[] args) throws IOException {
        editStuff e = new editStuff();
        e.randomGeneratorMaster();
        System.out.println("1. List of Customers");
        System.out.println("2. List of Shops");
        System.out.println("3. Master");
        System.out.print("Press the number = ");


        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        fileStuff x = new fileStuff("CustomerFileAdmin");
        String[][] customertest = x.getFileReading();
        x = new fileStuff("ShopFileAdmin");
        String[][] shoptest = x.getFileReading();
        x = new fileStuff("MasterFileAdmin");
        String[][] mastertest= x.getFileReading();
        String[][] test =  {
                {"adib","3"},
                {"darwisy","5"},
                {"ahmad","6"},
                {"Azri","10"},
                {"Abu","23"}};

        x = new fileStuff("testWrite");
        x.fileWriting(test);

        Admin y = new Admin();
        switch (userInput) {
            case "1" -> y.displayCustomer();
            case "2" -> y.displayShops();
            case "3" -> y.displayMaster();
            //case "random" -> y.randomGenerator("adibTest");
            default -> System.out.println("Input Error... try again");
        }

    }
}