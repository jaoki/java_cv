package java_cv;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {
	public static void main(String[] args) throws IOException{
        BufferedImage lenaImage = ImageIO.read(new File("C://Users//jaoki//coding//java_cv//src//main//resources//lena.jpg"));

        CannyEdgeDetector canny = new CannyEdgeDetector();
		canny.setLowThreshold(1f);
		canny.setHighThreshold(5f);
		canny.setSourceImage(lenaImage);
		canny.process();
		BufferedImage edgeImage = canny.getEdgesImage();        
        ImageIO.write(edgeImage, "jpg", new File("target//edge.jpg"));

        ImageTraverser traverser = new ImageTraverser();

        Inverter inverter = new Inverter();
        traverser.addCallback(inverter);
        traverser.traverse(lenaImage);

//        inverter.invert(lenaImage);

	}

}
