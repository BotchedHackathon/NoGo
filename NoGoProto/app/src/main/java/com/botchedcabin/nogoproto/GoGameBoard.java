package com.botchedcabin.nogoproto;

import java.util.ArrayList;

/**
 * GoGameBoard class represents the Go game board.
 *
 *  m_boardSize is the length/width of the square grid size.
 *
 *  boardState is a 2D Piece array that keeps track of the state of the board
 *  and where pieces are placed.
 *
 *      defaultGameBoardSize defines the dimension of the Go board if
 *      the constructor is called without passing in a value.
 */
public class GoGameBoard extends GameBoard {

    public int m_boardSize;
    static final int defaultGameBoardSize = 9;

    /**
     * Default constructor.
     * Sets board size to 9x9
     */
    public GoGameBoard(){
        super(defaultGameBoardSize);
        m_boardSize = defaultGameBoardSize;
    }

    /**
     * A constructor.
     * A more elaborate description of the constructor.
     * @param boardSize The size of the desired board.
     */
    public GoGameBoard(int boardSize){
        super(boardSize);
        m_boardSize = boardSize;
    }


    /**
     * Method to convert a gameboard coordinate to it's proper index value
     */
    public int convertCoordToIndex(int x, int y){

        return m_boardSize*(x-1) + (y-1);
    }

    public boolean validateMove(int x, int y){
        // Check if move is legal
        return true;
    }

    public void placePiece(int x, int y, Piece gamePiece){
        int index = convertCoordToIndex(x,y);
        boardVertices.get(index).placePiece(gamePiece);
    }

    public GameBoardVertex getBoard(int x, int y){
        int index = convertCoordToIndex(x,y);
        return boardVertices.get(index);
    }

    public boolean checkNeighborVacancy(int x, int y){
        for (GameBoardVertex v : getBoard(x,y).getNeighbors()){
            if (v.getPiece() == null){return true;}
        }
        return false;
    }

    public boolean checkNeighborVacancy(ArrayList<GameBoardVertex> vertexList){
        for (GameBoardVertex v : vertexList){
            for (GameBoardVertex neigh : v.getNeighbors()){
                if (neigh.getPiece() == null){return true;}
            }
        }
        return false;
    }
}

class GoGameBoardTest{
    public static void main(String[] args){
        int boardSize = 2;
        GoGameBoard testBoard = new GoGameBoard(boardSize);
        testBoard.placePiece(1,1,new Piece(Color.BLACK));
        testBoard.printBoard();
        System.out.println(testBoard.m_boardSize);

    }
}

class CheckNeighborVacancyTest {
    public static void main(String[] args){
        int boardSize = 2;
        GoGameBoard testBoard = new GoGameBoard(boardSize);
        System.out.println(testBoard.checkNeighborVacancy(1,1));
        System.out.println(testBoard.checkNeighborVacancy(testBoard.getConnectedComponent(0)));

        for (int ii = 0; ii < boardSize*boardSize; ii++){
            testBoard.placePiece(ii,new Piece(Color.BLACK));
        }
        System.out.println(testBoard.checkNeighborVacancy(1,1));

        System.out.println(testBoard.checkNeighborVacancy(testBoard.getConnectedComponent(0)));
    }
}