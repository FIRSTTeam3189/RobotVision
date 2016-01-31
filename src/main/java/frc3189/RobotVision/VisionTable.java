package frc3189.RobotVision;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class VisionTable {

	private static final VisionTable instance = new VisionTable();

	/**
	 * Gets the instance of the vision table to be used across the imaging
	 * system
	 * 
	 * @return the instance
	 */
	public static VisionTable getInstance() {
		return instance;
	}

	private NetworkTable table;
	private double targetX;
	private double targetY;
	private double distance;
	private boolean targetFound;

	private VisionTable() {
		// This is the singleton so we're only using one instance across the
		// vision system
		NetworkTable.initialize();
		table = NetworkTable.getTable("vision");
	}

	/**
	 * Updates the value on the network table
	 */
	public void update() {
		table.putNumber("TargetX", targetX);
		table.putNumber("TargetY", targetY);
		table.putNumber("Distance", distance);
		table.putBoolean("IsFound", targetFound);
	}

	/**
	 * Sets the targetX value to be sent back through the network table
	 * 
	 * @param x
	 *            is the value of the new X position of the new target
	 */
	public void setTargetX(double x) {
		targetX = x;
	}

	/**
	 * Sets the targetY value to be sent back through the network table
	 * 
	 * @param y
	 *            is the value of the new Y position of the new target
	 */
	public void setTargetY(double y) {
		targetY = y;
	}

	/**
	 * Sets the distance from the target to be sent back through the network
	 * table
	 * 
	 * @param distance
	 *            is the new distance value of the target
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * Sets whether the target has been found by the imaging system
	 * 
	 * @param found
	 *            has the target been found by the imaging system
	 */
	public void setIsFound(boolean found) {
		targetFound = found;
	}

}