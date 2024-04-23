package common.zipper;

import java.io.*;

/**
 *
 * @author Muyeed
 */
public class Compress {
    public boolean run(String location) {
        String sevenZipPath = "External/7-Zip/7z.exe";

        String[] command = { sevenZipPath, "a", "-t7z", location + "/Database.zip", "Database" };

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            return exitCode == 0;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
