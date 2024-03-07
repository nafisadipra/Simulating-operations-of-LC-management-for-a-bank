/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    private String location;
    private String fileName;
    private final ArrayList<String> data;

    public Reader(String location, String fileName) {
        this.location = location;
        this.fileName = fileName;
        this.data = new ArrayList<>();
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
}
