 import java.util.Random;
import java.util.Scanner;

public class Customer {
    private String name;

    Customer(){}
    Customer(String name){this.name = name;}
    public static void main(String[] args) {
        Customer cs = new custStatus();
        Customer cs2 = new custStatus("Adib","case");
            ((custStatus) cs).display();

        Random rand = new Random();
        String[] randCase = {"COVID-19 Positive", "COVID-19 Negative"};
        int randNum = rand.nextInt(2);
        Customer cs3 = new custStatus("Darwisy",randCase[randNum]);
        System.out.println(cs3);
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
        if (status == "COVID-19 Negative"){
            System.out.println("Customer is a normal");
        }
        else if(status == ""){
            System.out.println("Customer is a Close contact");
        }
    }
}




