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
    static public int indexGameState;
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

    public void checkGameState(int x, int y){

    }

    public void skipTurn(){

    }

    public void capturePieces(){

    }



    public void calculateScore(){
        // Update Score
        blackScore = 0;
        whiteScore = 0;
    }
}
