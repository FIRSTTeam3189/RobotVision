package frc3189.RobotVision;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameConverter;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Hello world!
 *
 */
public class App {

	private static VisionThresholdParameters params;

	public static void main(String[] args) throws Exception {
		File file = new File("Threshold.conf");
		if (file.exists()) {
			params = VisionThresholdParameters.loadFromDisk(file.getPath());
		} else {
			params = VisionThresholdParameters.getFromStringValue("0, 155, 0, 155, 0, 155");
		}
		FrameGrabber grabber = FrameGrabber.createDefault(1);
		CanvasFrame canvas = new CanvasFrame("Camera Threshold");
		CanvasFrame uneditedCanvas = new CanvasFrame("Camera");
		
		canvas.getContentPane().add(getControlPanel(), BorderLayout.EAST);
		grabber.start();

		OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();

		IplImage threshold = null;
		IplImage grabbedImage = converter.convert(grabber.grab());
		while ((canvas.isVisible() || uneditedCanvas.isVisible()) && (grabbedImage = converter.convert(grabber.grab())) != null) {
			if (threshold != null)
				cvReleaseImage(threshold);

			threshold = ImageFunctions.thresholdRGB(grabbedImage, params.getRedLow(), params.getRedHigh(),
					params.getGreenLow(), params.getGreenHigh(), params.getBlueLow(), params.getBlueHigh());
			canvas.showImage(converter.convert(threshold));
			uneditedCanvas.showImage(converter.convert(grabbedImage));
		}

		grabber.stop();
		canvas.dispose();
		uneditedCanvas.dispose();
	}

	public static JPanel getControlPanel() {
		JTextField lowRedField = new JTextField(params.getRedLow() + "");
		JTextField lowGreenField = new JTextField(params.getGreenLow() + "");
		JTextField lowBlueField = new JTextField(params.getBlueLow() + "");
		JTextField highRedField = new JTextField(params.getRedHigh() + "");
		JTextField highGreenField = new JTextField(params.getGreenHigh() + "");
		JTextField highBlueField = new JTextField(params.getBlueHigh() + "");

		JButton commit = new JButton("Commit");
		JButton save = new JButton("Save to Disk");
		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(new JLabel("Red Low"));
		panel.add(lowRedField);
		panel.add(new JLabel("Green Low"));
		panel.add(lowGreenField);
		panel.add(new JLabel("Blue Low"));
		panel.add(lowBlueField);
		panel.add(new JLabel("Red High"));
		panel.add(highRedField);
		panel.add(new JLabel("Green High"));
		panel.add(highGreenField);
		panel.add(new JLabel("Blue High"));
		panel.add(highBlueField);
		panel.add(commit);
		panel.add(save);

		commit.addActionListener(e -> {
			if (isInt(lowRedField.getText()) && isInt(lowGreenField.getText()) && isInt(lowBlueField.getText())
					&& isInt(highRedField.getText()) && isInt(highGreenField.getText())
					&& isInt(highBlueField.getText())) {
				int redLow = Integer.parseInt(lowRedField.getText());
				int greenLow = Integer.parseInt(lowGreenField.getText());
				int blueLow = Integer.parseInt(lowBlueField.getText());
				int redHigh = Integer.parseInt(highRedField.getText());
				int greenHigh = Integer.parseInt(highGreenField.getText());
				int blueHigh = Integer.parseInt(highBlueField.getText());

				params.setRedLow(redLow);
				params.setGreenLow(greenLow);
				params.setBlueLow(blueLow);
				params.setRedHigh(redHigh);
				params.setGreenHigh(greenHigh);
				params.setBlueHigh(blueHigh);
			}
		});

		save.addActionListener(e -> params.saveToDisk("Threshold.conf"));

		return panel;
	}

	public static boolean isInt(String x) {
		try {
			Integer.parseInt(x);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
