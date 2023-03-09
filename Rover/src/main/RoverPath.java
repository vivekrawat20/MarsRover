package main;
import handleException.InvalidInputCustomException;

/**
 * 
 */

/**
 * @author vivekrawat
 *
 */
public class RoverPath {

	int xPosTemp;
	int yPosTemp;
	String directionTemp;

	int xPosCurrent;
	int yPosCurrent;
	String directionCurrent;

	public RoverPath(String currentPos) {
		// TODO Auto-generated constructor stub

		xPosCurrent = Integer.parseInt((currentPos).split(" ")[0]);
		yPosCurrent = Integer.parseInt((currentPos).split(" ")[1]);
		directionCurrent = (currentPos).split(" ")[2];

		xPosTemp = xPosCurrent;
		yPosTemp = yPosCurrent;
		directionTemp = directionCurrent;

	}

	// MMRMMRMRRM
	// iteration0: 3 3 E
	// iteration1: 4 3 E
	// iteration2: 5 3 E
	// iteration3: 5 3 S
	// iteration4: 5 2 S
	// iteration5: 5 1 S
	// iteration6: 5 1 W

	public boolean checkStartPosition(int xPosCurrent, int yPosCurrent, int xPosMax, int yPosMax) {

		if (xPosCurrent >= 0 && xPosCurrent <= xPosMax && yPosCurrent >= 0 && yPosCurrent <= yPosMax)
			return true;
		else
			return false;

	}

	public boolean checkStartDirection(String directionCurrent) {

		if (directionCurrent.equals("N") || directionCurrent.equals("S") || directionCurrent.equals("E")
				|| directionCurrent.equals("W"))
			return true;
		else
			return false;

	}

	public String steerRover(String ins, String maxGrid, int roverNumber) throws InvalidInputCustomException {

		String finalPos = null;

		char[] moveInstructions = ins.toCharArray();
		int maxX = Integer.parseInt(maxGrid.split(" ")[0]);
		int maxY = Integer.parseInt(maxGrid.split(" ")[1]);

		if (checkStartPosition(xPosCurrent, yPosCurrent, maxX, maxY)) {

			if (checkStartDirection(directionCurrent)) {

				for (int i = 0; i < moveInstructions.length; i++) {

					/*
					 * System.out.print(moveInstructions[i]); System.out.print(" Iteration"+i+": ");
					 * System.out.print(xPosTemp+" "); System.out.print(yPosTemp+" ");
					 * System.out.println(directionTemp); System.out.println("*******************");
					 */

					if (moveInstructions[i] == 'L') {
						turnLeft();
					} else if (moveInstructions[i] == 'R') {
						turnRight();
					} else if (moveInstructions[i] == 'M') {
						moveAhead();
						if (xPosTemp < 0 || xPosTemp > maxX || yPosTemp < 0 || yPosTemp > maxY) {

							throw new InvalidInputCustomException("Rover" + roverNumber + " fell out of grid while moving");
						}

					} else {

						throw new InvalidInputCustomException(
								"Incorrect Instruction: " + moveInstructions[i] + " for Rover" + roverNumber);
					}

					finalPos = xPosTemp + " " + yPosTemp + " " + directionTemp;
				}

				// System.out.println(finalPos);
				return finalPos;

			} else

				throw new InvalidInputCustomException("Rover" + roverNumber + " intial direction is invalid");

		} else

			throw new InvalidInputCustomException("Rover" + roverNumber + " intial position out of Grid");

	}

	public void turnLeft() {

		if (directionTemp.equals("N")) {
			directionTemp = "W";
		} else if (directionTemp.equals("W")) {
			directionTemp = "S";
		} else if (directionTemp.equals("S")) {
			directionTemp = "E";
		} else
			directionTemp = "N";

	}

	public void turnRight() {

		if (directionTemp.equals("N")) {
			directionTemp = "E";
		} else if (directionTemp.equals("E")) {
			directionTemp = "S";
		} else if (directionTemp.equals("S")) {
			directionTemp = "W";
		} else
			directionTemp = "N";

	}

	public void moveAhead() {

		if (directionTemp.equals("N")) {
			yPosTemp = yPosTemp + 1;
		} else if (directionTemp.equals("E")) {
			xPosTemp = xPosTemp + 1;
		} else if (directionTemp.equals("S")) {
			yPosTemp = yPosTemp - 1;
		} else
			xPosTemp = xPosTemp - 1;

	}

}
