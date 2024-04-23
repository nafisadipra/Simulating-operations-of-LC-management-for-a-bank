package common.reader;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
                return data;
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
    
    public ArrayList<ArrayList<String>> splitFile(char variable) {
        ArrayList<String> readData = readFile();
        ArrayList<ArrayList<String>> fetchList = new ArrayList();
        for (String x: readData) {
            ArrayList<String> addData = new ArrayList();
            String[] fetchData = x.split(variable + "");
            addData.addAll(Arrays.asList(fetchData));
            fetchList.add(addData);
        }
        return fetchList;
    }
    
    public void openFile() {
        File file = new File(location + "/" + fileName);
        try {
            if (!Desktop.isDesktopSupported()) {
                System.out.println("Desktop is not supported!");
                return;
            }
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (IOException e) {
            System.out.println("Error opening file: " + e.getMessage());
        }
    }

}
