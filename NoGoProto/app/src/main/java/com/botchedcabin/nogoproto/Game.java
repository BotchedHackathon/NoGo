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
    public GameBoard m_gameboard;

    public Game () {

        blackScore = whitePiecesCaptured + blackTerritory;
        whiteScore = blackPiecesCaptured+ whiteTerritory;
        GameBoard m_gameboard = new GameBoard();
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
