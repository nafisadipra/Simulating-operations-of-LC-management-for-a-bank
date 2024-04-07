package common.zipper;


import java.io.*;

public class Decompress {
    public boolean run(String location) {
        String sevenZipPath = "External/7-Zip/7z.exe";

        String[] command = { sevenZipPath, "x", location, "Database" };

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
