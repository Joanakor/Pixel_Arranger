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
        ArrayList<Integer> pixelColors = new ArrayList<>();

        pixelColors = sortPixelsHex(pixelColors, img);           //selected sorting

        int count = 0;
        for (int y = 0; y < img.getHeight(); y++) {                //Colors are inserted in every pixel
            for (int x = 0; x < img.getWidth(); x++) {             //one by one
                img.setRGB(x, y, pixelColors.get(count));
                count++;
            }
        }
        return img;
    }

    public void printUniqueColorsPercent(BufferedImage img) throws IOException {

        int pixelColor = 0;

        Color color;
        String colorHexValue;

        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                pixelColor = img.getRGB(x, y);
                color = new Color(pixelColor);
                colorHexValue = String.format("%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());

            }
        }
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

    public ArrayList<Integer> sortPixelsHSB (ArrayList<Integer> list, BufferedImage img)
    {
        int pixelColor = 0;

        Color color;

        ArrayList<float[]> hsbValues = new ArrayList<float[]>();

        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                pixelColor = img.getRGB(x, y);
                color = new Color(pixelColor);
                float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
                hsbValues.add(hsb);
            }
        }

        ValuesSorter.bubbleSort(hsbValues);
        for (float[] x : hsbValues)
        {
            list.add(Color.HSBtoRGB(x[0], x[1], x[2]));
        }
        return list;
    }

    public ArrayList<Integer> getArrayWithUniqueColors (ArrayList<Integer> pixelColors){

        int index = 0;
        return null;

    }

}
