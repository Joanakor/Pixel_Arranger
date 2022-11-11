import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.util.Collections;

public class Main {
    public static void main(String args[])
            throws IOException

            //Getting the image
    {
        BufferedImage img = null;
        File f = null;

        try {
            f = new File(
                    "C:/Users/mark6/OneDrive/Documents/Pixel_Arranger/Pixel_Arranger/inputimage.jpg");
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }


        int width = img.getWidth();
        int height = img.getHeight();
        int pixel = 0;

        Color color;
        String hex;
        ArrayList<Integer> pixelcolors = new ArrayList<>();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++){
                pixel = img.getRGB(x, y);
                color = new Color(pixel);
                hex = String.format("%02x%02x%02x", color.getRed(),color.getGreen(),color.getBlue());
                pixelcolors.add((int)Long.parseLong(hex, 16));
            }
        }

        Collections.sort(pixelcolors);

        int count = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++){
                img.setRGB(x, y, pixelcolors.get(count));
                count++;
            }
        }

        try {
            f = new File(
                    "C:/Users/mark6/OneDrive/Documents/Pixel_Arranger/Pixel_Arranger/outputimage.jpg");
            ImageIO.write(img, "png", f);
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }
}