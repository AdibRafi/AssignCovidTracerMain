import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
    Admin(){}
    Scanner readFile;
    public List<String> getName() throws IOException{
        File file = new File("customerName");
        readFile = new Scanner(file);
        List<String> resultName = new ArrayList<String>();
        while(readFile.hasNextLine()){
            String data = readFile.nextLine();
            resultName.add(data);
        }
        return resultName;
    }
    public List<String> getPhone() throws IOException{
        File file = new File("customerPhone");
        readFile = new Scanner(file);
        List<String> resultName = new ArrayList<String>();
        while(readFile.hasNextLine()){
            String data = readFile.nextLine();
            resultName.add(data);
        }
        return resultName;
    }
    public List<String> getShop() throws IOException{
        File file = new File("shopName");
        readFile = new Scanner(file);
        List<String> resultName = new ArrayList<String>();
        while(readFile.hasNextLine()){
            String data = readFile.nextLine();
            resultName.add(data);
        }
        return resultName;
    }
    public void displayCustomer(String[] name,String[] phone){
        System.out.println(String.format("%-5s %-15s %-15s %s", "No",
                    "Name", "Phone", "Status"));
        for (int i = 0; i < name.length; i++) {
            System.out.println(String.format("%-5s %-15s %-15s %s",
                    i, name[i], phone[i], "Normal"));
        }
    }
    public void displayShops(String[] name,String[] phone, String[] shop){
        System.out.println(String.format("%-5s %-15s %-15s %-10s %s","No",
                "Name", "Phone", "Manager","Status"));
        for (int i = 0; i <name.length; i++) {
            System.out.println(String.format("%-5s %-15s %-15s %-10s %s"
                    , i,shop[i],phone[i],name[i],"Normal"));
        }
    }



}
