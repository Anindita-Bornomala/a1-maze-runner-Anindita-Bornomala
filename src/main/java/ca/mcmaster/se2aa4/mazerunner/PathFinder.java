package ca.mcmaster.se2aa4.mazerunner;

public class PathFinder {

    public Integer pathStart(char[][] mazeData) {
        Integer rowNum = 0;
        for (int row = 0; row < mazeData.length; row++) {
            if (mazeData[row].length > 0 && mazeData[row][0] == ' ') {
                rowNum = row;
                break;
            }
        }
        // given maze data, return start condition
        return rowNum;
    }

    public Integer pathEnd(char[][] mazeData) {
        Integer rowNum = 0;
        for (int row = 0; row < mazeData.length; row++) {
            if (mazeData[row].length > 0 && mazeData[row][-1] == ' ') {
                rowNum = row;
                break;
            }
        }
        // given maze data, return end condition
        return rowNum;
    }

    public Integer[] moveForward(Integer[] currentStep, Integer[] nextStep) {
        currentStep = nextStep;
        System.out.println("Current position:", currentStep);
        return currentStep;
    }

    public Integer[] nextStep(Integer[] currentStep) {
        char direction = 'E';
        Integer[] nextPosition = currentStep;
        if (direction == 'E') {
            nextPosition[1]++;  
        } else if (direction == 'S') {
            nextPosition[0]++;
        } else if (direction == 'W') {
            nextPosition[1]--;
        } else {
            nextPosition[0]--;
        }
        return nextPosition;
    }

    public char direction() {
        if 
        return ' ';
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


    
}
