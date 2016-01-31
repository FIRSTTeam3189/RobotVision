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

	/**
	 * Gets the string value that represents this threshold parameter
	 * 
	 * @return the string value
	 */
	public String getStringValue() {
		return String.format("%d, %d, %d, %d, %d, %d", redLow, redHigh, greenLow, greenHigh, blueLow, blueHigh);
	}

	/**
	 * Gets the threshold parameters from the string value
	 * 
	 * @param value
	 *            the value to parse for the vision threshold parameters
	 * @return the vision threshold parameters
	 */
	public static VisionThresholdParameters getFromStringValue(String value) {
		// Split the sting value by comma and check if it contains 6 entries
		String[] split = value.split(",");
		if (split == null || split.length != 6) {
			throw new IllegalArgumentException("value");
		}

		// Get the threshold values from the split
		VisionThresholdParameters parameters = new VisionThresholdParameters();
		parameters.redLow = Integer.parseInt(split[0].trim());
		parameters.redHigh = Integer.parseInt(split[1].trim());
		parameters.greenLow = Integer.parseInt(split[2].trim());
		parameters.greenHigh = Integer.parseInt(split[3].trim());
		parameters.blueLow = Integer.parseInt(split[4].trim());
		parameters.blueHigh = Integer.parseInt(split[5].trim());

		return parameters;
	}

}
