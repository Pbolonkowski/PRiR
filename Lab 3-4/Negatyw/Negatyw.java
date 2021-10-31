import java.awt.*;
import java.awt.image.BufferedImage;

public class Negatyw extends Thread {
        BufferedImage image;
        int kolumna;
        int dlugosc_obrazka;

        public Negatyw(BufferedImage image, int kolumna, int dlugosc_obrazka){
            this.image=image;
            this.kolumna=kolumna;
            this.dlugosc_obrazka=dlugosc_obrazka;
        }
        @Override
        public void run() {

            for(int j=0;j<dlugosc_obrazka;j++){

                Color c = new Color(image.getRGB(j,kolumna));
                double red =(double) (c.getRed());
                double green = (double)(c.getGreen());
                double blue = (double)(c.getBlue());

                double x,y,z;
                x=0;
                y=0;
                z=0;

                    x = 255-red;
                    y=  255-green;
                    z=  255-blue;

                Color newColor = new Color((int)x,(int)y,(int)z);
                image.setRGB(j,kolumna,newColor.getRGB());

            }
        }
}




