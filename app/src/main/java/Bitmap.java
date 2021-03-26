
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.lang.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Bitmap {

    public static void test(){
        System.out.println("test bitmap");
    }
    public static void flipImage(File outputFilePath, BufferedImage image) throws IOException {
        int width = image.getWidth();
        int height = image.getHeight();
        List<Integer> pixels = new ArrayList<>();
        for(int i = 0; i < height; i++){
            for(int j = 0; j< width; j++){
                pixels.add(image.getRGB(i,j));
            }
        }

        List<Integer> revPixels = new ArrayList<>();
        int[]revPixels2 = new int[pixels.size()];
        for( int i = pixels.size() -1; i >= 0; i--){
            revPixels2[i] = pixels.get(i);
        }

        image.setRGB(0,0, width, height, revPixels2, 0,  40);

        ImageIO.write(image, "bmp", outputFilePath);
        System.out.println("The flipImage method was successful");
    }


    public static void addBorder(File outputFilePath, BufferedImage image) throws IOException {
        int width = image.getWidth();
        int height = image.getHeight();
        for(int i = 0; i < height; i++){
            for(int j = 0; j< width; j++){
                if(i == 0 || j == 0 || i == height-1 || j == width-1){
                    image.setRGB(i, j, 0);
                }
            }
        }
        ImageIO.write(image, "bmp", outputFilePath);
        System.out.println("The addBorder method was successful");
    }


    public static void greyScale(File outputFilePath, BufferedImage image) throws IOException {
        int width = image.getWidth();
        int height = image.getHeight();
        for(int i = 0; i < height; i++){
            for(int j = 0; j< width; j++){
                int rgb = image.getRGB(i,j);
                Color rgbColor = new Color(rgb);
                int red = rgbColor.getRed();
                int green = rgbColor.getGreen();
                int blue = rgbColor.getBlue();
                int grey = ((red + green + blue) / 3);
                Color grey2 = new Color(grey, grey, grey);
                image.setRGB(i,j,grey2.getRGB());
            }
        }
        ImageIO.write(image, "bmp", outputFilePath);
        System.out.println("The greyScale method was successful");
    }


}
