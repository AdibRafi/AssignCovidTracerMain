import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class fileStuff {
    private String fileName;
    fileStuff(){}
    fileStuff(String fileName){this.fileName = fileName;}
    public void fileWriting(String arr)throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write(arr);
        writer.close();
    }
    public String[][] getFileReading() throws IOException{
        Scanner input = new Scanner(new File(fileName));
        List<String[]> lines = new ArrayList<>();
        while (input.hasNextLine()){
            String line = input.nextLine();
            String[] lineSplit = line.split(",");
            lines.add(lineSplit);
        }
        String[][] result = new String[lines.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = lines.get(i);
        }
        return result;
    }
    public String[] getFileReading1row() throws IOException{
        Scanner input = new Scanner(new File(fileName));
        String result[] = input.nextLine().split(",");
        return result;
    }
    public void fileWriting(String[][] strings) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                writer.write(strings[i][j]+
                        ((j==strings[i].length-1) ? "" : ","));
            }
            writer.newLine();
        }
        writer.flush();
    }
//    public void sortDate()throws IOException{
//        fileStuff f = new fileStuff(fileName);
//        String[][] input = f.getFileReading();
//        Scanner inputSys = new Scanner(System.in);
//        System.out.println("Which column do you want to sort?");
//        String inputUser = inputSys.nextLine();
//
//        switch (inputUser){
//            case "1" -> Arrays.sort(input,Comparator.comparing(o -> o[0]));
//            case "2" -> Arrays.sort(input,Comparator.comparing(o -> o[1]));
//            default -> System.out.println("Input error");
//        }
//        System.out.println("dah");
//        System.out.println(Arrays.deepToString(input));
//        f.fileWriting(input);
//
//    }
}

class editStuff extends fileStuff{
    private final String[] name = {
            "Adib", "Ali", "Adam", "Darwisy",
            "Harri", "Shuhail", "Raja", "Azri",
            "Imran", "Elijah", "Ahmad"};
    private final String[] shop = {
            "Tesco", "McDonald", "Pizza Hut", "Domino",
            "Parkson", "Harvey", "Jaya Grocer", "HomePro",
            "Machine", "Samsung", "Swatch"};
    private final String[] status = {"Case","Close","Normal"};
    Random rand = new Random();
    Date now = new Date();
    long timeRangeMs = 1000 * 60 * 60 * 24;
    SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat TimeFor = new SimpleDateFormat("hh:mm:ss");
    List<String[]> firstResult = new ArrayList<>();

    editStuff(){}
    editStuff(String filename){
        super(filename);
    }

    public void sortDate()throws IOException{
        fileStuff f = new fileStuff(super.toString());
        String[][] input = f.getFileReading();
        Scanner inputSys = new Scanner(System.in);
        System.out.println("Which column do you want to sort?");
        String inputUser = inputSys.nextLine();

        switch (inputUser){
            case "1" -> Arrays.sort(input,Comparator.comparing(o -> o[0]));
            case "2" -> Arrays.sort(input,Comparator.comparing(o -> o[1]));
            default -> System.out.println("Input error");
        }
        System.out.println("dah");
        System.out.println(Arrays.deepToString(input));
        f.fileWriting(input);

    }
    public void randomGeneratorMaster() throws IOException {

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
    public void randomGeneratorCustomer() throws IOException{
        List<String[]> firstResult = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            int x = rand.nextInt(100000000);
            String y = "01" + x;
            String[] arr = {name[rand.nextInt(10)],y,
            shop[rand.nextInt(10)]};
            firstResult.add(arr);
        }
        String[][] finalResult = new String[firstResult.size()][];
        for (int i = 0; i < finalResult.length; i++) {
            finalResult[i] = firstResult.get(i);
        }

        fileStuff f = new fileStuff("CustomerFile");
        f.fileWriting(finalResult);
    }
    public void randomGeneratorShop() throws IOException{
        for (int i = 0; i < 30; i++) {
            int x = rand.nextInt(100000000);
            String y = "03" + x;
            String[] arr = {shop[rand.nextInt(10)],
                    y, name[rand.nextInt(10)],
            status[rand.nextInt(3)]};
            firstResult.add(arr);
        }
        String[][] finalResult = new String[firstResult.size()][];
        for (int i = 0; i < finalResult.length; i++) {
            finalResult[i] = firstResult.get(i);
        }

        fileStuff f = new fileStuff("ShopFile");
        f.fileWriting(finalResult);
    }

}


// ARCHIVE
// Scanner readFile;
//    public List<String> readingFile(String fileName) throws IOException{
//        File file = new File(fileName);
//        readFile = new Scanner(file);
//        List<String> result = new ArrayList<String>();
//        while(readFile.hasNextLine()){
//            String data = readFile.nextLine();
//            result.add(data);
//        }
//        return result;
//    }
