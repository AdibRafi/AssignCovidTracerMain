import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class is for user as a customer to check-in into a shop, view history shop visited, and view status
 * @author Darwisy
 */
public class Customer {
    Customer() { }

    /**
     * This function is to display the Customer's selection prompt
     * @throws IOException If file not found
     */
    public void custMenuSelect() throws IOException {
        Scanner input = new Scanner(System.in);
        //Display customer menu
        System.out.println("+============================+");
        System.out.println("|   CUSTOMER's SELECTION     |");
        System.out.println("+============================+");
        System.out.println("| Options:                   |");
        System.out.println("|      1. Check-in a shop    |");
        System.out.println("|      2. View history of    |");
        System.out.println("|         the shops visited  |");
        System.out.println("|      3. View status        |");
        System.out.println("|      4. Exit               |");
        System.out.println("+============================+");

        Customer cust = new Customer();
        CheckInShop cIS = new CheckInShop();
        custOption state = new custOption();

        System.out.println("Please enter your choice: ");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Check-in shop");
                cIS.checkIn();

            case 2:
                state.displayHistory();

            case 3:
                System.out.println("Status");
                state.displayStatus();

            case 4:
                System.out.println("Thank you for using this program..");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid selection");
                cust.custMenuSelect();
        }

    }

    /**
     * This class contain both displayStatus and displayHistory method
     * we inherit the Customer to get the customer's input choice
     * @author Darwisy
     */
    class custOption extends Customer {

        /**
         * To display current status of the user(customer)
         * @throws IOException If file not found
         */
        public void displayStatus() throws IOException {
            Scanner input = new Scanner(new File("loginStuff"));
            Scanner pressEnter = new Scanner(System.in);
            String loginName = input.nextLine();
            Login state = new Login();

            customerStuff custState = new customerStuff("CustomerFileAdmin");
            String[][] readF = custState.getFileReading();

            for (int i = 0; i < readF.length; i++) {
                if (readF[i][0].equals(loginName)) {
                    System.out.println("You are " + readF[i][2]);
                }
            }
            System.out.println("Press Enter to continue...");
            pressEnter.nextLine();
            Customer startOver = new Customer();
            startOver.custMenuSelect();

        }

        /**
         * To display the history of user(customer) shop visited
         * @throws IOException If file not found
         */
        public void displayHistory() throws IOException {
            try {
                Scanner input = new Scanner(new File("loginStuff"));
                Scanner pressEnter = new Scanner(System.in);
                String loginName = input.nextLine();

                customerStuff c = new customerStuff("MasterFileAdmin");
                String[][] hist = c.getFileReading();

                ArrayList<String> listDate = new ArrayList<>();
                ArrayList<String> listTime = new ArrayList<>();
                ArrayList<String> listShop = new ArrayList<>();

                boolean gotHistory = false;

                for (int i = 0; i < hist.length; i++) {
                    if (hist[i][2].equals(loginName)) {
                        listDate.add(hist[i][0]);
                        listTime.add(hist[i][1]);
                        listShop.add(hist[i][3]);
                        gotHistory = true;
                    }
                }
                if (gotHistory) {
                    System.out.println("History of Shop visited");
                    System.out.println(String.format("%-5s %-15s %-15s %s", "No",
                            "Date", "Time", "Shop"));
                    for (int i = 0; i < listDate.size(); i++) {
                        System.out.println(String.format("%-5s %-15s %-15s %s", i + 1,
                                listDate.get(i), listTime.get(i), listShop.get(i)));
                    }
                    System.out.println("Press Enter to continue...");
                    pressEnter.nextLine();
                    Customer startOver = new Customer();
                    startOver.custMenuSelect();
                }
                else{
                    System.out.println("You have no History");
                    System.out.println("Press Enter To Continue");
                    pressEnter.nextLine();
                    Customer startOver = new Customer();
                    startOver.custMenuSelect();
                }
            }
            catch (ArrayIndexOutOfBoundsException ex){
                Scanner pressEnter = new Scanner(System.in);
                System.out.println("You have no History");
                System.out.println("Press Enter To Continue");
                pressEnter.nextLine();
                Customer startOver = new Customer();
                startOver.custMenuSelect();
            }
        }
    }
}