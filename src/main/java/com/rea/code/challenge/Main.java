package com.rea.code.challenge;

import java.util.Scanner;

/**
 *
 *  main entry for toy-robot
 *
 * Created by tuhu on 15/7/24.
 */
public class Main {

    public static void main(String[] args) {
        String line = null;
        Board board = new Board(5,5);

        Parser parser = new Parser(board);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Toy Robot Simulator");
        System.out.println("Enter a command:");
        System.out.println(" EX: PLACE X,Y,NORTH|SOUTH|EAST|WEST");
        System.out.println(" EX: MOVE|LEFT|RIGHT|REPORT");
        System.out.println("Type QUIT to EXIT");

        do {
            System.out.print("Toy Robot>");
            line = scanner.nextLine();
            try {

                if("QUIT".equalsIgnoreCase(line)) {
                    break;
                } else {
                    line = line.toUpperCase();
                    String result = parser.input(line);
                    if (result != null && !"".equals(result)) {
                        System.out.println(result);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (true);
    }
}
