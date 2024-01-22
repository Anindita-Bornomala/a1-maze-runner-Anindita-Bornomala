package ca.mcmaster.se2aa4.mazerunner;

public class PathFinder {

    // given maze data, return start condition
    public Integer[] pathStart(char[][] mazeData) {
        Integer[] startCoord = {0, 0};
        for (int row = 0; row < mazeData.length-1; row++) {
            if (mazeData[row].length > 0 && mazeData[row][0] != '#') {
                startCoord[0] = row;
                break;
            }
        }
        System.out.println("Start condition: row " + startCoord[0] + ", column " + startCoord[1]);
        return startCoord;
    }

    // given maze data, return end condition
    public Integer[] pathEnd(char[][] mazeData) {
        Integer[] endCoord = {0, mazeData.length-1};
        for (int row = 0; row < mazeData.length-1; row++) {
            if (mazeData[row].length > 0 && mazeData[row][mazeData.length-1] != '#') {
                endCoord[0] = row;
                break;
            }
        }
        System.out.println("End condition: row " + endCoord[0] + ", column " + endCoord[1]);
        return endCoord;
    }

    public Integer[] moveForward(Integer[] currentStep, Integer[] nextStep) {
        currentStep = nextStep;
        System.out.println("Current position: row " + currentStep[0] + ", column " + currentStep[1]);
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
        System.out.println("Moving to: row " + nextPosition[0] + ", column " + nextPosition[1] + ", direction: " + direction);
        return nextPosition;
    }

    public boolean checkFront(char[][] mazeData, Integer[] currentSteps, char direction) { // THIS WORKS FINE! :^D
        Integer[] nextCoords = nextStep(currentSteps, direction);
        Integer row = nextCoords[0];
        Integer col = nextCoords[1];
        if (mazeData[row][col] != '#') {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkRight(char[][] mazeData, Integer[] currentSteps, char direction) {
        System.out.println("this is coming from checkRight function");

        direction = turnRight(direction); // now 'S'
        Integer[] nextCoords = nextStep(currentSteps, direction);
        Integer row = nextCoords[0];
        Integer col = nextCoords[1];
        if (mazeData[row][col] != '#') {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }

    //pathfinding algorithm
    // DOESNT WORK, FIX THIS
    public String rightHandRule(char[][] mazeData) {
        Integer[] startCond = pathStart(mazeData);
        Integer[] endCond = pathEnd(mazeData);
        Integer[] pointer = startCond;
        String sequence = "";
        System.out.println();

        char direction = 'E';
        Integer[] nextPosition = nextStep(pointer, direction);
        
        while (pointer[1] < endCond[1]) {
            if (checkRight(mazeData, pointer, direction) == false) {
                if (checkFront(mazeData, pointer, direction) == true) {
                    pointer = moveForward(pointer, nextPosition);
                    sequence.concat("F");
                } else {
                    nextPosition = nextStep(pointer, turnRight(direction));
                    sequence.concat("R");
                }
            } else {
                nextPosition = nextStep(pointer, turnRight(direction));
                sequence.concat("R");
                pointer = moveForward(pointer, nextPosition);
                sequence.concat("F");
            }
        }
        System.out.println("Final position: row " + pointer[0] + ", column " + pointer[1]);
        return sequence;
    }


    
}
