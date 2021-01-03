import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class fileStuff {
    private String fileName;
    fileStuff(){}
    fileStuff(String fileName){this.fileName = fileName;}
    public String toString(){
        return fileName;
    }
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
    SimpleDateFormat TimeFor = new SimpleDateFormat("HH:mm:ss");
    List<String[]> firstResult = new ArrayList<>();

    editStuff(){}
    editStuff(String filename){
        super(filename);
    }

    public void sortDate()throws IOException{
        fileStuff f = new fileStuff(super.toString());
        String[][] input = f.getFileReading();
        Comparator<String[]> date = Comparator.comparing(row -> row[0]);
        Comparator<String[]> time = Comparator.comparing(row -> row[1]);
        Arrays.sort(input,date.thenComparing(time));
        System.out.println("dah");
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

        fileStuff f = new fileStuff(super.toString());
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
    public void modifyFile(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);

        String oldContent = "";

        BufferedReader reader = null;

        FileWriter writer = null;

        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            //Reading all the lines of input text file into oldContent

            String line = reader.readLine();

            while (line != null)
            {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

            //Replacing oldString with newString in the oldContent

            String newContent = oldContent.replaceAll(oldString, newString);

            //Rewriting the input text file with newContent

            writer = new FileWriter(fileToBeModified);

            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources

                reader.close();

                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
    public void changeStatus() throws IOException, ParseException {
        Admin d = new Admin();
        fileStuff f;
        editStuff e;
        d.displayMaster();
        String[][] readFile;
        System.out.println("Select a number to Flag a customer");
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();

        e = new editStuff("CustomerFileAdmin");
        readFile = e.getFileReading();
        readFile[userInput-1][2] = "Case";
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

        System.out.println(caseDate);
        System.out.println(caseTime);
        System.out.println(caseName);
        System.out.println(caseShop);

        //change the shop status from caseShop array
        e = new editStuff("ShopFileAdmin");
        readFile = e.getFileReading();

        for (int i = 0; i < readFile.length; i++) {
            if (readFile[i][0].equals(caseShop.get(0)))
                readFile[i][3] = "Case";
        }
        e.fileWriting(readFile);


        //calculate siapa dpt close

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
        System.out.println(possibleCase);
        ArrayList<String> closeName = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date possibleTimeFromCase = sdf.parse(caseTime.get(0));
        for (int i = 0; i < possibleCase.size(); i++) {
            Date possibleTime = sdf.parse(possibleCase.get(i));
            long timeDiff = possibleTime.getTime() - possibleTimeFromCase.getTime();
            long x = Math.abs(timeDiff);
            int hours = (int) (x/(1000*60*60)%24);
            System.out.println(hours);
            if (hours ==0 || hours ==11){
                for (int y = 0; y < readFile.length; y++) {
                    if (readFile[y][1].equals(possibleCase.get(i)))
                        closeName.add(readFile[y][2]);
                }
            }
        }
        System.out.println(closeName);
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
