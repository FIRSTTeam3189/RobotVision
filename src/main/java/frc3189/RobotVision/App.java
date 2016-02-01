package frc3189.RobotVision;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	FrameGrabber grabber = FrameGrabber.createDefault(1);
    	CanvasFrame canvas = new CanvasFrame("Camera");
    	grabber.start();
    	
    	OpenCVFrameConverter.ToIplImage converter = new  OpenCVFrameConverter.ToIplImage();

    	
    	IplImage threshold = null; 
		IplImage grabbedImage = converter.convert(grabber.grab());
    	while (canvas.isVisible() && (grabbedImage = converter.convert(grabber.grab())) != null){
    		if (threshold != null)
    			cvReleaseImage(threshold);
    		
    		threshold = ImageFunctions.thresholdRGB(grabbedImage, 0, 155, 0, 155, 0, 155);
    		canvas.showImage(converter.convert(threshold));
    	}
		
    	grabber.stop();
    	canvas.dispose();
    }
    
}
