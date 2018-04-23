package com.jjhellberg;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Coord {
    private int x;
    private int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Coord)) {
            return false;
        }

        Coord thatCoord = (Coord) obj;
        return this.x == thatCoord.getX() && this.y == thatCoord.getY();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17,37).append(this.x).append(this.y).toHashCode();
    }
}
