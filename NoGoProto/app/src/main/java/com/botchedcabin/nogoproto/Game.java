package com.botchedcabin.nogoproto;

/**
 * Created by Sean on 1/31/2015.
 */
public class Game {

    public int blackPiecesCaptured;
    public int whitePiecesCaptured;
    public int blackTerritory;
    public int whiteTerritory;
    public int blackScore;
    public int whiteScore;
    public int indexGameState;
        // 0 = black player's turn
        // 1 = white player's turn
        // 2 = game over
    public GoGameBoard m_gameboard;

    public Game() {

        blackPiecesCaptured = 0;
        whitePiecesCaptured = 0;
        blackTerritory = 0;
        whiteTerritory = 0;
        blackScore = whitePiecesCaptured + blackTerritory;
        whiteScore = blackPiecesCaptured+ whiteTerritory;
        GameBoard m_gameboard = new GameBoard();
    }

    public void newGame(int x){
        indexGameState = 0;
        m_gameboard = new GoGameBoard(x);
    }

    public int getGameState(){
        return indexGameState;
    }

    private void changeGameState(int x){
        indexGameState = x;
    }

    private void checkGameState(int x, int y){

        checkIfSurrounded(x,y);
        checkWinner();
    }

    /**
     *
     * Checks adjacent grid coordinate for it's state.
     *
     * int row = row
     * int col = column
     * int dir = direction to check:
     *              3 = Up
     *      2 = Left        1 = Right
     *              0 = Down
     */

    private Piece checkAdjacent(int row, int col, int dir){

        //validate values and throw except when appropriate instead of returning Empty

        //Down
        if (dir == 0)
        {   return m_gameboard.getBoard(row + 1, col);  }

        //Right
        if (dir == 1)
        {   return m_gameboard.getBoard(row, col + 1);  }

        //Left
        if (dir == 2)
        {   return m_gameboard.getBoard(row, col - 1);  }

        //Up
        if (dir == 3)
        {   return m_gameboard.getBoard(row - 1, col);  }

        else
        { return null; }

    }

    private boolean checkIfSurrounded(int row, int col){

        int piece = m_gameboard.convertCoordToIndex(row,col);
        //( m_gameboard.weightedunionfindObj.getListofConnectedComponents)

        return false; //placeholder to prevent build from breaking
    }

    public void skipTurn(){

    }

    public void capturePieces(){

    }

    public boolean checkWinner(){
        //if both players pass their turn consecutively, this returns true
        return false; //placeholder to prevent build from breaking
    }

    public void placePiece(int x, int y){
        //Called by UI when a player clicks a point on the board.

        if (m_gameboard.validateMove(x, y)) {
            switch (getGameState()) {
                case 0:
                {
                    m_gameboard.placePiece(x,y, new Piece(Color.BLACK));
                    changeGameState(1);
                    break;
                }

                case 1:
                {
                    m_gameboard.placePiece(x,y, new Piece(Color.WHITE));
                    changeGameState(0);
                    break;
                }
                case 2:
                {
                    //Game.indexGameState = 2;
                    break;
                }
            }
        }
    }

    public void calculateScore(){
        // Update Score
        blackScore = 0;
        whiteScore = 0;
    }
}
