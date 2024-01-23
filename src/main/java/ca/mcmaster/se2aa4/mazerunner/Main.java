package ca.mcmaster.se2aa4.mazerunner;

import java.io.FileNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws FileNotFoundException, Exception { // exception thrown here for config method
        Configuration config = configure(args);

        logger.info("** Starting Maze Runner");
        logger.info("**** Reading the maze from file " + config.inputFile);
        
        MazeData maze = new MazeData();
        char[][] maze1 = maze.storeMazeData(config.inputFile);
        maze.printMazeData(maze1);

        logger.info("**** Computing path");
        PathFinder path = new PathFinder();
        Integer[] startCond = path.pathStart(maze1);
        Integer[] endCond = path.pathEnd(maze1);
        Integer[] move = startCond;
        char direction = 'E';
        System.out.println();

        while (move[1] < endCond[1]) {
            if (path.checkFront(maze1, move, direction) == true) {
                // if (path.checkRight(maze1, move, direction) == false) {
                move = path.moveForward(move, path.nextStep(move, direction));
                // }
            }
        }
        System.out.println();
        System.out.println("Final position of pointer: row " + move[0] + ", column " + move[1]);
        
        logger.debug("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");

        /* 
        //test this
        String sequence = path.rightHandRule(maze1);
        System.out.println(sequence);
        */
    }

    private static Configuration configure(String[] cmdArgs) throws Exception, FileNotFoundException {
        Options options = new Options();
        options.addOption("i", "input", true, "Input filepath");
        options.addOption("p", "pathGuess", true, "Input path guess");
        
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, cmdArgs);
        String inputFilePath = cmd.getOptionValue("i");
        return new Configuration(inputFilePath);
    }

    private record Configuration(String inputFile) {
        Configuration {
            if (inputFile == null) {throw new IllegalArgumentException("Maze text file is empty!");} 
        }
    }
}
