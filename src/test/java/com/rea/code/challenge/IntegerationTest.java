package com.rea.code.challenge;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tuhu on 15/7/25.
 */
public class IntegerationTest {

    private Board board = new Board(5, 5);

    private Parser parser;

    @Before
    public void before() {
        parser = new Parser(board);
    }

    @Test
    public void placeCommandTest() throws Exception {
        assertEquals("", parser.input("PLACE 0,0,NORTH"));
        assertEquals("0,0,NORTH", parser.input("REPORT"));
    }

    @Test
    public void moveCommandTest() throws Exception {

        parser.input("PLACE 0,0,NORTH");
        parser.input("MOVE");
        assertEquals("0,1,NORTH", parser.input("REPORT"));
    }

    @Test
    public void replaceCommandTest() throws Exception {

        parser.input("PLACE 0,0,NORTH");
        parser.input("MOVE");
        parser.input("PLACE 2,2,NORTH");
        assertEquals("2,2,NORTH", parser.input("REPORT"));

    }

    @Test
    public void moveToEdgeTest() throws Exception {

        assertEquals("", parser.input("PLACE 0,0,NORTH"));

        for(int i=0; i < 100; i++) {
            parser.input("MOVE");
        }

        String result = parser.input("REPORT");
        assertEquals("0,5,NORTH", result);
    }

    @Test
    public void allCommandTest() throws Exception {

        assertEquals("", parser.input("PLACE 2,2,NORTH"));
        parser.input("MOVE");
        assertEquals("2,3,NORTH", parser.input("REPORT"));
        parser.input("RIGHT");
        parser.input("MOVE");
        assertEquals("3,3,EAST", parser.input("REPORT"));
        parser.input("MOVE");
        assertEquals("4,3,EAST", parser.input("REPORT"));
        parser.input("LEFT");
        parser.input("LEFT");
        assertEquals("4,3,WEST", parser.input("REPORT"));
        parser.input("MOVE");
        assertEquals("3,3,WEST", parser.input("REPORT"));
    }
}
