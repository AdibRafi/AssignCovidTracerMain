import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class testingGroundAdib {
    public static void main(String[] args) throws IOException {

        Admin d = new Admin();
        d.randomGenerator();
//        Random rand = new Random();
//        Date now = new Date();
//        long timeRangeMs = 1000 * 60 * 60 * 24; // 3 hours in ms
////        long random = ThreadLocalRandom.current().nextLong(timeRangeMs);
////        Date randDate = new Date(now.getTime() - random);
//        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat TimeFor = new SimpleDateFormat("hh:mm:ss");
//        List<String[]> firstResult = new ArrayList<>();
//
//        String[] name = {
//                "Adib", "Ali", "Adam", "Darwisy", "Harri", "Shuhail", "Arif", "Azri", "Imran", "Elijah", "Ahmad",
//        };
//
//        String[] shop = {
//                "Tesco", "McDonald", "Pizza Hut", "Domino", "Parkson", "Harvey", "Jaya Grocer", "HomePro", "Machine", "Samsung", "Swatch",
//        };
//
//        for (int i = 0; i < 30; i++) {
//            long random = ThreadLocalRandom.current().nextLong(timeRangeMs);
//            Date randDate = new Date(now.getTime() - random);
//            String stringDate = DateFor.format(randDate);
//            String stringTime = TimeFor.format(randDate);
//            String[] arr = {stringDate,stringTime,
//                    name[rand.nextInt(10)],
//                    shop[rand.nextInt(10)]};
//            firstResult.add(arr);
//        }
//        String[][] finalResult = new String[firstResult.size()][];
//        for (int i = 0; i < finalResult.length; i++) {
//            finalResult[i] = firstResult.get(i);
//        }
//
//        fileStuff f = new fileStuff("testlol");
//        f.fileWriting(finalResult);




//        File file = new File("customerName");
//        Scanner readFile = new Scanner(file);
//
//        List<String> temps = new ArrayList<String>();
//
//        while (readFile.hasNextLine()){
//            String data = readFile.nextLine();
//            temps.add(data);
//        }
//        System.out.println(temps);
        Admin x = new Admin();
//        String[] test = x.getName().toArray(new String[0]);
//        System.out.println(test[0]);
    }
}
