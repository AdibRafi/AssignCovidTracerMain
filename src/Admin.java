import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * adib terangkn...
 * @class Admin()
 * @method displayShops(), displayCustomer() and displayMaster()
 * @params nothing
 * @return nothing
 */
public class Admin {
    Admin(){}

    /**
     *
     * @method displayCustomer()
     * @throws IOException
     * @throws ParseException
     * @throws ArrayIndexOutOfBoundsException
     * @params nothing
     * @return nothing
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
        adminTest startOver = new adminTest();
        String userInput = input.nextLine();
        startOver.adminStart();

    }
    /**
     * adib terangkn...
     * @method displayShops()
     * @throws IOException
     * @throws ParseException
     * @params nothing
     * @return nothing
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
        adminTest startOver = new adminTest();
        String userInput = input.nextLine();
        startOver.adminStart();
    }
    /**
     * adib terangkn...
     * @method displayMaster()
     * @throws IOException
     * @throws ParseException
     * @params nothing
     * @return nothing
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
        adminTest startOver = new adminTest();
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


