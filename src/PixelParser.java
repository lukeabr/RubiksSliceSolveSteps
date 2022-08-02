import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class PixelParser {

        Image unscaledImage;
        BufferedImage outputImage;
        BufferedImage image;
        String name;
        File input;

        public PixelParser() {
            System.out.println("Pixel Parser Created");
        }
        public void loadImage(String fn){
            System.out.println("Load Image");
            input = new File(fn);
            System.out.println("File Loaded");
            name = fn.substring(0, fn.length() - 4);
        }
        public Color[][] getMatrix(int width, int height){
            try {
                unscaledImage = ImageIO.read(input);
                image = convertToBufferedImage(unscaledImage.getScaledInstance(width, height, Image.SCALE_SMOOTH));
                outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = outputImage.createGraphics();
                int count = 0;
                Color[][] colorArr = new Color[width][height];
                for(int i=0; i<height; i++) {

                    for(int j=0; j<width; j++) {

                        count++;
                        Color c = new Color(image.getRGB(j, i));

                        //g2d.setColor(rgbToColor(c));
                        //g2d.setPaintMode();
                        //g2d.drawLine(j, i, j, i);
                        Color newC = rgbToColor(c);
                        colorArr[j][i] = newC;
                        System.out.println("New Color: " + newC);
                        System.out.println(newC.getRGB());
                        Color[] colors = {Color.blue, Color.red, Color.green, Color.orange, Color.yellow, Color.white};
                        outputImage.setRGB(j, i, newC.getRGB());
                        System.out.println("S.No: " + count + " Red: " + c.getRed() +" Green: " + c.getGreen() + " Blue: " + c.getBlue());
                    }

                }
                String pathname = name + "_coded.jpg";
                File codedImage = new File(pathname);
                ImageIO.write(outputImage, "jpg", codedImage);
                System.out.println("Preview saved at: (" + pathname + ")");
                return colorArr;
            } catch (Exception e) {return null;}

        }
    public static Color rgbToColor(Color color){
            int[] weights = {1, 1, 1};
            Color[] colors = {Color.blue, Color.red, Color.green, Color.orange, Color.yellow, Color.white};
            int minDist = (int)Math.sqrt(Math.pow((weights[0] * Math.abs(color.getRed() - Color.blue.getRed())), 2) + Math.pow((weights[1] * Math.abs(color.getBlue() - Color.blue.getBlue())), 2) + Math.pow((weights[2] * Math.abs(color.getGreen() - Color.blue.getGreen())), 2));
            Color closestC = Color.blue;
            int dist = 0;
            int minDex = 0;
            for (Color colori : colors) {
                dist = (int)Math.sqrt(Math.pow((weights[0] * Math.abs(color.getRed() - colori.getRed())), 2) + Math.pow((weights[1] * Math.abs(color.getBlue() - colori.getBlue())), 2) + Math.pow((weights[2] * Math.abs(color.getGreen() - colori.getGreen())), 2));
                if(dist < minDist){
                    closestC = colori;
                    minDist = dist;
                }
            }
            System.out.println(closestC.getRed() + " " + closestC.getGreen() + " " + closestC.getBlue());
            return closestC;
    }
    public static BufferedImage convertToBufferedImage(Image img) {

        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bi = new BufferedImage(
                img.getWidth(null), img.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics2D = bi.createGraphics();
        graphics2D.drawImage(img, 0, 0, null);
        graphics2D.dispose();

        return bi;
    }
//        static public void main(String args[]) throws Exception {
////            PixelParser obj = new PixelParser();
//        }
}