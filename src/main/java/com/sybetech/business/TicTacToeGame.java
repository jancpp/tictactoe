package com.sybetech.business;

public class TicTacToeGame {
    private static final char UNOCCUPIED = '\0';

    public static final String RESULT_IN_PROGRESS = "In progress";
    static final String RESULT_DRAW = "Draw";
    static final String RESULT_WINNER = "Winner is %s";

    public static final String COORDINATE_ERR_MSG = "Coordinate must be between 1 and 3";
    public static final String FIELD_OCCUPIED_ERR_MSG = "Field is already occupied!";
    public static final String SAVE_STATE_ERR_MSG = "Could not save state to DB!";
    public static final String DROP_DB_ERR_MSG = "Could not drop DB collection!";

    private Character[][] board = {
        {UNOCCUPIED, UNOCCUPIED, UNOCCUPIED}
        , {UNOCCUPIED, UNOCCUPIED, UNOCCUPIED}
        , {UNOCCUPIED, UNOCCUPIED, UNOCCUPIED}
    };
    private char lastPlayer = UNOCCUPIED;

    private int move = 0;
    private static final int SIZE = 3;

    private TicTacToeGameState state;

    //

    /**
     *
        1     2     3
     |-----|-----|-----|-->x
    1|(1,1)|(2,1)|(3,1)|
    2|(1,2)|(2,2)|(3,2)|
    3|(1,3)|(2,3)|(3,3)|
     |-----|-----|-----|
     |
     y
     *
     * Hint: you may use the players ascii values: 'X'=88*3 = 264 => X wins, 'O'=79*3 = 237 => O wins
     **/
    private boolean isWin(int x, int y) {
        // TODO set return value
        return false;
    }

    // Hint: if one cell is UNOCCUPIED false, else true
    private boolean isDraw() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y] == null) {
                    //...
                }
            }
        }
        // TODO set return value
        return false;
    }
}
