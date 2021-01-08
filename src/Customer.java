import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Customer {
    private String name;

    Customer() {
    }
//    public void custStatus(){
//        Customer cs = new custStatus();
//
//        Customer cs2 = new custStatus("Adib", "case");
//        ((custStatus) cs).display();
//
//        Random rand = new Random();
//        String[] randCase = {"COVID-19 Positive", "COVID-19 Negative"};
//        int randNum = rand.nextInt(2);
//        Customer cs3 = new custStatus("Darwisy", randCase[randNum]);
//        System.out.println(cs3);
//    }

    Customer(String name) {
        this.name = name;
    }

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
                System.out.println("History of shops visited");
                state.displayHistory();

            case 3:
                System.out.println("Status");
                state.displayStatus();

            case 4:
                System.out.println("Thank you for using this program..");
                break;
            default:
                System.out.println("Invalid selection");
                cust.custMenuSelect();
        }

    }

    class custOption extends Customer {
        public void displayStatus() throws IOException {
            Scanner input = new Scanner(new File("loginStuff"));
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
            input.nextLine();
            Customer startOver = new Customer();
            startOver.custMenuSelect();

        }
        public void displayHistory() throws IOException {
            // 2021-01-02,04:41:31,Darwisy,Harvey
            Scanner input = new Scanner(new File("loginStuff"));
            String loginName = input.nextLine();

            customerStuff c = new customerStuff("MasterFile");
            String[][] hist = c.getFileReading();

            ArrayList<String> listDate = new ArrayList<>();
            ArrayList<String> listTime = new ArrayList<>();
            ArrayList<String> listShop = new ArrayList<>();


            for (int i = 0; i < hist.length ; i++) {
                if (hist[i][2].equals(loginName)){
                    listDate.add(hist[i][0]);
                    listTime.add(hist[i][1]);
                    listShop.add(hist[i][3]);
                }
            }
            System.out.println(String.format("%-5s %-15s %-15s %s","No",
                    "Date", "Time", "Shop"));
            for (int i = 0; i < listDate.size(); i++) {
                System.out.println(String.format("%-5s %-15s %-15s %s",i+1,
                        listDate.get(i), listTime.get(i), listShop.get(i)));
            }
        }
    }

}




//    private String status = "Normal";
//    custStatus(){}
//    custStatus(String status){this.status = status;}
//    custStatus(String name,String status){
//        super(name);
//        this.status = status;
//    }
//    void display() {
//        if (status.equals("COVID-19 Negative")){
//            System.out.println("Customer is a normal");
//        }
//        else if(status == ""){
//            System.out.println("Customer is a Close contact");
//        }
//    }