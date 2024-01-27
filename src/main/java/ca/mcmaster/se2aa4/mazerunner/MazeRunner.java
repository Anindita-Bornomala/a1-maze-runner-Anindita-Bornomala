package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeRunner {
    private static final Logger logger = LogManager.getLogger();

    public MazeRunner(String[] args) {
        try {
            Configuration config = Configuration.configure(args);

            logger.info("** Starting Maze Runner");
            logger.info("**** Reading the maze from file " + config.getInputFile());
            logger.info("**** Reading the string: " + config.getPathGuess());
            
            //CALLS ON MAZEDATA CLASS TO STORE AND PRINT DATA
            MazeData maze1 = new MazeData(config.getInputFile());
            maze1.printMazeData();

            System.out.print(System.lineSeparator());
            logger.info("**** Computing path");

            // TESTING THE RIGHT HAND RULE ALGORITH, YEAHHHHH
            PathSequence getSeq = new PathSequence(maze1);
            getSeq.rightHandRule(maze1);

            //CHECKING THE USER'S PATH GUESS
            PathChecker check = new PathChecker(maze1);
            if (config.getPathGuess() != null) {
                System.out.println(check.pathCheck(maze1, config.getPathGuess()));
            }
        } catch (Exception e) {
            logger.error("Error");
        }

        logger.debug("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}