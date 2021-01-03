import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class testingGroundAdib {
    public static void main(String[] args) throws IOException, IllegalArgumentException, ParseException {

        //pilih sapa dpt case


//        Admin d = new Admin();
//        fileStuff f;
//        editStuff e;
//        d.displayMaster();
//        String[][] readFile;
//        System.out.println("Select a number to Flag a customer");
//        Scanner input = new Scanner(System.in);
//        int userInput = input.nextInt();
//
//        e = new editStuff("CustomerFileAdmin");
//        readFile = e.getFileReading();
//        readFile[userInput-1][2] = "Case";
//        e.fileWriting(readFile);
//
//        f = new fileStuff("MasterFileAdmin");
//
//        readFile = f.getFileReading();
//        ArrayList<String> caseName = new ArrayList<>();
//        ArrayList<String> caseShop = new ArrayList<>();
//        ArrayList<String> caseDate = new ArrayList<>();
//        ArrayList<String> caseTime = new ArrayList<>();
//
//        caseDate.add(readFile[userInput-1][0]);
//        caseTime.add(readFile[userInput-1][1]);
//        caseName.add(readFile[userInput-1][2]);
//        caseShop.add(readFile[userInput-1][3]);
//
//        System.out.println(caseDate);
//        System.out.println(caseTime);
//        System.out.println(caseName);
//        System.out.println(caseShop);
//
//        //change the shop status from caseShop array
//        e = new editStuff("ShopFileAdmin");
//        readFile = e.getFileReading();
//
//        for (int i = 0; i < readFile.length; i++) {
//            if (readFile[i][0].equals(caseShop.get(0)))
//                readFile[i][3] = "Case";
//        }
//        e.fileWriting(readFile);
//
//
//        //calculate siapa dpt close
//
//        f = new fileStuff("MasterFileAdmin");
//        readFile = f.getFileReading();
//        ArrayList<String> possibleCase = new ArrayList<>();
//
//        // getting possible time from other person
//        for (int i = 0; i < readFile.length; i++) {
//            if (readFile[i][0].equals(caseDate.get(0))){
//                if (readFile[i][3].equals(caseShop.get(0))){
//                    if (!readFile[i][2].equals(caseName.get(0)))
//                    possibleCase.add(readFile[i][1]);
//                }
//            }
//        }
//        System.out.println(possibleCase);
//        ArrayList<String> closeName = new ArrayList<>();
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//        Date possibleTimeFromCase = sdf.parse(caseTime.get(0));
//        for (int i = 0; i < possibleCase.size(); i++) {
//            Date possibleTime = sdf.parse(possibleCase.get(i));
//            long timeDiff = possibleTime.getTime() - possibleTimeFromCase.getTime();
//            long x = Math.abs(timeDiff);
//            int hours = (int) (x/(1000*60*60)%24);
//            System.out.println(hours);
//            if (hours ==0 || hours ==11){
//                for (int y = 0; y < readFile.length; y++) {
//                    if (readFile[y][1].equals(possibleCase.get(i)))
//                        closeName.add(readFile[y][2]);
//                }
//            }
//        }
//        System.out.println(closeName);
//        e = new editStuff("CustomerFileAdmin");
//        readFile = e.getFileReading();
//        for (int i = 0; i < closeName.size(); i++) {
//            for (int j = 0; j < readFile.length ; j++) {
//                if (readFile[j][0].equals(closeName.get(i))){
//                    if (!readFile[j][2].equals("Case")){
//                        readFile[j][2] = "Close";}
//                }
//            }
//        }
//        e.fileWriting(readFile);

    }
}



        /*
        for (int i = 0; i < readFirstFile.length; i++) {
            if (readFirstFile[i][2].equals("Case"))
                caseName.add(readFirstFile[i][0]);
        }
        System.out.println(caseName); // ARRAYLIST

        //second row(get the name n time)
        f = new fileStuff("MasterFileAdmin");
        String[][] readSecondFile = f.getFileReading();
        ArrayList<String> caseShop = new ArrayList<>();
        ArrayList<String> caseDate = new ArrayList<>();
        for (int i = 0; i < caseName.size(); i++) {
            for (int j = 0; j < readSecondFile.length; j++) {
                if (readSecondFile[j][2].equals(caseName.get(i))) {
                    caseShop.add(readSecondFile[j][3]);
                    caseDate.add(readSecondFile[j][0]+","+
                            readSecondFile[j][1]);
                }
            }
        }
        System.out.println(caseShop);
        Set<String> set = new HashSet<String>(caseShop);
        caseShop.clear();
        caseShop.addAll(set);
        System.out.println(caseShop);
        System.out.println(caseDate);
        String[] test = caseDate.toArray(new String[0]);
        System.out.println(Arrays.toString(test));
        for (int i = 0; i < caseDate.size(); i++) {
        // how tf nak get date n time?!?!
        }
        System.out.println("lol");

        // THIRD FLOW
        f = new fileStuff("CustomerFileAdmin");
        String[][] readThirdFile = f.getFileReading();

//        String[] input = caseShop.toArray(new String[0]);
//        String current = caseShop.get(0);
//        boolean found = false;



//        for (int i = 0; i < input.length; i++) {
//            if (current.equals(input[i]) && !found) {
//                found = true;
//            } else if (!current.equals(input[i])) {
//                caseShop.add(current);
//                current = input[i];
//                found = false;
//            }
//        }
//        System.out.println(caseShop.size());


//        Admin d = new Admin();
//        d.randomGenerator();
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
//        String[] test = x.getName().toArray(new String[0]);
//        System.out.println(test[0]);
    }
}

         */