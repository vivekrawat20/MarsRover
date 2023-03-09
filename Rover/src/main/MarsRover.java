package main;
import java.util.Scanner;

import handleException.InvalidInputCustomException;

/**
 * 
 */

/**
 * @author vivekrawat
 *
 */
public class MarsRover {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		process(scanner);

	}

	public static void process(Scanner input) {

		// System.out.println("Enter dimensions of the grid (in the form x y):");
		String dimensions = input.nextLine();
		int roverCount = 2;

		String[] roverStartPos = new String[roverCount];
		String[] roverSteerInstructions = new String[roverCount];

		for (int count = 0; count < roverCount; count++) {

			roverStartPos[count] = input.nextLine();
			roverSteerInstructions[count] = input.nextLine();

		}
		
		System.out.println("\nOutput");

		for (int countRover = 0; countRover < roverCount; countRover++) {

			try {

				RoverPath rover = new RoverPath(roverStartPos[countRover]);
				String finalPosition = rover.steerRover(roverSteerInstructions[countRover], dimensions, countRover + 1);

				System.out.println(finalPosition);

			} catch (InvalidInputCustomException e) {

				System.out.println(e.getMessage());
				continue;

			}

		}

		input.close();

	}

}
