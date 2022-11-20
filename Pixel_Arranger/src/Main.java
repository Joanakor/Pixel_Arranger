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
        ImageProcessor proc = new ImageProcessor();

        f = new File("C:/Users/mark6/OneDrive/Documents/Pixel_Arranger/Pixel_Arranger/testimages/test1.png");

        img = proc.Get_sorted_img(f);

        try {
            f = new File("C:/Users/mark6/OneDrive/Documents/Pixel_Arranger/Pixel_Arranger/testimages/result1.png");
            ImageIO.write(img, "png", f);
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }
}