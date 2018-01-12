package com.jjhellberg;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.text.Bidi;
import java.util.HashMap;
import java.util.Map;



public class Logic {

    public BidiMap<Integer, Coord> getMatrix(int max) {
        BidiMap<Integer, Coord> matrix = new DualHashBidiMap<>();
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

}
