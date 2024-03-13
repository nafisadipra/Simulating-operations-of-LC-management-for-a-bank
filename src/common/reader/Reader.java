package common.reader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Muyeed
 */
public class Reader {
    private String location;
    private String fileName;

    public Reader(String location, String fileName) {
        this.location = location;
        this.fileName = fileName;
    }

    public String getLocation() {
        return location;
    }

    public String getFileName() {
        return fileName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Reader{" + "location=" + location + ", fileName=" + fileName + ", data=" + readFile() + '}';
    }

    public ArrayList<String> readFile() {
        ArrayList<String> data = new ArrayList();
        
        try {
            File directory = new File(location + "/" + fileName);

            if (!directory.exists()) {
                System.out.println("File does not exist!");
            }

            File myFile = new File(location + "/" + fileName);
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine()) {
                data.add(myReader.nextLine());
            }
        } catch (IOException e) {
        }

        return data;
    }
    
    public ArrayList spliteFile() {
        ArrayList <String> readData = readFile();
        ArrayList <ArrayList> splitData = new ArrayList();
        
        for (int j = 0; j < readData.size(); j++) {
            ArrayList itemData = new ArrayList();
            String data = "";
            for (int i = 0; i < readData.get(j).length(); i++) {
                if (readData.get(0).charAt(i) == '▓') {
                    itemData.add(data);
                    data = "";
                } else {
                    data += readData.get(0).charAt(i);
                }
            }
            splitData.add(itemData);
        }
        return splitData;
    }
}
