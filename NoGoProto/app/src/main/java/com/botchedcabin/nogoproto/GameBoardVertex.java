package com.botchedcabin.nogoproto;
import java.util.ArrayList;

/** GameBoardVertex.java
 * Implements vertex of GameBoard graph which stores the piece stored at the vertex and an ArrayList
 * of the neighbor vertices of this vertex.
 * Created by Michael Nip on 2/6/2015.
 */

public class GameBoardVertex {
    private Piece pieceAtVertex;
    private ArrayList<GameBoardVertex> neighbors;

    /**
     * Default Constructor
     */
    GameBoardVertex(){}

    /**
     * Constructor for placing a piece but no neighboring vertices
     */
    GameBoardVertex(Piece pieceAtVertex){this.pieceAtVertex = pieceAtVertex;}

    /**
     * Constructor for specifying neighbors but no piece
     */
    GameBoardVertex(ArrayList<GameBoardVertex> neighbors){this.neighbors = neighbors;}

    /**
     * Constructor for specifying only a single neighbor
     */
    GameBoardVertex(GameBoardVertex neighbor){this.neighbors.add(neighbor);}

    /**
     * Constructor for specifying everything
     */
    GameBoardVertex(Piece pieceAtVertex, ArrayList<GameBoardVertex> neighbors){
        this.pieceAtVertex = pieceAtVertex;
        this.neighbors = neighbors;
    }

    /**
     * getNeighbors
     * @return neighbor vertices
     */
    public ArrayList<GameBoardVertex> getNeighbors(){return neighbors;}

    public void addNeighbor(GameBoardVertex neighbor){
        neighbors.add(neighbor);
    }

    /**
     * getPiece
     * @return piece (if any) stored at this vertex.
     */
    public Piece getPiece(){return pieceAtVertex;}

    public void placePiece(Piece newPiece){pieceAtVertex = newPiece;}
}
