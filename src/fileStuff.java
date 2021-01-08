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
    public void fileWriting(String[] strings)throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (int j = 0; j < strings.length; j++) {
            writer.write(strings[j]+
                    ((j==strings.length-1) ? "" : ","));
        }
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
        writer.close();
    }
}

class editStuff extends fileStuff{
    private final String[] name = {"Adib", "Ali", "Darwisy","Raja","Ahmad"};
    private final String[] shop = {"Tesco", "Parkson","Jaya Grocer","Kfry"};
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

    public String[] setName() throws IOException {
        editStuff e = new editStuff("registerStuff");
        String[][] input = e.getFileReading();

        try{
            ArrayList<String> newArray = new ArrayList<>();
            for (int i = 0; i < input.length; i++) {
                newArray.add(input[i][0]+input[i][1]);
            }
            newArray.addAll(Arrays.asList(this.name));
            System.out.println(newArray);
            return newArray.toArray(new String[0]);
        }
        catch (ArrayIndexOutOfBoundsException ex){
            ArrayList<String> newArray = new ArrayList<>();
            newArray.add(input[0][0]+input[0][1]);
            newArray.addAll(Arrays.asList(this.name));
            System.out.println(newArray);
            return newArray.toArray(new String[0]);
        }
    }
    public void sortDate()throws IOException{
        fileStuff f = new fileStuff(super.toString());
        String[][] input = f.getFileReading();
        Comparator<String[]> date = Comparator.comparing(row -> row[0]);
        Comparator<String[]> time = Comparator.comparing(row -> row[1]);
        Arrays.sort(input,date.thenComparing(time));
        f.fileWriting(input);

    }
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
    public void changeStatus() throws IOException, ParseException {
        fileStuff f;
        editStuff e;
        String[][] readFile;
        System.out.println("Select a number to Flag a customer");
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();

        //kena amik name from MasterFile then cari the name in CustomerFileAdmin

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
        ArrayList<String> closeName = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date possibleTimeFromCase = sdf.parse(caseTime.get(0));
        for (int i = 0; i < possibleCase.size(); i++) {
            Date possibleTime = sdf.parse(possibleCase.get(i));
            long timeDiff = possibleTime.getTime() - possibleTimeFromCase.getTime();
            long x = Math.abs(timeDiff);
            int hours = (int) (x/(1000*60*60)%24);
            if (hours ==0 || hours ==11){
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

class customerStuff extends fileStuff{
    customerStuff(){}
    customerStuff(String fileName){super(fileName);}
    public void setInfoIntoAdminFile() throws IOException {
        fileStuff f = new fileStuff("registerStuff");
        String[] inputFromRegister = f.getFileReading1row();
        // CustomerFileAdmin
        String[] arrayToAdd = {inputFromRegister[0]+inputFromRegister[1],
        inputFromRegister[3],"Normal"};

        f = new fileStuff("CustomerFileAdmin");
        String[][] newArray = Arrays.copyOf(f.getFileReading(),
                f.getFileReading().length+1);
        newArray[f.getFileReading().length] = arrayToAdd;
        f.fileWriting(newArray);

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
