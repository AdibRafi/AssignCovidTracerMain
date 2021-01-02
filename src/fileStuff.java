import java.io.*;
import java.util.*;

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
