import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ImageProcessor {

    public BufferedImage getSortedImage(File f) throws IOException { //Returns image with sorted
        BufferedImage img;                                           //by hex values pixels
        img = ImageIO.read(f);
        ArrayList<Integer> pixelcolors = new ArrayList<>();

        pixelcolors = sortPixelsHex(pixelcolors, img);           //selected sorting

        int count = 0;
        for (int y = 0; y < img.getHeight(); y++) {                //Colors are inserted in every pixel
            for (int x = 0; x < img.getWidth(); x++) {             //one by one
                img.setRGB(x, y, pixelcolors.get(count));
                count++;
            }
        }
        return img;
    }

    public void printUniqueColorsPercent(BufferedImage img) throws IOException {
        
    }

    public ArrayList<Integer> sortPixelsHex(ArrayList<Integer> list, BufferedImage img) // Fills and sorts
    {                                                                                     //array of hex values
        int pixelColor = 0;

        Color color;
        String colorHexValue;

        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                pixelColor = img.getRGB(x, y);
                color = new Color(pixelColor);
                colorHexValue = String.format("%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
                list.add((int)Long.parseLong(colorHexValue, 16));
            }
        }
        Collections.sort(list);
        return list;
    }

    public ArrayList<Integer> sortPixelsHSB(ArrayList<Integer> list, BufferedImage img)
    {
        int pixel = 0;

        Color color;

        ArrayList<float[]> hsbvalues = new ArrayList<float[]>();

        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                pixel = img.getRGB(x, y);
                color = new Color(pixel);
                float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
                hsbvalues.add(hsb);
            }
        }

        ValuesSorter.bubbleSort(hsbvalues);
        for (float[] x : hsbvalues)
        {
            list.add(Color.HSBtoRGB(x[0], x[1], x[2]));
        }
        return list;
    }

}
