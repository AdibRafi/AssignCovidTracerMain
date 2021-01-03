import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class Customer extends MainMenu {
    private String name;
    Customer(){}
    public void custStatus(){
        Customer cs = new custStatus();

        Customer cs2 = new custStatus("Adib", "case");
        ((custStatus) cs).display();

        Random rand = new Random();
        String[] randCase = {"COVID-19 Positive", "COVID-19 Negative"};
        int randNum = rand.nextInt(2);
        Customer cs3 = new custStatus("Darwisy", randCase[randNum]);
        System.out.println(cs3);
    }

    Customer(String name){this.name = name;}


    public void custMenuSelect(){
        Scanner input = new Scanner(System.in);
        //Display menu
        System.out.println("+============================+");
        System.out.println("|   CUSTOMER's SELECTION     |");
        System.out.println("+============================+");
        System.out.println("| Options:                   |");
        System.out.println("|      1. Register           |");
        System.out.println("|      2. Check-in a shop    |");
        System.out.println("|      3. View history of    |");
        System.out.println("|         the shops visited  |");
        System.out.println("|      4. View status        |");
        System.out.println("|      5. Back to main menu  |");
        System.out.println("+============================+");

        Customer cust = new Customer();
        System.out.println("Please enter your choice: ");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Register");
                break;
            case 2:
                System.out.println("Check-in shop");
                break;
            case 3:
                System.out.println("History of shops visited");
                break;
            case 4:
                System.out.println("Status");
                break;
            case 5:
                cust.menuSelection();
                break;
            default:
                System.out.println("Invalid selection");
                cust.custMenuSelect();
                break;
    }

}



class custStatus extends Customer{
    private String status = "Normal";
    custStatus(){}
    custStatus(String status){this.status = status;}
    custStatus(String name,String status){
        super(name);
        this.status = status;
    }
    void display() {
        if (status.equals("COVID-19 Negative")){
            System.out.println("Customer is a normal");
        }
        else if(status == ""){
            System.out.println("Customer is a Close contact");
        }
    }
    }
}




