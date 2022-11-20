import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ImageProcessor {

    public BufferedImage Sort_pixels(File f) throws IOException {
        BufferedImage img;
        img = ImageIO.read(f);
        int width = img.getWidth();
        int height = img.getHeight();
        int pixel = 0;

        Color color;
        String hex;
        ArrayList<Integer> pixelcolors = new ArrayList<>();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixel = img.getRGB(x, y);
                color = new Color(pixel);
                hex = String.format("%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
                pixelcolors.add((int) Long.parseLong(hex, 16));
            }
        }

        Collections.sort(pixelcolors);

        int count = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                img.setRGB(x, y, pixelcolors.get(count));
                count++;
            }
        }

        return img;
    }
}
