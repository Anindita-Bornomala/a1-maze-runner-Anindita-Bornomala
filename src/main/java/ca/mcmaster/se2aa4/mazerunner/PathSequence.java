package ca.mcmaster.se2aa4.mazerunner;

public class PathSequence {
    public PathSequence(MazeData maze) {
    }

    public void rightHandRule(MazeData maze) { // RightHandRule: use to get a canonical path string
        PathFinder pathFind = new PathFinder(maze);

        Integer[] startCond = pathFind.pathStart(maze); // GET START COORDINATES
        Integer[] endCond = pathFind.pathEnd(maze); // GET END COORDINATES
        Integer[] pointer = startCond; // THIS IS THE PLAYER
        char direction = 'E'; // INTIIAL DIRECTION
        String canonical = "";
        Integer[] nextPosition;
        
        while (pointer[1] < endCond[1]) {
            if (pathFind.checkRight(maze, pointer, direction) == false) { // CHECK IF WALL TO RIGHT
                if (pathFind.checkFront(maze, pointer, direction) == true) { // CHECK IF WALL IN FRONT
                    nextPosition = pathFind.nextStep(pointer, direction);
                    pointer = pathFind.moveForward(pointer, nextPosition); // MOVE FORWARD
                    canonical = canonical + "F";
                } else {
                    direction = pathFind.turnLeft(direction); // TURN LEFT
                    canonical = canonical + "L";
                }
            } else {
                direction = pathFind.turnRight(direction); // TURN RIGHT
                canonical = canonical + "R";
                nextPosition = pathFind.nextStep(pointer, direction);
                pointer = pathFind.moveForward(pointer, nextPosition); // MOVE FORWARD
                canonical = canonical + "F";
            }
        }
        factorize(canonical);
    }

    public void factorize(String canonical) {
        String result = "";
        int count = 1;

        for (int i = 1; i <= canonical.length(); i++) {
            if(i == canonical.length() || canonical.charAt(i) != canonical.charAt(i-1)) {
                result = result + count + canonical.charAt(i-1) + " ";
                count = 1;
            } else {
                count++;
            }
        }
        System.out.println("Generated Path: " + result);
    }
}