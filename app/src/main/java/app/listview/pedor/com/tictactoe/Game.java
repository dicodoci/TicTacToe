package app.listview.pedor.com.tictactoe;

import android.app.Activity;
import android.widget.Button;

/**
 * Created by dico on 16-2-2018.
 */

// Class that controls and remembers the game field
public class Game {
    public Activity activity;
    final private int BOARD_SIZE = 3;
    private Tile[][] board;
    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private Boolean gameOver;

    // initialize game
    public Game() {
        board = new Tile[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = Tile.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }

    // Checks and updates tile and returns what there should be drawn
    public Tile draw(int row, int column) {
        if (board[row-1][column-1] == Tile.BLANK) {
            if (playerOneTurn) {
                board[row-1][column-1] = Tile.CROSS;
                playerOneTurn = Boolean.FALSE;
                return Tile.CROSS;
            } else {
                board[row-1][column-1] = Tile.CIRCLE;
                playerOneTurn = Boolean.TRUE;
                return Tile.CIRCLE;
            }
        } else {
            return Tile.INVALID;
        }
    }
}
