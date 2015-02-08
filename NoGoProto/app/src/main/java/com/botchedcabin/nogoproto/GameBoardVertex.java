package com.botchedcabin.nogoproto;
import java.util.ArrayList;

/** GameBoardVertex.java
 * Implements vertex of GameBoard graph which stores the piece stored at the vertex and an ArrayList
 * of the neighbor vertices of this vertex.
 * Created by Michael Nip on 2/6/2015.
 */

public class GameBoardVertex {
    private Piece pieceAtVertex;
    private ArrayList<GameBoardVertex> neighbors = new ArrayList<GameBoardVertex>();

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

    /**
     * Places a piece at the vertex
     * @param newPiece piece to place
     */
    public void placePiece(Piece newPiece){pieceAtVertex = newPiece;}

    /**
     * Prints the instance variables of the vertex to the console
     */
    public void printContents(){
        System.out.println(this);
        System.out.println("Occupied by: " + pieceAtVertex + "\n Neighbors:" + neighbors);
    }

    /**
     * Checks if another vertex and this one contain the same kind of piece
     * @param p the vertex to compare with
     * @return true if they have the same kind of piece false if not
     */
    public boolean samePieceCheck(GameBoardVertex p){
        if (pieceAtVertex == null){
            if (p.getPiece() == null){
                return true;
            } else {
                return false;
            }
        } else {
            if (p.getPiece() == null) {
                return false;
            } else {
                return pieceAtVertex.equals(p.getPiece());
            }
        }
    }
}

class GameBoardVertexTest {
    public static void main(String[] args){
        GameBoardVertex testVertex = new GameBoardVertex();
        testVertex.printContents();
        testVertex.placePiece(new Piece(Color.WHITE));
        testVertex.addNeighbor(testVertex);
        testVertex.printContents();
    }
}

class GameBoardVertexSamePieceCheckTest{
    public static void main(String[] args){
        GameBoardVertex v1 = new GameBoardVertex(new Piece(Color.BLACK));
        GameBoardVertex v2 = new GameBoardVertex(new Piece(Color.BLACK));
        GameBoardVertex v3 = new GameBoardVertex(new Piece(Color.WHITE));
        GameBoardVertex v4 = new GameBoardVertex(new Piece());
        GameBoardVertex v5 = new GameBoardVertex();
        GameBoardVertex v6 = new GameBoardVertex();

        System.out.println("v1 == v2: " + v1.samePieceCheck(v2));
        System.out.println("v1 == v3: " + v1.samePieceCheck(v3));
        System.out.println("v1 == v4: " + v1.samePieceCheck(v4));
        System.out.println("v1 == v5: " + v1.samePieceCheck(v5));
        System.out.println("v5 == v6: " + v5.samePieceCheck(v6));
    }
}