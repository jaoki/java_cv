package java_cv;

import java.util.List;

public class ImageTraverser {
	List<ImageTraverserCallback> callbacks;
	public void addCallback(ImageTraverserCallback callback){
		callbacks.add(callback);
	}
	
	public void traverse(){
		
	}
	
	public static interface ImageTraverserCallback{
		public void execute();
	}

}
