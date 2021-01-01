import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fileStuff {

    Scanner readFile;
    public List<String> readingFile(String fileName) throws IOException{
        File file = new File(fileName);
        readFile = new Scanner(file);
        List<String> result = new ArrayList<String>();
        while(readFile.hasNextLine()){
            String data = readFile.nextLine();
            result.add(data);
        }
        return result;
    }
}
