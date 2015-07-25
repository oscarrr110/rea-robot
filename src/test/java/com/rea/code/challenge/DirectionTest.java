package com.rea.code.challenge;

import org.junit.Assert;
import org.junit.Test;
/**
 * Created by tuhu on 15/7/25.
 */
public class DirectionTest {

    @Test
    public void getNextTest() {
        Direction eastDirection = Direction.EAST;

        Assert.assertEquals(Direction.SOUTH, eastDirection.getNext());
        Assert.assertEquals(Direction.WEST, eastDirection.getNext().getNext());
        Assert.assertEquals(Direction.NORTH, eastDirection.getNext().getNext().getNext());
        Assert.assertEquals(Direction.EAST, eastDirection.getNext().getNext().getNext().getNext());

        Direction southDirection = Direction.SOUTH;

        Assert.assertEquals(Direction.WEST, southDirection.getNext());
        Assert.assertEquals(Direction.NORTH, southDirection.getNext().getNext());
        Assert.assertEquals(Direction.EAST, southDirection.getNext().getNext().getNext());
        Assert.assertEquals(Direction.SOUTH, southDirection.getNext().getNext().getNext().getNext());

        Direction westDirection = Direction.WEST;
        Assert.assertEquals(Direction.NORTH, westDirection.getNext());
        Assert.assertEquals(Direction.EAST, westDirection.getNext().getNext());
        Assert.assertEquals(Direction.SOUTH, westDirection.getNext().getNext().getNext());
        Assert.assertEquals(Direction.WEST, westDirection.getNext().getNext().getNext().getNext());


        Direction northDirection = Direction.NORTH;
        Assert.assertEquals(Direction.EAST, northDirection.getNext());
        Assert.assertEquals(Direction.SOUTH, northDirection.getNext().getNext());
        Assert.assertEquals(Direction.WEST, northDirection.getNext().getNext().getNext());
        Assert.assertEquals(Direction.NORTH, northDirection.getNext().getNext().getNext().getNext());

    }

    @Test
    public void getPrevTest() {

        Direction eastDirection = Direction.EAST;

        Assert.assertEquals(Direction.NORTH, eastDirection.getPrev());
        Assert.assertEquals(Direction.WEST, eastDirection.getPrev().getPrev());
        Assert.assertEquals(Direction.SOUTH, eastDirection.getPrev().getPrev().getPrev());
        Assert.assertEquals(Direction.EAST, eastDirection.getPrev().getPrev().getPrev().getPrev());


        Direction southDirection = Direction.SOUTH;

        Assert.assertEquals(Direction.EAST, southDirection.getPrev());
        Assert.assertEquals(Direction.NORTH, southDirection.getPrev().getPrev());
        Assert.assertEquals(Direction.WEST, southDirection.getPrev().getPrev().getPrev());
        Assert.assertEquals(Direction.SOUTH, southDirection.getPrev().getPrev().getPrev().getPrev());


        Direction westDirection = Direction.WEST;

        Assert.assertEquals(Direction.SOUTH, westDirection.getPrev());
        Assert.assertEquals(Direction.EAST, westDirection.getPrev().getPrev());
        Assert.assertEquals(Direction.NORTH, westDirection.getPrev().getPrev().getPrev());
        Assert.assertEquals(Direction.WEST, westDirection.getPrev().getPrev().getPrev().getPrev());


        Direction northDirection = Direction.NORTH;
        Assert.assertEquals(Direction.WEST, northDirection.getPrev());
        Assert.assertEquals(Direction.SOUTH, northDirection.getPrev().getPrev());
        Assert.assertEquals(Direction.EAST, northDirection.getPrev().getPrev().getPrev());
        Assert.assertEquals(Direction.NORTH, northDirection.getPrev().getPrev().getPrev().getPrev());
    }
}
