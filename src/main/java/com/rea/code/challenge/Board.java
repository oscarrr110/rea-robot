package com.rea.code.challenge;

/**
 *
 * dimensions  xxx rows  * xxx columns .
 *
 * Created by tuhu on 15/7/25.
 */
public class Board {

    int rows;
    int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }


    /**
     * invalid position check
     *
     * @param position
     * @return
     */
    public boolean isValidPosition(Position position) {

        boolean inValid = (position.getX() < 0) || (position.getY() < 0);
        if(!inValid) {
            inValid = (position.getX() > this.columns) || (position.getY() > this.rows);
        }
        return !inValid;
    }
}
