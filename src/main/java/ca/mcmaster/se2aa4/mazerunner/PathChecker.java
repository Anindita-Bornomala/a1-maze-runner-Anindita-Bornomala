package ca.mcmaster.se2aa4.mazerunner;

public class PathChecker {
    public PathChecker(MazeData maze) {}
    
    public String pathCheck(MazeData maze, String pathGuess) {
        PathFinder pathFind = new PathFinder(maze);

        if (pathGuess.charAt(0) == 'F' || pathGuess.charAt(0) == 'R' || pathGuess.charAt(0) == 'L') {
            pathGuess = pathGuess.replaceAll(" ", "");
        } else {
            pathGuess = factToCanon(pathGuess);
        }

        Integer[] startCond = pathFind.pathStart(maze);
        Integer[] endCond = pathFind.pathEnd(maze);
        Integer[] pointer = startCond; // player
        char direction = 'E';
        Integer[] nextPosition;

        for (char element : pathGuess.toCharArray()) {
            if (element == 'F') {
                nextPosition = pathFind.nextStep(pointer, direction);
                pointer = pathFind.moveForward(pointer, nextPosition);
            } else if (element == 'R') {
                direction = pathFind.turnRight(direction);
            } else if (element == 'L') {
                direction = pathFind.turnLeft(direction);
            } else {
                continue;
            }
        }
        if (pointer[1] == endCond[1]) {
            return "Correct path!";
        } else {
            return "Incorrect path!";
        }
    }

    public String factToCanon(String factPathGuess) { // convert from factorized form to compact canonical
        String[] pathSplit = factPathGuess.split("(?<=\\D)(?=\\d)");
        String result = "";
        int count = 0;

        for (String element : pathSplit) {
            count = element.charAt(0) - '0';
            for (int i = 0; i < count; i++) {
                result = result + element.charAt(1);
            }
        }
        return result;
    }
}