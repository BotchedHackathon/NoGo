package com.botchedcabin.nogoproto;

/**
 * GameBoard class represents the Go game board.
 *
 *  m_boardSize is the length/width of the square grid size.
 *
 *  boardState is a 2D Piece array that keeps track of the state of the board
 *  and where pieces are placed.
 *
 *      defaultGameBoardSize defines the dimension of the Go board if
 *      the constructor is called without passing in a value.
 */
public class GoGameBoard {

    public int m_boardSize;
    public Piece[][] boardState;
    public ConnectedComponents conComp = new ConnectedComponents(m_boardSize);
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
        boardState = new Piece[m_boardSize + 2][m_boardSize + 2];

        // Need to initialize invisible boundary rows and columns to different value.
        for (int i = 0; i < m_boardSize + 1; i++){
            // starts in corners and fills in by row/column
            boardState[0][i] = Piece.Border;
            conComp.union(0,i,0,i+1);
            boardState[m_boardSize + 1][m_boardSize+1-i] = Piece.Border;
            conComp.union(m_boardSize+1,m_boardSize+1-i,m_boardSize+1,m_boardSize-i);
            boardState[i][0] = Piece.Border;
            conComp.union(i,0,i+1,0);
            boardState[m_boardSize+1-i][m_boardSize + 1] = Piece.Border;
            conComp.union(m_boardSize+1-i,m_boardSize + 1,m_boardSize-i,m_boardSize+1);
        }
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
        boardState[x][y] = Piece.Black;
    }

    public void placeWhitePiece(int x, int y){
        boardState[x][y] = Piece.White;
    }

    public Piece[][] getBoard(){
        return boardState;
    }

    public Piece getBoard(int x, int y){
        return boardState[x][y];
    }

}
