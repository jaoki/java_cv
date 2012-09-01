package java_cv;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ImageTraverser {
	List<ImageTraverserCallback> callbacks;

	public ImageTraverser(){
		callbacks = new ArrayList<ImageTraverserCallback>();
	}

	public void traverse(BufferedImage source){
	
        int width = source.getWidth();
        int height = source.getHeight();

    	for(ImageTraverserCallback callback : callbacks){
			callback.setSource(source);
    	}

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
            	for(ImageTraverserCallback callback : callbacks){
					callback.execute(x, y);
            	}
            }
        }

        // finalize operation
    	for(ImageTraverserCallback callback : callbacks){
			callback.end();
    	}
	}

	public void addCallback(ImageTraverserCallback callback){
		callbacks.add(callback);
	}

	public static abstract class ImageTraverserCallback{
		protected BufferedImage _source;
		protected BufferedImage _result;

		public ImageTraverserCallback(){}

		public void setSource(BufferedImage source){
			this._source = source; 
	        int width = _source.getWidth();
	        int height = _source.getHeight();
			_result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		}

		public abstract void execute(int x, int y);
		public abstract void end();


	}

}
