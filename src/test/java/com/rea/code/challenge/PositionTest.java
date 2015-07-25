package com.rea.code.challenge;

import org.junit.Test;
import org.junit.Assert;
/**
 * Created by tuhu on 15/7/25.
 */
public class PositionTest {


    @Test
    public void leftAndRightTest() {

        Board board = new Board(5, 5);
        Position p = new Position(0,0, Direction.NORTH, board);

        Assert.assertEquals("0,0,NORTH", p.report());
        p.left();
        Assert.assertEquals("0,0,WEST", p.report());
        p.left();
        Assert.assertEquals("0,0,SOUTH", p.report());
        p.left();
        Assert.assertEquals("0,0,EAST", p.report());
        p.left();

        Assert.assertEquals("0,0,NORTH", p.report());
        p.right();
        Assert.assertEquals("0,0,EAST", p.report());
        p.right();
        Assert.assertEquals("0,0,SOUTH", p.report());
        p.right();
        Assert.assertEquals("0,0,WEST", p.report());
        p.right();
        Assert.assertEquals("0,0,NORTH", p.report());
    }

    @Test
    public void nextStepTest() {

        Board board = new Board(5, 5);
        Position p = new Position(0,0, Direction.NORTH, board);

        //move on north
        p.nextStep();
        Assert.assertEquals("0,1,NORTH", p.report());

        p.right();
        Assert.assertEquals("0,1,EAST", p.report());

        //move on east
        p.nextStep();
        Assert.assertEquals("1,1,EAST", p.report());

        p.left();
        Assert.assertEquals("1,1,NORTH", p.report());

        //move on north
        p.nextStep();
        Assert.assertEquals("1,2,NORTH", p.report());


        p.left();
        Assert.assertEquals("1,2,WEST", p.report());

        //move on west
        p.nextStep();
        Assert.assertEquals("0,2,WEST", p.report());

        p.left();
        Assert.assertEquals("0,2,SOUTH", p.report());

        //move on south
        p.nextStep();
        Assert.assertEquals("0,1,SOUTH", p.report());
    }


    @Test
    public void nextStepOnBoarderTest() {

        Board board = new Board(5, 5);
        Position p = new Position(0,0, Direction.WEST, board);

        //move on west, but still unchanged
        p.nextStep();
        Assert.assertEquals("0,0,WEST", p.report());

        p.left();
        Assert.assertEquals(p.report(), "0,0,SOUTH");

        //move on south, but still unchanged
        p.nextStep();
        Assert.assertEquals(p.report(), "0,0,SOUTH");

        p.right();
        Assert.assertEquals(p.report(), "0,0,WEST");

        //move on west, but still unchanged
        p.nextStep();
        Assert.assertEquals(p.report(), "0,0,WEST");

        p.right();
        p.nextStep();
        Assert.assertEquals(p.report(), "0,1,NORTH");

        p.left();
        Assert.assertEquals(p.report(), "0,1,WEST");

        //move on west, but still unchanged
        p.nextStep();
        Assert.assertEquals(p.report(), "0,1,WEST");
    }
}
