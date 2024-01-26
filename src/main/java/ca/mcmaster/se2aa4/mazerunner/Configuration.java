package ca.mcmaster.se2aa4.mazerunner;

import java.io.FileNotFoundException;
import org.apache.commons.cli.*;

public class Configuration {
    private final String inputFile;
    private final String pathGuess;

    public Configuration(String inputFile, String pathGuess) {
        if (inputFile == null) {
            throw new IllegalArgumentException("Maze text file is empty!");
        }
        this.inputFile = inputFile;
        this.pathGuess = pathGuess;
    }

    public static Configuration configure(String[] cmdArgs) throws Exception, FileNotFoundException {
        Options options = new Options();
        options.addOption("i", "input", true, "Input filepath");
        options.addOption("p", "pathGuess", true, "Input path guess");
        
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, cmdArgs);
        String inputFilePath = cmd.getOptionValue("i");
        String inputPathGuess = cmd.getOptionValue("p");
        return new Configuration(inputFilePath, inputPathGuess);
    }

    public String getInputFile() {
        return inputFile;
    }

    public String getPathGuess() {
        return pathGuess;
    }
}
