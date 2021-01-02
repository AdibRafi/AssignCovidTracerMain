import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Admin {
    Admin(){}
    public void displayCustomer(String[][] strings){
        System.out.println(String.format("%-5s %-15s %-15s %s", "No",
                    "Name", "Phone", "Status"));
        for (int i = 0; i < strings.length; i++) {
            System.out.println(String.format("%-5s %-15s %-15s %s",
                    i, strings[i][0], strings[i][1],strings[i][2]));
        }
    }
    public void displayShops(String[][] strings){
        System.out.println(String.format("%-5s %-15s %-15s %-10s %s","No",
                "Name", "Phone", "Manager","Status"));
        for (int i = 0; i <strings.length; i++) {
            System.out.println(String.format("%-5s %-15s %-15s %-10s %s"
                    , i,strings[i][0],strings[i][1],strings[i][2],strings[i][3]));
        }
    }
    public void displayMaster(String[][] strings){
        System.out.println(String.format("%-5s %-13s %-10s %-16s %s","No",
                "Date", "Time", "Customer","Shop"));
        for (int i = 0; i <strings.length; i++) {
            System.out.println(String.format("%-5s %-13s %-10s %-16s %s"
                    , i,strings[i][0],strings[i][1],strings[i][2],strings[i][3]));
        }
    }
    public void randomGenerator() throws IOException {
        Random rand = new Random();
        Date now = new Date();
        long timeRangeMs = 1000 * 60 * 60 * 24;
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat TimeFor = new SimpleDateFormat("hh:mm:ss");
        List<String[]> firstResult = new ArrayList<>();

        String[] name = {
                "Adib", "Ali", "Adam", "Darwisy",
                "Harri", "Shuhail", "Arif", "Azri",
                "Imran", "Elijah", "Ahmad"};

        String[] shop = {
                "Tesco", "McDonald", "Pizza Hut", "Domino",
                "Parkson", "Harvey", "Jaya Grocer", "HomePro",
                "Machine", "Samsung", "Swatch"};

        for (int i = 0; i < 30; i++) {
            long random = ThreadLocalRandom.current().nextLong(timeRangeMs);
            Date randDate = new Date(now.getTime() - random);
            String stringDate = DateFor.format(randDate);
            String stringTime = TimeFor.format(randDate);
            String[] arr = {stringDate,stringTime,
                    name[rand.nextInt(10)],
                    shop[rand.nextInt(10)]};
            firstResult.add(arr);
        }
        String[][] finalResult = new String[firstResult.size()][];
        for (int i = 0; i < finalResult.length; i++) {
            finalResult[i] = firstResult.get(i);
        }

        fileStuff f = new fileStuff("MasterFileAdmin");
        f.fileWriting(finalResult);

    }
}

