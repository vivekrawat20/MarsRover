package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import handleException.InvalidInputCustomException;
import main.RoverPath;

class RoverPathTest {

	@Test
	void testSteerRoverPositiveCase() {
		// fail("Not yet implemented");
		try {

			RoverPath roverPath1 = new RoverPath("1 2 N");
			String steerRoverResult1 = roverPath1.steerRover("LMLMLMLMM", "5 5", 1);
			Assertions.assertEquals("1 3 N", steerRoverResult1);

		} catch (InvalidInputCustomException ex) {

			assertEquals("Incorrect Instruction: K for Rover1", ex.getMessage());
		}

	}
	
	@Test
	void testSteerRoverNegativeCaseDirection() {
		// fail("Not yet implemented");
		try {

			RoverPath roverPath1 = new RoverPath("1 2 Q");
			String steerRoverResult1 = roverPath1.steerRover("LMLMLMRMM", "5 5", 1);
			Assertions.assertEquals("1 3 N", steerRoverResult1);

		} catch (InvalidInputCustomException ex) {

			assertEquals("Rover1 intial direction is invalid", ex.getMessage());
		}

	}
	
	@Test
	void testSteerRoverNegativeCaseLocation() {
		// fail("Not yet implemented");
		try {

			RoverPath roverPath1 = new RoverPath("-1 2 N");
			String steerRoverResult1 = roverPath1.steerRover("LMLMLML", "5 5", 1);
			Assertions.assertEquals("1 3 N", steerRoverResult1);

		} catch (InvalidInputCustomException ex) {

			assertEquals("Rover1 intial position out of Grid", ex.getMessage());
		}

	}
	
	@Test
	void testSteerRoverNegativeCaseMovingLocation() {
		// fail("Not yet implemented");
		try {

			RoverPath roverPath1 = new RoverPath("5 5 N");
			String steerRoverResult1 = roverPath1.steerRover("MLMLMRMM", "5 5", 1);
			Assertions.assertEquals("1 3 N", steerRoverResult1);

		} catch (InvalidInputCustomException ex) {

			assertEquals("Rover1 fell out of grid while moving", ex.getMessage());
		}

	}
	
	@Test
	void testSteerRoverNegativeCaseIncorrectInstruction() {
		// fail("Not yet implemented");
		try {

			RoverPath roverPath1 = new RoverPath("1 2 N");
			String steerRoverResult1 = roverPath1.steerRover("MLMLMKMM", "5 5", 2);
			Assertions.assertEquals("1 3 N", steerRoverResult1);

		} catch (InvalidInputCustomException ex) {

			assertEquals("Incorrect Instruction: K for Rover2", ex.getMessage());
		}

	}

}
