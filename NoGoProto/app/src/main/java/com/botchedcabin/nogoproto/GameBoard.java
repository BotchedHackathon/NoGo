package com.botchedcabin.nogoproto;

/**
 * Created by Sean on 1/31/2015.
 */
public class GameBoard {

    public int m_boardSize;
    public int[][] boardState = new int[m_boardSize + 2][m_boardSize + 2];

    static final int defaultGameBoardSize = 9;

    /**
     * Default constructor.
     * Sets board size to 9x9
     */
    public GameBoard(){
        initializeGameBoard(defaultGameBoardSize);
    }

    /**
     * A constructor.
     * A more elaborate description of the constructor.
     * @param boardSize The size of the desired board.
     */
    public GameBoard(int boardSize){
        initializeGameBoard(boardSize);
    }

    /**
     * Initialize the board
     * Sets the board size and blacks and white score
     */
    private void initializeGameBoard(int boardSize){
        m_boardSize = boardSize;

        // Specify boundary nodes

    }

    /**
     * Method to convert a gameboard coordinate to it's proper index value
     */
    private int convertCoordToIndex(int x, int y){

        return 1;
    }

    public boolean validateMove(int x, int y){
        // Check if move is legal
        return true;
    }

    public void placeBlack(int x, int y){
        // Place a black stone (set to 1)
        boardState[x][y]=1;
    }

    public void placeWhite(int x, int y){
        // Place a white stone (set to 2)
        boardState[x][y]=2;
    }





}
