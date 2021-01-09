import java.io.*;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is mainly use for writing and reading a file
 * @author adibrafi
 */
public class fileStuff {
    private String fileName;
    fileStuff(){}

    /**
     * Setting a file name
     * @param fileName The name of the file
     */
    fileStuff(String fileName){this.fileName = fileName;}
    public String toString(){
        return fileName;
    }

    /**
     * Writing String[] into a file
     * @param strings String[] that wanted to put in file
     * @throws IOException If file Not Found
     */
    public void fileWriting(String[] strings)throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (int j = 0; j < strings.length; j++) {
            writer.write(strings[j]+
                    ((j==strings.length-1) ? "" : ","));
        }
        writer.close();
    }

    /**
     * getting the element from the file
     * @return the element contains in the file
     * @throws IOException If file not found
     */
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

    /**
     * Writing String[][] into a file
     * @param strings String[][] that wanted to put in the file
     * @throws IOException If file not found
     */
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
        writer.close();
    }
}

/**
 * This class is for modifying a file
 * @author adibrafi
 */
class editStuff extends fileStuff{
    private final String[] name = {"Adib", "Ali", "Darwisy","Raja","Ahmad"};
    private final String[] shop = {"Tesco", "Parkson","Jaya Grocer","Kfry"};
    Random rand = new Random();
    Date now = new Date();
    long timeRangeMs = 1000 * 60 * 60 * 24;
    SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat TimeFor = new SimpleDateFormat("HH:mm:ss");
    List<String[]> firstResult = new ArrayList<>();

    editStuff(){}

    /**
     * Setting a file name
     * @param filename The name of the file
     */
    editStuff(String filename){
        super(filename);
    }

    /**
     * Adding a name from 'registerStuff' into a super(fileName)
     * @return String[] contains the name from 'register' file and super(fileName)
     * @throws IOException If file not found
     */
    public String[] setName() throws IOException {
        editStuff e = new editStuff("registerStuff");
        String[][] input = e.getFileReading();

        try{
            ArrayList<String> newArray = new ArrayList<>();
            for (int i = 0; i < input.length; i++) {
                newArray.add(input[i][0]+input[i][1]);
            }
            newArray.addAll(Arrays.asList(this.name));
            return newArray.toArray(new String[0]);
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ArrayList<String> newArray = new ArrayList<>();
            newArray.add(input[0][0]+input[0][1]);
            newArray.addAll(Arrays.asList(this.name));
            return newArray.toArray(new String[0]);
        }
    }

    /**
     * Sorting a Date from 'MasterFileAdmin'
     * @throws IOException If file not found
     */
    public void sortDate()throws IOException{
        fileStuff f = new fileStuff("MasterFileAdmin");
        String[][] input = f.getFileReading();
        Comparator<String[]> date = Comparator.comparing(row -> row[0]);
        Comparator<String[]> time = Comparator.comparing(row -> row[1]);
        Arrays.sort(input,date.thenComparing(time));
        f.fileWriting(input);
    }

    /**
     * Generate 30 Random Date,Time,Name and shop in 'MasterFileAdmin'
     * @throws IOException If file not found
     */
    public void randomGeneratorMaster() throws IOException {
        editStuff e = new editStuff("MasterFileAdmin");
        String[] randomData = e.setName();
        for (int i = 0; i < 30; i++) {
            long random = ThreadLocalRandom.current().nextLong(timeRangeMs);
            Date randDate = new Date(now.getTime() - random);
            String stringDate = DateFor.format(randDate);
            String stringTime = TimeFor.format(randDate);
            String[] arr = {stringDate,stringTime,
                    randomData[rand.nextInt(randomData.length)],
                    shop[rand.nextInt(shop.length)]};
            firstResult.add(arr);
        }
        String[][] finalResult = new String[firstResult.size()][];
        for (int i = 0; i < finalResult.length; i++) {
            finalResult[i] = firstResult.get(i);
        }

        fileStuff f = new fileStuff(super.toString());
        f.fileWriting(finalResult);

    }

    /**
     * Change a status of the Customer
     * @throws IOException If file not found
     * @throws ParseException If String cannot be convert into Date
     */
    public void changeStatus() throws IOException, ParseException {
        fileStuff f;
        editStuff e;
        String[][] readFile;
        System.out.println("Select a number to Flag a customer");
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();

        //must take name from MasterFile then cari the name in CustomerFileAdmin

        e = new editStuff("MasterFileAdmin");
        readFile = e.getFileReading();
        String nameFlag = readFile[userInput-1][2];

        e = new editStuff("CustomerFileAdmin");
        readFile = e.getFileReading();

        for (int i = 0; i < readFile.length; i++) {
            if (readFile[i][0].equals(nameFlag))
                readFile[i][2] = "Case";
        }
        e.fileWriting(readFile);

        f = new fileStuff("MasterFileAdmin");

        readFile = f.getFileReading();
        ArrayList<String> caseName = new ArrayList<>();
        ArrayList<String> caseShop = new ArrayList<>();
        ArrayList<String> caseDate = new ArrayList<>();
        ArrayList<String> caseTime = new ArrayList<>();

        caseDate.add(readFile[userInput-1][0]);
        caseTime.add(readFile[userInput-1][1]);
        caseName.add(readFile[userInput-1][2]);
        caseShop.add(readFile[userInput-1][3]);

        //change the shop status from caseShop array
        e = new editStuff("ShopFileAdmin");
        readFile = e.getFileReading();

        for (int i = 0; i < readFile.length; i++) {
            if (readFile[i][0].equals(caseShop.get(0)))
                readFile[i][3] = "Case";
        }
        e.fileWriting(readFile);

        //calculate person to get close status

        f = new fileStuff("MasterFileAdmin");
        readFile = f.getFileReading();
        ArrayList<String> possibleCase = new ArrayList<>();

        // getting possible time from other person
        for (int i = 0; i < readFile.length; i++) {
            if (readFile[i][0].equals(caseDate.get(0))){
                if (readFile[i][3].equals(caseShop.get(0))){
                    if (!readFile[i][2].equals(caseName.get(0)))
                        possibleCase.add(readFile[i][1]);
                }
            }
        }
        ArrayList<String> closeName = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date possibleTimeFromCase = sdf.parse(caseTime.get(0));
        for (int i = 0; i < possibleCase.size(); i++) {
            Date possibleTime = sdf.parse(possibleCase.get(i));
            long timeDiff = possibleTime.getTime() - possibleTimeFromCase.getTime();
            long x = Math.abs(timeDiff);
            int hours = (int) (x/(1000*60*60)%24);
            if (hours ==0 || hours ==23){
                for (int y = 0; y < readFile.length; y++) {
                    if (readFile[y][1].equals(possibleCase.get(i)))
                        closeName.add(readFile[y][2]);
                }
            }
        }
        e = new editStuff("CustomerFileAdmin");
        readFile = e.getFileReading();
        for (int i = 0; i < closeName.size(); i++) {
            for (int j = 0; j < readFile.length ; j++) {
                if (readFile[j][0].equals(closeName.get(i))){
                    if (!readFile[j][2].equals("Case")){
                        readFile[j][2] = "Close";}
                }
            }
        }
        e.fileWriting(readFile);
    }
}

/**
 * This class is for the use of Customer only
 */
class customerStuff extends fileStuff{
    customerStuff(){}

    /**
     * Setting the file name
     * @param fileName The name of the file
     */
    customerStuff(String fileName){super(fileName);}

    /**
     * Adding an info into 'CustomerFileAdmin'
     * @throws IOException If file not found
     */
    public void setInfoIntoAdminFile() throws IOException {
        fileStuff f = new fileStuff("registerStuff");
        String[][] inputFromRegister = f.getFileReading();
        // CustomerFileAdmin
        f = new fileStuff("CustomerFileAdminInitial");
        String[][] oldArr = f.getFileReading();
        ArrayList<String[]> arrToAdd = new ArrayList<>();
        for (int i = 0; i < oldArr.length; i++) {
            String[] add = {oldArr[i][0],oldArr[i][1],oldArr[i][2]};
            arrToAdd.add(add);
        }
        
        for (int i = 0; i < inputFromRegister.length; i++) {
            String[] add = {inputFromRegister[i][0]+inputFromRegister[i][1],
                    inputFromRegister[i][3],"Normal"};
            arrToAdd.add(add);
        }

        String[][] result = new String[arrToAdd.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = arrToAdd.get(i);
        }
        f=new fileStuff("CustomerFileAdmin");
        f.fileWriting(result);
    }

    /**
     * Update the customer check-in into 'MasterFileAdmin'
     * @param arr String[] contains {Date,Time,Name,Shop}
     * @throws IOException If file not found
     */
    public void UpdateCheckInShop(String[] arr) throws IOException {
        customerStuff c = new customerStuff("MasterFileAdmin");
        String[][] readFile = c.getFileReading();
        ArrayList<String[]> arrToAdd = new ArrayList<>();
        for (int i = 0; i < readFile.length; i++) {
            String[] add = {readFile[i][0],readFile[i][1]
                    ,readFile[i][2],readFile[i][3]};
            arrToAdd.add(add);
        }
        arrToAdd.add(arr);
        String[][] result = new String[arrToAdd.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = arrToAdd.get(i);
        }
        c.fileWriting(result);
        editStuff e = new editStuff();
        e.sortDate();
    }

}