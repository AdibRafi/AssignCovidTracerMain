import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Admin {
    Admin(){}
    public void displayCustomer() throws IOException {
        fileStuff f = new fileStuff("CustomerFileAdmin");
        String[][] fileRead = f.getFileReading();
        System.out.println(String.format("%-5s %-15s %-15s %s", "No",
                    "Name", "Phone", "Status"));
        for (int i = 0; i < fileRead.length; i++) {
            System.out.println(String.format("%-5s %-15s %-15s %s",
                    i+1, fileRead[i][0], fileRead[i][1],fileRead[i][2]));
        }
    }
    public void displayShops() throws IOException{
        fileStuff f = new fileStuff("ShopFileAdmin");
        String[][] fileRead = f.getFileReading();
        System.out.println(String.format("%-5s %-15s %-15s %-10s %s","No",
                "Name", "Phone", "Manager","Status"));
        for (int i = 0; i <fileRead.length; i++) {
            System.out.println(String.format("%-5s %-15s %-15s %-10s %s"
                    , i+1,fileRead[i][0],fileRead[i][1],fileRead[i][2],fileRead[i][3]));
        }
    }
    public void displayMaster() throws IOException {
        fileStuff f = new fileStuff("MasterFileAdmin");
        String[][] fileRead = f.getFileReading();
        System.out.println(String.format("%-5s %-13s %-10s %-16s %s","No",
                "Date", "Time", "Customer","Shop"));
        for (int i = 0; i < fileRead.length; i++) {
            System.out.println(String.format("%-5s %-13s %-10s %-16s %s"
                    , i+1,fileRead[i][0],fileRead[i][1],fileRead[i][2],fileRead[i][3]));
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


