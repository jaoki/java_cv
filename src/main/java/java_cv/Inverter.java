package java_cv;

import java.io.File;
import java.io.IOException;

import java_cv.ImageTraverser.ImageTraverserCallback;

import javax.imageio.ImageIO;

public class Inverter extends ImageTraverserCallback{

	@Override
	public void execute(int x, int y) {
        int c = _source.getRGB(x, y);
        int r = 255 - c>>16 & 0xff;
        int g = 255 - c>>8 & 0xff;
        int b = 255 - c & 0xff;
        int rgb = 0xff000000 | r <<16 | g <<8 | b;
        _result.setRGB(x,y,rgb);
		
	}

	@Override
	public void end() {
        File invertedImageFile = new File("target//invert.jpg");
        try {
			ImageIO.write(_result, "jpg", invertedImageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

