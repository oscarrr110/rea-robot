package com.rea.code.challenge;

/**
 * Created by tuhu on 15/7/24.
 */
public enum Direction {

    NORTH(0), EAST(1), SOUTH(2),WEST(3);

    private int direction;

    private Direction(int direction) {
        this.direction = direction;
    }


    /**
     * clockwise way to getNext, if last, return the first element
     *
     * @return Next direction
     */
    public Direction getNext() {

        Direction[] values = Direction.values();
        int index = 0;
        if(this.ordinal() < values.length -1 ) {
            index = this.ordinal() + 1;
        }
        return values[index];
    }

    /**
     * anticlockwise way to getPrev, if last, return the last element
     *
     * @return Previous direction
     */
    public Direction getPrev() {

        Direction[] values = Direction.values();
        int index = values.length -1;

        if(this.ordinal() != 0) {
            index = this.ordinal() - 1;
        }

        return values[index];
    }
}
