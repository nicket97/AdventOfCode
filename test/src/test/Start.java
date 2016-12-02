package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Start {

    enum Direction {
        NORTH, SOUTH, EAST, WEST
    }

    int blocksAwayFromEasterBunnyHq(List<String> sequence) {
        int x = 0;
        int y = 0;

        Direction direction = Direction.NORTH;

        for (String step : sequence) {
            direction = getNewDirection(direction, step);
            int blocks = getStepBlocks(step);
            switch (direction) {
                case NORTH:
                    y += blocks;
                    break;
                case EAST:
                    x += blocks;
                    break;
                case WEST:
                    x -= blocks;
                    break;
                case SOUTH:
                    y -= blocks;
                    break;
            }
        }

        return Math.abs(x) + Math.abs(y);
    }

    private int getStepBlocks(String step) {
        return Integer.parseInt(step.substring(1));
    }

    private Direction getNewDirection(Direction from, String step) {
        final String LEFT = "L";

        String turn = String.valueOf(step.charAt(0));

        boolean isLeftTurn = LEFT.equals(turn);

        switch (from) {
            case EAST:
                return isLeftTurn ? Direction.NORTH : Direction.SOUTH;
            case NORTH:
                return isLeftTurn ? Direction.WEST : Direction.EAST;
            case SOUTH:
                return isLeftTurn ? Direction.EAST : Direction.WEST;
            case WEST:
                return isLeftTurn ? Direction.SOUTH : Direction.NORTH;
        }

        return null;
    }

    int firstRepeatedCoordinates(List<String> sequence) {
        Set<String> visitedCoordinates = new HashSet<>();

        int x = 0;
        int y = 0;

        visitedCoordinates.add(getKey(x, y));

        Direction direction = Direction.NORTH;

        for (String step : sequence) {
            direction = getNewDirection(direction, step);
            int blocks = getStepBlocks(step);
            for (int i = 0; i < blocks; i++) {
                switch (direction) {
                    case NORTH:
                        y++;
                        break;
                    case EAST:
                        x++;
                        break;
                    case WEST:
                        x--;
                        break;
                    case SOUTH:
                        y--;
                        break;
                }
                if (visitedCoordinates.contains(getKey(x, y))) {
                    return Math.abs(x) + Math.abs(y);
                }
                visitedCoordinates.add(getKey(x, y));
            }
        }

        return Math.abs(x) + Math.abs(y);
    }

    private String getKey(int x, int y) {
        return "x:" + x + ",y:" + y;
    }

    public static void main(String[] args) {
        // Too lazy, I know :D
        String input = "R1, L4, L5, L5, R2, R2, L1, L1, R2, L3, R4, R3, R2, L4, L2, R5, L1, R5, L5, L2, L3, L1, R1, R4, R5, L3, R2, L4, L5, R1, R2, L3, R3, L3, L1, L2, R5, R4, R5, L5, R1, L190, L3, L3, R3, R4, R47, L3, R5, R79, R5, R3, R1, L4, L3, L2, R194, L2, R1, L2, L2, R4, L5, L5, R1, R1, L1, L3, L2, R5, L3, L3, R4, R1, R5, L4, R3, R1, L1, L2, R4, R1, L2, R4, R4, L5, R3, L5, L3, R1, R1, L3, L1, L1, L3, L4, L1, L2, R1, L5, L3, R2, L5, L3, R5, R3, L4, L2, R2, R4, R4, L4, R5, L1, L3, R3, R4, R4, L5, R4, R2, L3, R4, R2, R1, R2, L4, L2, R2, L5, L5, L3, R5, L5, L1, R4, L1, R1, L1, R4, L5, L3, R4, R1, L3, R4, R1, L3, L1, R1, R2, L4, L2, R1, L5, L4, L5".replace(" ", "");
        Scanner scanner = new Scanner(input).useDelimiter(",");
        List<String> sequence = new ArrayList<>();

        while (scanner.hasNext()) {
            sequence.add(scanner.next());
        }

        System.out.println(new Start().blocksAwayFromEasterBunnyHq(sequence));
        System.out.println(new Start().firstRepeatedCoordinates(sequence));
    }

}