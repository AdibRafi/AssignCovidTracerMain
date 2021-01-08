import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class CheckInShop {
    public static void main(String[] args) throws IOException {
        CheckInShop test= new CheckInShop();
        test.checkIn();
    }
    public void checkIn() throws IOException {
        CheckInShop cIS = new CheckInShop();
        customerStuff c = new customerStuff("loginStuff");
        Scanner input = new Scanner(new File("loginStuff"));
        String loginName = input.nextLine();
        Date now = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat TimeFor = new SimpleDateFormat("HH:mm:ss");

        // 2021-01-01,06:42:19,Darwisy,Kfry

        Login name = new Login();

        String[] result;
        Customer backTo = new Customer();

        System.out.println("+==================================+");
        System.out.println("|      CHECK-IN SHOP SELECTION     |");
        System.out.println("+==================================+");
        System.out.println("| Options:                         |");
        System.out.println("|       1. Tesco                   |");
        System.out.println("|       2. Jaya Grocer             |");
        System.out.println("|       3. Kfry                    |");
        System.out.println("|       4. Parkson                 |");
        System.out.println("|       5. back to Cust. Selection |");
        System.out.println("+==================================+");

        System.out.println("Select a shop to check in: ");

        Scanner inputcheckIn = new Scanner(System.in);
        int userInput = inputcheckIn.nextInt();

        switch (userInput) {
            case 1:{
                Scanner pressEnter = new Scanner(System.in);
                result = new String[]{DateFor.format(now),
                        TimeFor.format(now), loginName, "Tesco"};
                c.UpdateCheckInShop(result);
                System.out.println("Check-In Successful");
                System.out.println("Press Enter To continue");
                pressEnter.nextLine();
                backTo.custMenuSelect();
                break;}
            case 2:{
                Scanner pressEnter = new Scanner(System.in);
                result = new String[]{DateFor.format(now),
                        TimeFor.format(now), loginName, "Jaya Grocer"};
                c.UpdateCheckInShop(result);
                System.out.println("Check-In Successful");
                System.out.println("Press Enter To continue");
                pressEnter.nextLine();
                backTo.custMenuSelect();
                break;}
            case 3:{
                Scanner pressEnter = new Scanner(System.in);
                result = new String[]{DateFor.format(now),
                        TimeFor.format(now), loginName, "Kfry"};
                c.UpdateCheckInShop(result);
                System.out.println("Check-In Successful");
                System.out.println("Press Enter To continue");
                pressEnter.nextLine();
                backTo.custMenuSelect();
                break;}
            case 4:{
                Scanner pressEnter = new Scanner(System.in);
                result = new String[]{DateFor.format(now),
                        TimeFor.format(now), loginName, "Parkson"};
                c.UpdateCheckInShop(result);
                System.out.println("Check-In Successful");
                System.out.println("Press Enter To continue");
                pressEnter.nextLine();
                backTo.custMenuSelect();
                break;}
            case 5:{
                backTo.custMenuSelect();
            }

            default:
                System.out.println("Invalid selection");
                cIS.checkIn();
                break;
            }

        }



//            if(userInput.equals("now")){
//                String[] result = {DateFor.format(now), TimeFor.format(now)};
//                System.out.println(Arrays.toString(result));
//            }

}



