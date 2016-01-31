package frc3189.RobotVision;

public class VisionThresholdParameters {
	private int redLow;
	private int redHigh;
	private int greenLow;
	private int greenHigh;
	private int blueLow;
	private int blueHigh;

	/**
	 * Gives the value of the lowest red in the threshold
	 * 
	 * @return the value of the lowest red in the threshold
	 */
	public int getRedLow() {
		return redLow;
	}

	/**
	 * Gives the value of the highest red in the threshold
	 * 
	 * @return the value of the highest red in the threshold
	 */
	public int getRedHigh() {
		return redHigh;
	}

	/**
	 * Gives the value of the lowest blue in the threshold
	 * 
	 * @return the value of the lowest blue in the threshold
	 */
	public int getGreenLow() {
		return greenLow;
	}

	/**
	 * Gives the value of the highest green in the threshold
	 * 
	 * @return the value of the highest green in the threshold
	 */
	public int getGreenHigh() {
		return greenHigh;
	}

	/**
	 * Gives the value of the lowest blue in the threshold
	 * 
	 * @return the value of the lowest blue in the threshold
	 */
	public int getBlueLow() {
		return blueLow;
	}

	/**
	 * Gives the value of the highest blue in the threshold
	 * 
	 * @return the value of the highest blue in the threshold
	 */
	public int getBlueHigh() {
		return blueHigh;
	}

	/**
	 * Sets the value of the lowest red in the threshold
	 * 
	 * @param redLow
	 *            the value of the lowest red in the threshold
	 */
	public void setRedLow(int redLow) {
		this.redLow = redLow;
	}

	/**
	 * Sets the value of the highest red in the threshold
	 * 
	 * @param redHigh
	 *            the value of the highest red in the threshold
	 */
	public void setRedHigh(int redHigh) {
		this.redHigh = redHigh;
	}

	/**
	 * Sets the value of the lowest green in the threshold
	 * 
	 * @param greenLow
	 *            the value of the lowest green in the threshold
	 */
	public void setGreenLow(int greenLow) {
		this.greenLow = greenLow;
	}

	/**
	 * Sets the value of the highest green in the threshold
	 * 
	 * @param greenHigh
	 *            the value of the highest green in the threshold
	 */
	public void setGreenHigh(int greenHigh) {
		this.greenHigh = greenHigh;
	}

	/**
	 * Sets the value of the lowest blue in the threshold
	 * 
	 * @param blueLow
	 *            the value of the lowest green in the threshold
	 */
	public void setBlueLow(int blueLow) {
		this.blueLow = blueLow;
	}

	/**
	 * Sets the value of the highest blue in the threshold
	 * 
	 * @param blueHigh
	 *            the value of the highest blue in the threshold
	 */
	public void setBlueHigh(int blueHigh) {
		this.blueHigh = blueHigh;
	}
}
