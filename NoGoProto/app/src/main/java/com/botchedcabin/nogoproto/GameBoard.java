package com.botchedcabin.nogoproto;

import java.util.ArrayList;

/**
 * GameBoard class represents a game board represented as a graph.
 */
public class GameBoard {

    public ArrayList<GameBoardVertex> boardVertices;
    static final int defaultGameBoardSize = 9;

    /**
     * Default constructor.
     * Sets board size to 9x9
     */
    public GameBoard(){new GameBoard(defaultGameBoardSize);}

    /**
     * More elaborate constructor
     * Generates a square board with each side having boardSize spaces.
     * @param boardSize number of spaces along each row/column.
     */
    public GameBoard(int boardSize){
        int numVertices = boardSize * boardSize;
        int halfNumEdges = boardSize * (boardSize - 1);
        int edges[][] = new int[2 * halfNumEdges][2];

        // Enumerate edges for square board
        for (int ii = 0; ii < boardSize; ii++){
            for (int jj = 0; jj < boardSize - 1; jj++){
                edges[(boardSize - 1) * ii + jj][0] = (boardSize - 1) * ii + jj;
                edges[(boardSize - 1) * ii + jj][1] = (boardSize - 1) * ii + jj + 1;
                edges[(boardSize - 1) * ii + jj + halfNumEdges][0] = (boardSize - 1) * jj + ii;
                edges[(boardSize - 1) * ii + jj + halfNumEdges][1] = (boardSize) * jj + ii;
            }
        }
        initializeGameBoard(numVertices,edges);
    }

    /**
     * A more elaborate version of the constructor.  Requires the number of vertices and a list of the edges
     * @param numVertices Number of vertices of the board graph
     * @param edges List of the edges connecting the vertices
     */
    public GameBoard(int numVertices, int[][] edges){
        initializeGameBoard(numVertices, edges);
    }

    /**
     * Initialize the board
     * Sets the board size and blacks and white score
     */
    private void initializeGameBoard(int numVertices, int[][] edges){
        for (int ii = 0; ii < numVertices; ii++){
            boardVertices.add(new GameBoardVertex());
        }

        // Links edges assuming undirected graph
        for (int ii = 0; ii < edges.length; ii++){
            // One direction
            boardVertices.get(edges[ii][0]).addNeighbor(boardVertices.get(edges[ii][1]));
            // The other
            boardVertices.get(edges[ii][1]).addNeighbor(boardVertices.get(edges[ii][0]));
        }
    }

    public void placePiece(int coord, Piece gamePiece){
        boardVertices.get(coord).placePiece(gamePiece);
    }

    public ArrayList getBoard(){
        return boardVertices;
    }

    public Piece getBoard(int coord){
        return boardVertices.get(coord).getPiece();
    }

}

class GameBoardTest {
    static public void main(String[] args) {

    }
}