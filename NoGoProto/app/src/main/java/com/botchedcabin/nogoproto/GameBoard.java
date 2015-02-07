package com.botchedcabin.nogoproto;

import java.util.ArrayList;

/**
 * GameBoard class represents a game board represented as a graph.
 */
public class GameBoard {

    public ArrayList<GameBoardVertex> boardVertices = new ArrayList<>();
    static final int defaultGameBoardSize = 9;
    private ArrayList<GameBoardVertex> visited = new ArrayList();

    /**
     * Default constructor.
     * Sets board size to 9x9
     */
    public GameBoard(){initializeGameBoard(defaultGameBoardSize);}

    /**
     * More elaborate constructor
     * Generates a square board with each side having boardSize spaces.
     * @param boardSize number of spaces along each row/column.
     */
    public GameBoard(int boardSize){initializeGameBoard(boardSize);}

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

    private void initializeGameBoard(int boardSize){
        int numVertices = boardSize * boardSize;
        int halfNumEdges = boardSize * (boardSize - 1);
        int edges[][] = new int[2 * halfNumEdges][2];

        // Enumerate edges for square board
        for (int ii = 0; ii < boardSize; ii++){
            for (int jj = 0; jj < boardSize - 1; jj++){
                edges[(boardSize - 1) * ii + jj][0] = boardSize * ii + jj;
                edges[(boardSize - 1) * ii + jj][1] = boardSize * ii + jj + 1;
                edges[(boardSize - 1) * ii + jj + halfNumEdges][0] = boardSize * jj + ii;
                edges[(boardSize - 1) * ii + jj + halfNumEdges][1] = boardSize * (jj + 1) + ii;
            }
        }
        initializeGameBoard(numVertices,edges);
    }

    public void placePiece(int coord, Piece gamePiece){
        boardVertices.get(coord).placePiece(gamePiece);
    }

    public ArrayList getBoard(){
        return boardVertices;
    }

    public GameBoardVertex getBoard(int coord){
        return boardVertices.get(coord);
    }

    public void printBoard(){
        for (GameBoardVertex node : boardVertices){
            node.printContents();
            System.out.println(" ");
        }
    }

    public ArrayList<GameBoardVertex> getConnectedComponent(int coord){
        return getConnectedComponent(boardVertices.get(coord));
    }

    public ArrayList<GameBoardVertex> getConnectedComponent(GameBoardVertex currentVertex){
        ArrayList<GameBoardVertex> connectedComponent = new ArrayList<GameBoardVertex>();

        connectedComponent.add(currentVertex);
        visited.add(currentVertex);
        for(GameBoardVertex v : currentVertex.getNeighbors()){
            if (v.samePieceCheck(currentVertex) && !visited.contains(v)){
                connectedComponent.addAll(getCCDfs(v));
            }
        }
        visited.clear();
        return connectedComponent;
    }

    private ArrayList<GameBoardVertex> getCCDfs(GameBoardVertex currentVertex){
        ArrayList<GameBoardVertex> cc = new ArrayList<GameBoardVertex>();
        cc.add(currentVertex);
        visited.add(currentVertex);
        for(GameBoardVertex v : currentVertex.getNeighbors()){
            if (v.samePieceCheck(currentVertex) && !visited.contains(v)){
                cc.addAll(getCCDfs(v));
            }
        }
        return cc;
    }
}

class GameBoardTest {
    static public void main(String[] args) {
        int boardSize = 2;
        GameBoard testBoard = new GameBoard(boardSize);
        testBoard.printBoard();
    }
}

class GameBoardConnectedComponentsTest {
    static public void main(String[] args){
        int boardSize = 3;
        GameBoard testBoard = new GameBoard(boardSize);
        testBoard.printBoard();
        ArrayList<GameBoardVertex> cc1 = testBoard.getConnectedComponent(0);
        System.out.println(cc1);

        testBoard.placePiece(0,new Piece(Color.BLACK));
        testBoard.placePiece(1,new Piece(Color.BLACK));

        ArrayList<GameBoardVertex> cc2 = testBoard.getConnectedComponent(0);
        ArrayList<GameBoardVertex> cc3 = testBoard.getConnectedComponent(2);

        System.out.println(cc2);
        System.out.println(cc3);
    }
}