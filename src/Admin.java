import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * This class is mainly use for Admin side of the project
 * @author Adib
 */
public class Admin {
    Admin(){}

    /**
     * Displaying a Customer Info
     * @throws IOException If file not found
     * @throws ParseException If String cannot be convert into Date
     * @throws ArrayIndexOutOfBoundsException If Array are out of index
     */
    public void displayCustomer() throws IOException, ParseException,ArrayIndexOutOfBoundsException {
        fileStuff f = new fileStuff("CustomerFileAdmin");
        String[][] fileRead = f.getFileReading();
        System.out.printf("%-5s %-15s %-15s %s%n", "No",
                    "Name", "Phone", "Status");
        for (int i = 0; i < fileRead.length; i++)
            System.out.printf("%-5s %-15s %-15s %s%n",i+1, fileRead[i][0], fileRead[i][1],fileRead[i][2]);

        System.out.println("Press Enter to return to menu.");
        Scanner input = new Scanner(System.in);
        adminWindow startOver = new adminWindow();
        String userInput = input.nextLine();
        startOver.adminStart();

    }

    /**
     * Displaying a Shop Info
     * @throws IOException If file Not found
     * @throws ParseException If String cannot be convert into Date
     */
    public void displayShops() throws IOException, ParseException {
        fileStuff f = new fileStuff("ShopFileAdmin");
        String[][] fileRead = f.getFileReading();
        System.out.println(String.format("%-5s %-15s %-15s %-10s %s","No",
                "Name", "Phone", "Manager","Status"));
        for (int i = 0; i <fileRead.length; i++) {
            System.out.println(String.format("%-5s %-15s %-15s %-10s %s"
                    , i+1,fileRead[i][0],fileRead[i][1],fileRead[i][2],fileRead[i][3]));
        }
        System.out.println("Press Enter to return to menu.");
        Scanner input = new Scanner(System.in);
        adminWindow startOver = new adminWindow();
        String userInput = input.nextLine();
        startOver.adminStart();
    }

    /**
     * Displaying a Master Info
     * @throws IOException If file not found
     * @throws ParseException If String cannot be convert into Date
     */
    public void displayMaster() throws IOException, ParseException {
        fileStuff f = new fileStuff("MasterFileAdmin");
        String[][] fileRead = f.getFileReading();
        Scanner input = new Scanner(System.in);
        System.out.println(String.format("%-5s %-13s %-10s %-16s %s","No",
                "Date", "Time", "Customer","Shop"));
        for (int i = 0; i < fileRead.length; i++) {
            System.out.println(String.format("%-5s %-13s %-10s %-16s %s"
                    , i+1,fileRead[i][0],fileRead[i][1],fileRead[i][2],fileRead[i][3]));
        }
        System.out.println("Would you like to Flag a customer? (y/n) ");
        String userInput = input.nextLine();
        adminWindow startOver = new adminWindow();
        if (userInput.equals("y")){
            editStuff e = new editStuff();
            e.changeStatus();
            System.out.println("Flag customer complete...");
        }
        System.out.println("Press Enter to continue");
        input.nextLine();
        startOver.adminStart();
    }
}