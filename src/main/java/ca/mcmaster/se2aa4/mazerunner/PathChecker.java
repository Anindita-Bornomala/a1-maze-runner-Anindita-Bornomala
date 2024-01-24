package ca.mcmaster.se2aa4.mazerunner;

public class PathChecker {

    public String pathCheck(char[][] mazeData, String pathGuess) {
        PathFinder pathFind = new PathFinder();

        if (pathGuess.charAt(0) != 'F' || pathGuess.charAt(0) != 'R' || pathGuess.charAt(0) != 'L') {
            pathGuess = factToCanon(pathGuess);
        }
        
        Integer[] startCond = pathFind.pathStart(mazeData);
        Integer[] endCond = pathFind.pathEnd(mazeData);
        Integer[] pointer = startCond; // THIS IS THE PLAYER
        char direction = 'E';
        Integer[] nextPosition;

        for (char element : pathGuess.toCharArray()) {
            if (element == 'F') {
                nextPosition = pathFind.nextStep(pointer, direction);
                pointer = pathFind.moveForward(pointer, nextPosition);
            } else if (element == 'R') {
                direction = pathFind.turnRight(direction); // TURN RIGHT
            } else if (element == 'L') {
                direction = pathFind.turnLeft(direction); // TURN LEFT
            }
        }
        if (pointer[1] == endCond[1]) {
            return "Correct path!";
        } else {
            return "Incorrect path!";
        }
    }

    public String factToCanon(String pathGuessFact) {
        String[] pathSplit = pathGuessFact.split(" ");
        String result = "";
        int count = 1;

        for (String element : pathSplit) {
            count = (int) (element.charAt(0) - '0');
            for (int i = 0; i < count; i++) {
                if (element.charAt(1) == 'F') {
                    result = result + "F";
                } else if (element.charAt(1) == 'R') {
                    result = result + "R";
                } else {
                    result = result + "L";
                }
            }
        }
        System.out.println(result);
        return result;
    }
}
