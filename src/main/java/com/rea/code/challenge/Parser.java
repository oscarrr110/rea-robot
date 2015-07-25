package com.rea.code.challenge;

/**
 * Created by tuhu on 15/7/24.
 */
public class Parser {

    private Position position;

    private Board board;


    public Parser(Board b) {
        this.board = b;
    }

    /**
     *
     * parse the input command
     *
     * @param inputStr
     * @return empty string will be returned if command is processed sucessfully
     * @throws Exception
     */
    public String input(String inputStr) throws Exception {

        String result = "";
        String[] args = inputStr.split(" ");

        // validate command
        Command command;
        try {
            command = Command.valueOf(args[0]);
        } catch (IllegalArgumentException e) {
            result = Constant.INVALID_COMMAND;
            return result;
        }

        if(command != Command.PLACE && position == null) {
                result = Constant.PLACE_COMMAND_MUST_BE_FIRST;
                return result;
        }


        switch(command) {

            case PLACE:

                result = place(args[1]);
                break;

            case LEFT:

                position.left();
                break;

            case RIGHT:

                position.right();
                break;

            case MOVE:

                position.nextStep();
                break;

            case REPORT:

                result = position.report();
                break;

            default:

                result = Constant.INVALID_COMMAND;
                break;
        }

        return result;

    }

    /**
     *
     * check and process place command
     *
     * @param args place command arguments
     *
     * @return if invalid command or go to board, then return error msg, else return empty string
     */
    private String place(String args) {

        String result = "";
        try {

            String leftArgs = args;
            String[] placeArgs = leftArgs.split(",");
            int x = Integer.parseInt(placeArgs[0]);
            int y = Integer.parseInt(placeArgs[1]);
            Direction direction = Direction.valueOf(placeArgs[2]);

            if(!board.isValidPosition(new Position(x, y, direction, board))) {
                result = String.format("Position invalid, x: %d, y: %d", x, y);
            } else {
                position = new Position(x, y, direction, board);
            }
        } catch(Exception e) {
            result = Constant.PLACE_COMMAND_INVALID;
        }
        return result;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
