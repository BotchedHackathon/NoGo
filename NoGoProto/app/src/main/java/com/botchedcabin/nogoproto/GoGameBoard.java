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

    public boolean validateMove(int x, int y, Piece p){
        // Check if move is legal
        ArrayList<GameBoardVertex> ccPrimary;
        ArrayList<GameBoardVertex> ccSecondarySeeds = new ArrayList<GameBoardVertex>();
        ArrayList<GameBoardVertex> ccSecondary = new ArrayList<GameBoardVertex>();
        ArrayList<GameBoardVertex> ccSecondaryTemp;
        ArrayList<GameBoardVertex> ccSecondaryCap = new ArrayList<GameBoardVertex>();

        placePiece(x,y,p);
        ccPrimary = getConnectedComponent(x,y);
        if (checkNeighborVacancy(ccPrimary)){
            return true;
        } else{
            // Populate ccSecondarySeeds
            for (GameBoardVertex v : ccPrimary){
                for (GameBoardVertex vNeigh : v.getNeighbors()){
                    if (vNeigh.samePieceCheck(v)){
                        ccSecondarySeeds.add(vNeigh);
                    }
                }
            }

            // Check if this eliminates part of opponent's formation
            boolean checkCapturePieces = false;
            for (GameBoardVertex vSeed : ccSecondarySeeds){
                if (!ccSecondary.contains(vSeed)){
                    ccSecondaryTemp = getConnectedComponent(vSeed);
                    if (!checkNeighborVacancy(ccSecondaryTemp)){
                        checkCapturePieces = true;
                        ccSecondaryCap.addAll(ccSecondaryTemp);
                    }
                    ccSecondary.addAll(ccSecondaryTemp);
                }
            }
            if (checkCapturePieces) {
                removePiece(ccSecondaryCap);
            } else {
                removePiece(x,y);
            }
            return checkCapturePieces;
        }
    }

    public void placePiece(int x, int y, Piece gamePiece){
        int index = convertCoordToIndex(x,y);
        boardVertices.get(index).placePiece(gamePiece);
    }

    public void removePiece(int x, int y){
        boardVertices.get(convertCoordToIndex(x,y)).placePiece(null);
    }

    public void removePiece(ArrayList<GameBoardVertex> removalList){
        for (GameBoardVertex v : removalList){
            v.placePiece(null);
        }
    }

    public GameBoardVertex getBoard(int x, int y){
        int index = convertCoordToIndex(x,y);
        return boardVertices.get(index);
    }

    public ArrayList<GameBoardVertex> getConnectedComponent(int x, int y){
        return getConnectedComponent(convertCoordToIndex(x,y));
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

    public void printBoard(){
        GoGameBoardVertex blackVtx = new GoGameBoardVertex();
        blackVtx.placePiece(new Piece(Color.BLACK));
        GoGameBoardVertex whiteVtx = new GoGameBoardVertex();
        whiteVtx.placePiece(new Piece(Color.WHITE));

        System.out.println("Current Board:");
        for (int ii = 1; ii <= m_boardSize; ii++){
            String line = new String();
            for (int jj = 1; jj <= m_boardSize; jj++){
                if (boardVertices.get(convertCoordToIndex(ii,jj)).getPiece() != null){
                    switch (boardVertices.get(convertCoordToIndex(ii,jj)).getPiece().getColor()){
                        case BLACK: line = line + "b";
                            break;
                        case WHITE: line = line + "w";
                            break;
                        default: line = line + "+";
                            break;
                    }
                } else {
                    line = line + "+";
                }
            }
            System.out.println(line);
        }
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

class ValidateMoveTest{
    public static void main(String[] args){
        int boardSize = 5;
        GoGameBoard testBoard = new GoGameBoard(boardSize);
        testBoard.placePiece(1, 2, new Piece(Color.BLACK));
        testBoard.placePiece(2, 1, new Piece(Color.BLACK));
        testBoard.printBoard();
        testBoard.validateMove(1,1,new Piece(Color.WHITE));
        testBoard.printBoard();
    }
}