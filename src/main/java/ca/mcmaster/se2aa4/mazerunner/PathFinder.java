package ca.mcmaster.se2aa4.mazerunner;

public class PathFinder {

    public String pathStart(String[][] mazeData) {
        // given maze data, return start condition
        return "False";
    }

    public String pathEnd(String[][] mazeData) {
        // given maze data, return end condition
        return "False";
    }

    public String currentStep() { return "False"; }

    public String nextStep() { return "False"; }

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


    
}