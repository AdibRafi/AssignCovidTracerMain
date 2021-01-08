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
                System.out.println("Tesco");
                result = new String[]{DateFor.format(now),
                        TimeFor.format(now), name.getLoginUserName(), "Tesco"};
                System.out.println(Arrays.toString(result));
                break;}
            case 2:{
                System.out.println("Jaya Grocer");
                result = new String[]{DateFor.format(now),
                        TimeFor.format(now), name.getLoginUserName(), "Jaya Grocer"};
                System.out.println(Arrays.toString(result));

                break;}
            case 3:{
                System.out.println("Kfry");
                result = new String[]{DateFor.format(now),
                        TimeFor.format(now), name.getLoginUserName(), "Kfry"};
                System.out.println(Arrays.toString(result));
                break;}
            case 4:{
                System.out.println("Parkson");
                result = new String[]{DateFor.format(now),
                        TimeFor.format(now), name.getLoginUserName(), "Parkson"};
                System.out.println(Arrays.toString(result));
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



