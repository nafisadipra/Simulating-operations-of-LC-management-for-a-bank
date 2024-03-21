package common.xdir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author Muyeed
 */
public class XDIR {
    private String sourceFilePath;
    private String destinationFolderPath;

    public XDIR(String sourceFilePath, String destinationFolderPath) {
        this.sourceFilePath = sourceFilePath;
        this.destinationFolderPath = destinationFolderPath;
    }

    public String getSourceFilePath() {
        return sourceFilePath;
    }

    public String getDestinationFolderPath() {
        return destinationFolderPath;
    }

    public void setSourceFilePath(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
    }

    public void setDestinationFolderPath(String destinationFolderPath) {
        this.destinationFolderPath = destinationFolderPath;
    }

    @Override
    public String toString() {
        return "XDIR{" + "sourceFilePath=" + sourceFilePath + ", destinationFolderPath=" + destinationFolderPath + '}';
    }
    
    public void copyFile() {
        try {
            Path sourcePath = Paths.get(sourceFilePath);
            Path destinationPath = Paths.get(destinationFolderPath);

            if (!Files.exists(destinationPath)) {
                Files.createDirectories(destinationPath);
            }

            Files.copy(sourcePath, destinationPath.resolve(sourcePath.getFileName()), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Copy Successful!");
        } catch (IOException e) {
            System.out.println("Copy Failed!");
            e.printStackTrace();
        }
    }

    public void moveFile() {
        try {
            Path sourcePath = Paths.get(sourceFilePath);
            Path destinationPath = Paths.get(destinationFolderPath);

            if (!Files.exists(destinationPath)) {
                Files.createDirectories(destinationPath);
            }

            Files.move(sourcePath, destinationPath.resolve(sourcePath.getFileName()), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Move Successful!");
        } catch (IOException e) {
            System.out.println("Move Failed!");
            e.printStackTrace();
        }
    }

}
