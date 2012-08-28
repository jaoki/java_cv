package java_cv;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Invert {

    public static void main(String[] args) throws IOException {
        File f = new File("C://Users//jaoki//coding//java_cv//src//main//resources//lena.jpg");
        BufferedImage readImage = ImageIO.read(f);
        
        CannyEdgeDetector detector = new CannyEdgeDetector();

		//adjust its parameters as desired
		detector.setLowThreshold(1f);
		detector.setHighThreshold(5f);
		
		//apply it to an image
		detector.setSourceImage(readImage);
		detector.process();
		BufferedImage edges = detector.getEdgesImage();        
        ImageIO.write(edges, "jpg", new File("target//edge.jpg"));
		
        int width = readImage.getWidth();
        int height = readImage.getHeight();
        BufferedImage writing = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                int c = readImage.getRGB(x, y);
                int r = 255 - c>>16 & 0xff;
                int g = 255 - c>>8 & 0xff;
                int b = 255 - c & 0xff;
                int rgb = 0xff000000 | r <<16 | g <<8 | b;
                writing.setRGB(x,y,rgb);
            }
        }
        
        File resultFile = new File("target//result.jpg");
        ImageIO.write(writing, "jpg", resultFile);

    }
}

