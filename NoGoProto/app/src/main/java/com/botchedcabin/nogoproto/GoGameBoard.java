package com.botchedcabin.nogoproto;

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
        initializeGoGameBoard(defaultGameBoardSize);
    }

    /**
     * A constructor.
     * A more elaborate description of the constructor.
     * @param boardSize The size of the desired board.
     */
    public GoGameBoard(int boardSize){
        initializeGoGameBoard(boardSize);
    }

    /**
     * Initialize the board
     * Sets the board size and blacks and white score
     */
    private void initializeGoGameBoard(int boardSize){
        new GameBoard(boardSize);
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

    public Piece getBoard(int x, int y){
        int index = convertCoordToIndex(x,y);
        return boardVertices.get(index).getPiece();
    }

}
