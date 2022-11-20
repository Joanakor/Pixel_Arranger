import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

public class ImageProcessor {

    public BufferedImage Get_sorted_img(File f) throws IOException { //Returns image with sorted
        BufferedImage img;                                           //by hex values pixels
        img = ImageIO.read(f);
        ArrayList<Integer> pixelcolors = new ArrayList<>();

        pixelcolors = Sort_pixels_hsb(pixelcolors, img);

        int count = 0;
        for (int y = 0; y < img.getHeight(); y++) {                //Colors are inserted in every pixel
            for (int x = 0; x < img.getWidth(); x++) {             //one by one
                img.setRGB(x, y, pixelcolors.get(count));
                count++;
            }
        }
        return img;
    }

    public ArrayList<Integer> Sort_pixels_hex(ArrayList<Integer> list, BufferedImage img) // Fills and sorts
    {                                                                                     //array of hex values
        int pixel = 0;

        Color color;
        String hex;

        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                pixel = img.getRGB(x, y);
                color = new Color(pixel);
                hex = String.format("%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
                list.add((int)Long.parseLong(hex, 16));
            }
        }
        Collections.sort(list);
        return list;
    }

    public ArrayList<Integer> Sort_pixels_hsb(ArrayList<Integer> list, BufferedImage img)
    {
        int pixel = 0;

        Color color;

        BigDecimal hue;

        ArrayList<float[]> hsbvalues = null;

        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                pixel = img.getRGB(x, y);
                color = new Color(pixel);
                //hex = String.format("%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
                float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
                hsbvalues.add(hsb);
            }
        }
        return list;
    }

}
