package ca.mcmaster.se2aa4.mazerunner;

public class PathFinder {
    private MazeData maze;

    public PathFinder(MazeData maze) {
        this.maze = maze;
    }

    // given maze data, return start condition
    public Integer[] pathStart(MazeData maze) {
        this.maze = maze;
        Integer[] startCoord = {0, 0};
        for (int row = 0; row < maze.getSumRow()-1; row++) {
            if ((maze.getSumCol() > 0) && ((maze.getStartCol(row)) != '#')) {
                startCoord[0] = row;
                break;
            }
        }
        return startCoord;
    } 

    // given maze data, return end condition
    public Integer[] pathEnd(MazeData maze) {
        Integer[] endCoord = {0, maze.sumRow - 1};
        for (int row = 0; row < maze.getSumRow() - 1; row++) {
            if (maze.getSumCol() > 0 && (maze.getEndCol(row)-1) != '#') {
                endCoord[0] = row;
                break;
            }
        }
        return endCoord;
    }

    public Integer[] moveForward(Integer[] currentStep, Integer[] nextStep) {
        currentStep = nextStep;
        return currentStep;
    }

    public char turnRight(char oldDirection) {
        char newDirection = 'E';
        if (oldDirection == 'E') {
            newDirection = 'S';
        } else if (oldDirection == 'S') {
            newDirection = 'W';
        } else if (oldDirection == 'W') {
            newDirection = 'N';
        } else if (oldDirection == 'N') {
            newDirection = 'E';
        }
        return newDirection;
    }

    public char turnLeft(char oldDirection) {
        char newDirection = 'E';
        if (oldDirection == 'E') {
            newDirection = 'N';
        } else if (oldDirection == 'S') {
            newDirection = 'E';
        } else if (oldDirection == 'W') {
            newDirection = 'S';
        } else if (oldDirection == 'N') {
            newDirection = 'W';
        }
        return newDirection;
    }

    public Integer[] nextStep(Integer[] currentStep, char direction) {
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

    public boolean checkFront(MazeData maze, Integer[] currentSteps, char direction) { // THIS WORKS FINE! :^D
        Integer row = currentSteps[0];
        Integer col = currentSteps[1];
        if (direction == 'E') {
            col++;
        } else if (direction == 'S') {
            row++;
        } else if (direction == 'W') {
            col--;
        } else {
            row--;
        }
        if (maze.getMazeElement(row, col) != '#') {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkRight(MazeData maze, Integer[] currentSteps, char direction) {
        char directChange = turnRight(direction); // now 'S'
        boolean pass = checkFront(this.maze, currentSteps, directChange);
        directChange = turnLeft(directChange);
        return pass;
    }
}