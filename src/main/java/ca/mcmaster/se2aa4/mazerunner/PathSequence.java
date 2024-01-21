package ca.mcmaster.se2aa4.mazerunner;

public class PathSequence {

    public static String FILEPATH = "i";
    public static String PATHCHECK = "p";

    public String[] getMaze() {
        // get the file .txt
        // convert into a matrix, so each word is an element (binary)
        // return String[][] mazeData
        return "Empty maze!";
    }
    
    //pathfinding algorithm
    public String rightHandRule() {
        // get the maze as a matrix
        // start at the "PASS" on column 1 (ex. r3, c1)
        // Search left: one row up, same column
        // Search right: one row down, same column
        // Go forward: same row, one column forward 
        // Mission: either go left, or go right, else go forward
        // Straight line: Search for pass in next column (ex. r3) 
        return "No path found!";
    }

    // Path guess checker
    public String pathCheck() {
        return "Incorrect path!";
    }

}
