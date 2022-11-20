import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ImageProcessor {

    public BufferedImage Get_sorted_img(File f) throws IOException {
        BufferedImage img;
        img = ImageIO.read(f);
        ArrayList<Integer> pixelcolors = new ArrayList<>();
//        int width = img.getWidth();
//        int height = img.getHeight();
//        int pixel = 0;
//
//        Color color;
//        String hex;
//        ArrayList<Integer> pixelcolors = new ArrayList<>();
//
//        for (int y = 0; y < height; y++) {
//            for (int x = 0; x < width; x++) {
//                pixel = img.getRGB(x, y);
//                color = new Color(pixel);
//                hex = String.format("%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
//                pixelcolors.add((int) Long.parseLong(hex, 16));
//            }
//        }
//
//        Collections.sort(pixelcolors);

        pixelcolors = Sort_pixels(pixelcolors, img);

        int count = 0;
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                img.setRGB(x, y, pixelcolors.get(count));
                count++;
            }
        }
        return img;
    }

    public ArrayList<Integer> Sort_pixels(ArrayList<Integer> list, BufferedImage img)
    {
        int pixel = 0;

        Color color;
        String hex;

        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                pixel = img.getRGB(x, y);
                color = new Color(pixel);
                hex = String.format("%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
                list.add((int) Long.parseLong(hex, 16));
            }
        }

        Collections.sort(list);
        return list;
    }


}
