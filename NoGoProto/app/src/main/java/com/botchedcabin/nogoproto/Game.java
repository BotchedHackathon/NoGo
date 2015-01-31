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
    public GameBoard m_gameboard;

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
        m_gameboard = new GameBoard(x);
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

    private boolean checkIfSurrounded(int x, int y){

        int piece = m_gameboard.convertCoordToIndex(x,y);
        //if ( m_gameboard.weightedunionfindObj.)

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
                    m_gameboard.placeBlackPiece(x,y);
                    changeGameState(1);
                    break;
                }

                case 1:
                {
                    m_gameboard.placeWhitePiece(x,y);
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
