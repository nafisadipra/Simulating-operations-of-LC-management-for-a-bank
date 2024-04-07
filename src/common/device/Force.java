package common.device;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Force {
    public void deleteFolder(String folderPath) {
        Path folder = Paths.get(folderPath);
        if (!Files.exists(folder)) {
            return;
        }

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(folder)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    deleteFolder(entry.toString());
                } else {
                    Files.delete(entry);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Force.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
