package com.rea.code.challenge;

import javafx.geometry.Pos;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by tuhu on 15/7/25.
 */
public class BoardTest {


    @Test
    public void isValidPositionTest() {

        Direction direction = Direction.NORTH;
        Board board = new Board(5,5);
        Position validPosition = new Position(0, 0, direction, board);
        Assert.assertTrue(board.isValidPosition(validPosition));

        Position outsidePosition = new Position(10, 10, direction, board);
        Assert.assertFalse(board.isValidPosition(outsidePosition));

        Position invalidPosition = new Position(-1, -1, direction, board);
        Assert.assertFalse(board.isValidPosition(invalidPosition));
    }
}
