/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Muyeed
 */
public class Writer {
    private String location;
    private String fileName;
    private String data;

    public Writer(String location, String fileName, String data) {
        this.location = location;
        this.fileName = fileName;
        this.data = data;
    }

    public String getLocation() {
        return location;
    }

    public String getFileName() {
        return fileName;
    }

    public String getData() {
        return data;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Writer{" + "location=" + location + ", fileName=" + fileName + ", data=" + data + '}';
    }
    
    public void writeFile() {
        try {
            File directory = new File(location);
            
            if (!directory.exists()) {
                directory.mkdirs();
            }
            
            File myFile = new File(location + "/" + fileName);
            try (FileWriter myWriter = new FileWriter(myFile)) {
                myWriter.write(data);
            }
            System.out.println("Data Stored");
            
        } catch (IOException e) {
        }
    }
    
}
