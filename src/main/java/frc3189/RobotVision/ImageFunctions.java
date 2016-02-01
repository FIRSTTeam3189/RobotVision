package frc3189.RobotVision;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;

public class ImageFunctions {
	/**
	 * does a threshold on the IPLImage that is passed in
	 * 
	 * @param source
	 *            the image to perform the threshold on
	 * @param redLow
	 *            low value of red
	 * @param redHigh
	 *            high value of red
	 * @param greenLow
	 *            low value of green
	 * @param greenHigh
	 *            high value of green
	 * @param blueLow
	 *            low value of blue
	 * @param blueHigh
	 *            high value of blue
	 * @param releaseSource
	 *            whether we should release the source image after performing
	 *            the threshold
	 * @return the threshold image
	 */
	public static IplImage thresholdRGB(IplImage source, int redLow,
			int redHigh, int greenLow, int greenHigh, int blueLow,
			int blueHigh, boolean releaseSource) {
		if (source == null) {
			throw new IllegalArgumentException("source");
		}

		IplImage threshhold = cvCreateImage(cvGetSize(source), 8, 1);
		CvScalar min = cvScalar(blueLow, greenLow, redLow, 0);
		CvScalar max = cvScalar(blueHigh, greenHigh, redHigh, 0);
		cvInRangeS(source, min, max, threshhold);

		if (releaseSource)
			cvReleaseImage(source);

		return threshhold;
	}

	/**
	 * does a threshold on the IPLImage that is passed in without releasing
	 * source image
	 * 
	 * @param source
	 *            the image to perform the threshold on
	 * @param redLow
	 *            low value of red
	 * @param redHigh
	 *            high value of red
	 * @param greenLow
	 *            low value of green
	 * @param greenHigh
	 *            high value of green
	 * @param blueLow
	 *            low value of blue
	 * @param blueHigh
	 *            high value of blue
	 * @return the threshold image
	 */
	public static IplImage thresholdRGB(IplImage source, int redLow,
			int redHigh, int greenLow, int greenHigh, int blueLow, int blueHigh) {
		return thresholdRGB(source, redLow, redHigh, greenLow, greenHigh,
				blueLow, blueHigh, false);
	}
}
