package common.device;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageResizer {

    public void resize(String location, String destination) {
        try {
            File inputFile = new File(location);
            BufferedImage originalImage = ImageIO.read(inputFile);

            int newWidth = 50;
            int newHeight = 50;

            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
            g.dispose();

            File outputFile = new File(destination + "/User.jpg");
            ImageIO.write(resizedImage, "jpg", outputFile);

            System.out.println("Image resized successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
