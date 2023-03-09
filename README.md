# MarsRover - Technical Challenge

A squad of robotic rovers are to be landed by NASA on a plateau on Mars.

This plateau, which is curiously rectangular, must be navigated by the rovers so that their onboard cameras can get a complete view of the surrounding terrain to send back to Earth.

A rover's position is represented by a combination of an x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.

To control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right, respectively, without moving from its current spot.

'M' means move forward one grid point and maintain the same heading.

Assume that the square directly North from (x, y) is (x, y+1).

## Sample Input:
The first line of input is the upper-right coordinates of the plateau. The lower-left coordinates are assumed to be 0,0.

The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover's position, and the second line is a series of instructions telling the rover how to explore the plateau.

The position is made up of two integers and a letter separated by spaces, corresponding to the x and y coordinates and the rover's orientation.

Each rover will be finished sequentially, which means that the second rover won't start to move until the first one has finished moving.

5 5 <br />
1 2 N <br />
LMLMLMLMM <br />
3 3 E <br />
MMRMMRMRRM <br />

## Sample Expected Output:

1 3 N <br />
5 1 E <br />

## SOLUTION
The application MarsRover is developed in Java.

### System Requirements:-

- Operating System : Any(Windows/Linux/Mac)
- Java : JDK1.7
- IDE used: Eclipse

### How to run the application?
This application can be easily run with any IDE like Eclipse via main class (**MarsRover/Rover/src/main/MarsRover.java**) or using command prompt/terminal by launching the executable jar file (**MarsRover/MarsRover Executable JAR/MarsRover.jar**) available in the repo. 

### How to give an input?

1. **Method1:** Run as Java application in IDE (Eclipse etc) - Input to be provided in console
2. **Method2:** Application launched via command prompt/terminal using executable jar using command **"java -jar MarsRover.jar"** - Input to be provided on terminal. 

### Unit Test cases:
Unit test cases are available under MarsRover/Rover/src/test/RoverPathTest

### Assumptions: 

1. Input format will be same as mentioned in the sample input given above.
2. At any point while moving if rover position reaches out of the grid, program will terminate stating the details.
3. Direction mentioned in the initial position can only be 'N', 'S', 'E' and 'W'. Any other value if given will terminate the execution.
4. Instruction can only be 'L', 'R' and 'M'. Any other value if given will result in program termination with proper message.
5. Initial position co-ordinates of rover cannot be negative.
6. Rover2 will only start moving after Rover1 is finished with its set of commands.

