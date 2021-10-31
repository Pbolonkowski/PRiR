import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedImage image;
        int width;
        int height;


        File input = new File("zdjecie.jpg");
        image = ImageIO.read(input);
        width = image.getWidth();
        height= image.getHeight();

        for(int i=0;i<height;i++){
            Negatyw negatyw = new Negatyw(image,i,width);
            negatyw.run();
        }

        File ouptut = new File("nowy_negatyw.jpg");
        ImageIO.write(image, "jpg", ouptut);
    }
}
