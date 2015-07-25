package com.rea.code.challenge;

/**
 * Created by tuhu on 15/7/25.
 */

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class ParserTest {

    private Board board = new Board(5, 5);
    private Parser parser = new Parser(board);




    @Test
    public void invalidCommandTest() throws Exception {

        String result = parser.input("XXXXX");
        Assert.assertEquals(Constant.INVALID_COMMAND, result);

        result = parser.input("LEFT");
        Assert.assertEquals(Constant.PLACE_COMMAND_MUST_BE_FIRST, result);

        result = parser.input("RIGHT");
        Assert.assertEquals(Constant.PLACE_COMMAND_MUST_BE_FIRST, result);

        result = parser.input("MOVE");
        Assert.assertEquals(Constant.PLACE_COMMAND_MUST_BE_FIRST, result);

        result = parser.input("REPORT");
        Assert.assertEquals(Constant.PLACE_COMMAND_MUST_BE_FIRST, result);


        result = parser.input("PLACE 1 1 1 1");
        Assert.assertEquals(Constant.PLACE_COMMAND_INVALID, result);
    }


    @Test
    public void inputPlaceTest() throws Exception {

        String result = parser.input("PLACE 1,1,SOUTH");
        Assert.assertEquals(result, "");
    }


    @Test
    public void checkValidCommandTest() throws Exception {

        Position position = mock(Position.class);
        parser.setPosition(position);

        parser.input("REPORT");
        verify(position).report();

        parser.input("LEFT");
        verify(position).left();

        parser.input("RIGHT");
        verify(position).right();

        parser.input("MOVE");
        verify(position).nextStep();

    }
}
