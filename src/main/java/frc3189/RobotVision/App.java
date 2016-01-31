package frc3189.RobotVision;

import org.bytedeco.javacpp.opencv_core.IplImage;
import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;

import static org.bytedeco.javacpp.opencv_imgcodecs.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	smooth("resources/test.jpg");
    }
    
    public static void smooth(String filename) { 
        IplImage image = cvLoadImage(filename);
        if (image != null) {
        	System.out.println("Made it here");
            cvSmooth(image, image);
            cvSaveImage(filename, image);
            cvReleaseImage(image);
        }
    }
}
