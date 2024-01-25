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
        logger.info("**** Reading the string: " + config.pathGuess);
        
        //CALLS ON MAZEDATA CLASS TO STORE AND PRINT DATA
        MazeData maze = new MazeData();
        char[][] maze1 = maze.storeMazeData(config.inputFile); // GOTTA HIDE TYPE
        maze.printMazeData(maze1);

        System.out.print(System.lineSeparator());
        logger.info("**** Computing path");

        // TESTING THE RIGHT HAND RULE ALGORITH, YEAHHHHH
        PathSequence getSeq = new PathSequence();
        getSeq.rightHandRule(maze1);

        //CHECKING THE USER'S PATH GUESS
        PathChecker check = new PathChecker();
        if (config.pathGuess != null) {
            System.out.println(check.pathCheck(maze1, config.pathGuess));
        }
        
        logger.debug("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }

    private static Configuration configure(String[] cmdArgs) throws Exception, FileNotFoundException {
        Options options = new Options();
        options.addOption("i", "input", true, "Input filepath");
        options.addOption("p", "pathGuess", true, "Input path guess");
        
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, cmdArgs);
        String inputFilePath = cmd.getOptionValue("i");
        String inputPathGuess = cmd.getOptionValue("p");
        return new Configuration(inputFilePath, inputPathGuess);
    }

    private record Configuration(String inputFile, String pathGuess) {
        Configuration {
            if (inputFile == null) {throw new IllegalArgumentException("Maze text file is empty!");} 
        }
    }
}
