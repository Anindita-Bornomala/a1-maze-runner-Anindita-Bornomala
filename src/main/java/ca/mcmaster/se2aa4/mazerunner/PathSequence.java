package ca.mcmaster.se2aa4.mazerunner;

public class PathSequence {
     
    private MazeData maze;
    
    public PathSequence(MazeData maze) {
        this.maze = maze;
    }
    

    public void rightHandRule(MazeData maze) { // RightHandRule: use to get a canonical path string
        PathFinder pathFind = new PathFinder(maze);

        Integer[] startCond = pathFind.pathStart(maze); // GET START COORDINATES
        System.out.println("Start position: row " + (startCond[0] + 1) + ", column " + (startCond[1] + 1));
        Integer[] endCond = pathFind.pathEnd(maze); // GET END COORDINATES
        System.out.println("End position: row " + (endCond[0] + 1) + ", column " + (endCond[1] + 1));
        Integer[] pointer = startCond; // THIS IS THE PLAYER
        char direction = 'E'; // INTIIAL DIRECTION
        String canonical = "";
        Integer[] nextPosition;
        System.out.println();
        
        System.out.print("Steps taken:");
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
            pathFind.checkCurrentStep(pointer);
        }
        System.out.print(System.lineSeparator());
        System.out.println("Canonical form: " + canonical);
        System.out.println("Factorized form: " + factorize(canonical));
    }

    public String factorize(String canonical) {
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
        return result;
    }
}