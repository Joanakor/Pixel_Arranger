import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String args[]) throws IOException
    {
        BufferedImage img = null;
        File f = null;
        ImageProcessor proc = new ImageProcessor();

        String inputfile = "testimage.png";
        String outputfile = "testimage3.png";

        f = new File("C:/Users/mark6/OneDrive/Documents/Pixel_Arranger/Pixel_Arranger/testimages/" + inputfile);

        img = proc.getSortedImage(f);

        try {
            f = new File("C:/Users/mark6/OneDrive/Documents/Pixel_Arranger/Pixel_Arranger/testimages/" + outputfile);
            ImageIO.write(img, "png", f);
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }
}