/**  
*   James Chung
*   ICS4U1
*   Final Project - Mini Gomoku (Five in a Row)
*   January 26, 2022
*   This is a Java version of the board game called Gomoku also known as 5 in a row
*   but is a smaller version (10 x 10) rather than (15 x 15).
*/

import java.util.*;

class Main {
  public static void main(String[] args) {

    int play = 0;
    Scanner in = new Scanner(System.in);

    // print out rules and how to play
    System.out.println("\nWelcome to Mini Gomoku (also known as Five in a Row). \n\nIn this game, two players will take turns placing pieces on the 10 by 10 board"
                        + " \nuntil one person has successfully placed five pieces in a row either horizontally, \nvertically, or diagonally."
                        + " The numbers at the top and the side show what numbers to \ninput when making a move. You will have to input the number of the"
                        + " row (side number) \nfollowed by the number of the column (top number) without any extra characters or spaces. \nFor example,"
                        + " inputting 01 would place your piece on row index of 0 and column index of 1.\n\nPress 1 to play");

    
    play = in.nextInt();

    // loop for whole game
    do 
    {
        // bring Gomoku class in
        Gomoku g;
        g = new Gomoku();

        String input = "";
        int turnRepeat = 1;
        int player1 = 1;
        int player2 = 1;
        in.nextLine();

        // loop for playing part of game (rotating between player 1 and 2)
        do 
        {
            // clear console
            System.out.print("\033[H\033[2J");

            // loop for player 1's turn
            do 
            {
                g.printTable();
                System.out.println("Player 1's Turn:");
                input = in.nextLine();
                player1 = g.player1Move(input);
                player2 = 1;

                // check if they won
                if (g.horizontalCheck1() == 0)
                {
                    player1 = 0;
                    player2 = 0;
                    turnRepeat = 0;
                    break;
                }
                else if (g.verticalCheck1() == 0)
                {
                    player1 = 0;
                    player2 = 0;
                    turnRepeat = 0;
                    break;
                }
                else if (g.diagonalCheckDown1() == 0)
                {
                    player1 = 0;
                    player2 = 0;
                    turnRepeat = 0;
                    break;
                }
                else if (g.diagonalCheckUp1() == 0)
                {
                    player1 = 0;
                    player2 = 0;
                    turnRepeat = 0;
                    break;
                }
                else if (g.tieCheck() == 0)
                {
                    player1 = 0;
                    player2 = 0;
                    turnRepeat = 0;
                    break;
                }
            } while (player1 == 1);

        // loop for player 2's turn
        while (player2 == 1)
            {
                g.printTable();
                System.out.println("Player 2's Turn:");
                input = in.nextLine();
                player2 = g.player2Move(input);

                // check if they won
                if (g.horizontalCheck2() == 0)
                {
                    player1 = 0;
                    player2 = 0;
                    turnRepeat = 0;
                    break;
                }
                else if (g.verticalCheck2() == 0)
                {
                    player1 = 0;
                    player2 = 0;
                    turnRepeat = 0;
                    break;
                }
                else if (g.diagonalCheckDown2() == 0)
                {
                    player1 = 0;
                    player2 = 0;
                    turnRepeat = 0;
                    break;
                }
                else if (g.diagonalCheckUp2() == 0)
                {
                    player1 = 0;
                    player2 = 0;
                    turnRepeat = 0;
                    break;
                }
                else if (g.tieCheck() == 0)
                {
                    player1 = 0;
                    player2 = 0;
                    turnRepeat = 0;
                    break;
                }
            } 
        } while (turnRepeat == 1);

        // show final board and ask if they want to play again
        System.out.println("");
        g.printTable();
        System.out.println("\nPress 1 to play again. \nPress 0 to exit.");
        play = in.nextInt();
    } while (play == 1);
    System.out.println("Thanks for Playing! Bye Bye!");
    
  }
}