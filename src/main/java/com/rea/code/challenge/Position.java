package com.rea.code.challenge;

/**
 *
 * basic info for the Position, including coordinate and direction, and also provide some operation
 *
 *
 * Created by tuhu on 15/7/24.
 */
public class Position {

    //x-coordinate
    private int x;

    //y-coordinate
    private int y;

    //Direction Enum
    private Direction direction;

    //the surface of the table
    private Board board;


    public Position (int x, int y, Direction d, Board b) {
        place(x, y ,d, b);
    }


    private void place(int x, int y, Direction d, Board b) {
        this.x = x;
        this.y = y;
        this.direction = d;
        this.board = b;
    }

    /**
     * turn anticlockwise
     */
    public void left() {
        direction = direction.getPrev();
    }

    /**
     * turn clockwise
     */
    public void right() {
        direction = direction.getNext();
    }


    /**
     * change its coordinates, if out of border, rollback to the board
     *
     * @param x
     * @param y
     */
    private void move(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;

        //rollback to original one
        if(!this.board.isValidPosition(this)) {
            this.x = this.x - x;
            this.y = this.y - y;
        }
    }

    /**
     * return the basic position info
     *
     * @return
     */
    public String report() {
        return this.toString();
    }


    /**
     *
     * According to the different direction, change to the corresponding coordinates
     *
     */
    public void nextStep() {

        switch(direction) {

            case NORTH:
                move(0, 1);
                break;
            case SOUTH:
                move(0, -1);
                break;
            case WEST:
                move(-1, 0);
                break;
            case EAST:
                move(1, 0);
                break;
        }
    }

    @Override
    public String toString() {
        return (x + "," + y + "," + direction).toUpperCase();
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
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
}
