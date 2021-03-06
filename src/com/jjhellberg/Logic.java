package com.jjhellberg;

import java.util.HashMap;
import java.util.Map;


public class Logic {

    private Map<Integer, Coord> getMatrix(int max) {
        Map<Integer, Coord> matrix = new HashMap<>();

        Integer squareNumber = 1;
        int x = 0;
        int y = 0;
        matrix.put(squareNumber, new Coord(x, y));
        squareNumber ++;

        int stepsBeforeTurn = 0;
        int stepsTaken = 0;
        boolean xAxis = false;
        boolean positive = false;

        while (squareNumber < max + 1) {
            if (stepsTaken == stepsBeforeTurn) {
                if (!xAxis) {
                    positive = !positive;
                    stepsBeforeTurn ++;
                }
                xAxis = !xAxis;
                stepsTaken = 0;
            }

            if (xAxis && positive) {
                x ++;
            }
            if (xAxis && !positive) {
                x --;
            }
            if (!xAxis && positive) {
                y ++;
            }
            if (!xAxis && !positive) {
                y --;
            }

            matrix.put(squareNumber, new Coord(x, y));

            stepsTaken ++;
            squareNumber ++;
        }

        return matrix;
    }

    public int distanceTo1(int square) {
        Coord coord = getMatrix(square).get(square);
        return Math.abs(coord.getX()) + Math.abs(coord.getY());
    }

    public int firstBigger(int maxValue) {
        Map<Coord, Integer> matrix = new HashMap<>();

        Integer squareNumber = 1;
        int x = 0;
        int y = 0;
        matrix.put(new Coord(x, y), squareNumber);

        int stepsBeforeTurn = 0;
        int stepsTaken = 0;
        boolean xAxis = false;
        boolean positive = false;

        while (squareNumber <= maxValue) {
            if (stepsTaken == stepsBeforeTurn) {
                if (!xAxis) {
                    positive = !positive;
                    stepsBeforeTurn ++;
                }
                xAxis = !xAxis;
                stepsTaken = 0;
            }

            if (xAxis && positive) {
                x ++;
            }
            if (xAxis && !positive) {
                x --;
            }
            if (!xAxis && positive) {
                y ++;
            }
            if (!xAxis && !positive) {
                y --;
            }

            Coord coord = new Coord(x, y);
            squareNumber = calculateSquareValue(coord, matrix);
            matrix.put(coord, squareNumber);
            stepsTaken ++;
        }
        return squareNumber;
    }


    private int calculateSquareValue(Coord coord, Map<Coord, Integer> matrix) {
        int value = 0;

        for(int i = coord.getY()-1; i < coord.getY()+2; i++ ) {
            for(int j = coord.getX()-1; j < coord.getX()+2; j++) {
                Coord tmpCoord = new Coord(j, i);
                if (matrix.containsKey(tmpCoord)) {
                    value += matrix.get(tmpCoord);
                }
            }
        }
        return value;
    }
}
