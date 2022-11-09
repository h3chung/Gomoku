/**  
*   This is a java version of the board game called Gomoku also known as 5 in a row
*   but is a smaller version (10 x 10) rather than (15 x 15).
*/

import java.util.*;


// class Gomoku to store methods such as creating the board, printing, checking if someone won
public class Gomoku
{
    // creates 2D array which is 10 by 10
    public int[][] table = new int[10][10];
    public int move1, move2;

    // fills 2D array with 0s
    public Gomoku()
    {
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) 
            {
                table[row][col] = 0;
            }
        }
    }

    // method to print the 2D array (board)
    public void printTable()
    {
        // format the board so rows and column numbers are visible
        System.out.print("# |\t"); 
        for (int num = 0; num < 10; num++) {
            System.out.print(num + "\t"); 
        }
        System.out.println("\n--+---------------------------------------");
         
        for (int row = 0; row < 10; row++) {
            System.out.print(row + " |\t");
            for (int col = 0; col < table[row].length; col++) {
                System.out.print(table[row][col] + "\t");
            }
            System.out.println();
        }

    }

    // method for player 1 to make their move
    public int player1Move(String move)
    {
        int repeat;

        // check if it is valid input
        if (move.length() == 2)
        {
            move1 = Character.getNumericValue(move.charAt(0));
            move2 = Character.getNumericValue(move.charAt(1));

            // check if it is valid input
            if (move1 >= 0 && move1 <= 9 && move2 >= 0 && move2 <= 9)
            {
                if (table[move1][move2] == 0)
                {

                // replace the 0 in that spot with 1 to show that player 1 placed there
                table[move1][move2] = 1;
                repeat = 0;
                System.out.print("\033[H\033[2J");
                } 

                // check if there is already a piece placed
                else
                {
                System.out.print("\033[H\033[2J");
                System.out.println("There is already a piece in that spot.");
                repeat = 1;
                }
            }
            else
            {
            System.out.print("\033[H\033[2J");
            System.out.println("Invalid input, please try again.");
            repeat = 1;
            }
        }
        else
        {
            System.out.print("\033[H\033[2J");
            System.out.println("Invalid input, please try again.");
            repeat = 1;
        }
        return repeat;
    }


    // same thing above for player 2
    public int player2Move(String move)
    {
        int repeat;
        if (move.length() == 2)
        {
            move1 = Character.getNumericValue(move.charAt(0));
            move2 = Character.getNumericValue(move.charAt(1));
            if (move1 >= 0 && move1 <= 9 && move2 >= 0 && move2 <= 9)
            {
                if (table[move1][move2] == 0)
                {
                table[move1][move2] = 2;
                repeat = 0;
                System.out.print("\033[H\033[2J");
                } 
                else
                {
                System.out.print("\033[H\033[2J");
                System.out.println("There is already a piece in that spot.");
                repeat = 1;
                }
            }
            else
            {
            System.out.print("\033[H\033[2J");
            System.out.println("Invalid input, please try again.");
            repeat = 1;
            }
        }
        else
        {
            System.out.print("\033[H\033[2J");
            System.out.println("Invalid input, please try again.");
            repeat = 1;
        }
        return repeat;
    }

    // check if player 1 has won with 5 in a row horizonally
    public int horizontalCheck1()
    {
        int check = 1;
        for (int x = 0; x < table.length; x++) {
            for (int y = 0; y < 6; y++) {
                if (table[x][y] == 1 && table[x][y + 1] == 1 && table[x][y + 2] == 1 && table[x][y + 3] == 1 && table[x][y + 4] == 1)
                {
                    System.out.println("\nPlayer 1 Wins!!! (Horizontal Five in a Row)");
                    check = 0;
                }
            }
        }
        return check;
    }

    // same thing above for player 2
    public int horizontalCheck2()
    {
        int check = 1;
        for (int x = 0; x < table.length; x++) {
            for (int y = 0; y < 6; y++) {
                if (table[x][y] == 2 && table[x][y + 1] == 2 && table[x][y + 2] == 2 && table[x][y + 3] == 2 && table[x][y + 4] == 2)
                {
                    System.out.println("\nPlayer 2 Wins!!! (Horizontal Five in a Row)");
                    check = 0;
                }
            }
        }
        return check;
    }

    // check if player 1 has won with 5 in a row vertically
    public int verticalCheck1()
    {
        int check = 1;
        for (int y = 0; y < table.length; y++) {
            for (int x = 0; x < 6; x++) {        
                if (table[x][y] == 1 && table[x + 1][y] == 1 && table[x + 2][y] == 1 && table[x + 3][y] == 1 && table[x + 4][y] == 1)
                {
                    System.out.println("\nPlayer 1 Wins!!! (Vertical Five in a Row)");
                    check = 0;
                }
            }
        }
        return check;
    }

    // same thing above for player 2
    public int verticalCheck2()
    {
        int check = 1;
        for (int y = 0; y < table.length; y++) {
            for (int x = 0; x < 6; x++) {        
                if (table[x][y] == 2 && table[x + 1][y] == 2 && table[x + 2][y] == 2 && table[x + 3][y] == 2 && table[x + 4][y] == 2)
                {
                    System.out.println("\nPlayer 2 Wins!!! (Vertical Five in a Row)");
                    check = 0;
                }
            }
        }
        return check;
    }

    // check if player 1 has won with 5 in a row diagonally going from top left to bottom right
    public int diagonalCheckDown1()
    {
        int check = 1;
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                if (table[x][y] == 1 && table[x + 1][y + 1] == 1 && table[x + 2][y + 2] == 1 && table[x + 3][y + 3] == 1 && table[x + 4][y + 4] == 1)
                {
                    System.out.println("\nPlayer 1 Wins!!! (Diagonal Five in a Row)");
                    check = 0;
                }
            }
        }
        return check;
    }

    // same thing above for player 2
    public int diagonalCheckDown2()
    {
        int check = 1;
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                if (table[x][y] == 2 && table[x + 1][y + 1] == 2 && table[x + 2][y + 2] == 2 && table[x + 3][y + 3] == 2 && table[x + 4][y + 4] == 2)
                {
                    System.out.println("\nPlayer 2 Wins!!! (Diagonal Five in a Row)");
                    check = 0;
                }
            }
        }
        return check;
    }

    // check if player 1 has won with 5 in a row diagonally going from bottom left to top right
    public int diagonalCheckUp1()
    {
        int check = 1;
        for (int x = 9; x > 3; x--) {
            for (int y = 0; y < 6; y++) {
                if (table[x][y] == 1 && table[x - 1][y + 1] == 1 && table[x - 2][y + 2] == 1 && table[x - 3][y + 3] == 1 && table[x - 4][y + 4] == 1)
                {
                    System.out.println("Player 1 Wins!!! (Diagonal Five in a Row)");
                    check = 0;
                }
            }
        }
        return check;
    } 

    // same thing above for player 2
    public int diagonalCheckUp2()
    {
        int check = 1;
        for (int x = 9; x > 3; x--) {
            for (int y = 0; y < 6; y++) {
                if (table[x][y] == 2 && table[x - 1][y + 1] == 2 && table[x - 2][y + 2] == 2 && table[x - 3][y + 3] == 2 && table[x - 4][y + 4] == 2)
                {
                    System.out.println("Player 2 Wins!!! (Diagonal Five in a Row)");
                    check = 0;
                }
            }
        }
        return check;
    } 

    // if the whole board is filled and there is no winner, declare a tie
    public int tieCheck()
    {
        int check = 1;
        int counter = 0;
        for (int row = 0; row < table.length; row++) 
        {
            for (int col = 0; col < table[row].length; col++) 
            {
                if (table[row][col] != 0)
                {
                    counter++;
                }
            }
        }
        if (counter == 100)
        {
            System.out.println("Tie!");
            check = 0;
        }
        return check;
    }
}