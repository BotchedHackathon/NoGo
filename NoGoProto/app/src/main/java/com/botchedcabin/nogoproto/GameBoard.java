package com.botchedcabin.nogoproto;

/**
 * GameBoard class represents the Go game board.
 *
 *  m_boardSize is the length/width of the square grid size.
 *
 *  boardState is a 2D int array that keeps track of the state of the board
 *  and where pieces are placed:
 *      0 = empty
 *      1 = black piece
 *      2 = white piece
 *      3 = invisible boundary node
 *
 *      defaultGameBoardSize defines the dimension of the Go board if
 *      the constructor is called without passing in a value.
 */
public class GameBoard {

    public int m_boardSize;
    public int[][] boardState;
    static final int defaultGameBoardSize = 9;
//  Need a weightedUnionFind object to keep track of connections


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
        boardState = new int[m_boardSize + 2][m_boardSize + 2];

        // Need to initialize invisible boundary rows and columns to different value.
        for (int i = 0; i < m_boardSize + 2; i++){
            boardState[0][i] = 3;
        }

        for (int i = 0; i < m_boardSize + 2; i++){
            boardState[m_boardSize + 1][i] = 3;
        }

        for (int i = 0; i < m_boardSize + 2; i++){
            boardState[i][0] = 3;
        }

        for (int i = 0; i < m_boardSize + 2; i++){
            boardState[i][m_boardSize + 1] = 3;
        }
        // Specify boundary nodes

    }

    /**
     * Method to convert a gameboard coordinate to it's proper index value
     */
    public int convertCoordToIndex(int x, int y){

        return 1;
    }

    public boolean validateMove(int x, int y){
        // Check if move is legal
        return true;
    }

    public void placeBlackPiece(int x, int y){
        boardState[x][y] = 1;
    }

    public void placeWhitePiece(int x, int y){
        boardState[x][y] = 2;
    }

    public int[][] getBoard(){
        return boardState;
    }

    public int getBoard(int x, int y){
        return boardState[x][y];
    }

}
