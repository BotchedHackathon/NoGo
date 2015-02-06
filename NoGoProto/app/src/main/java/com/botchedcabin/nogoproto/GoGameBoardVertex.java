package com.botchedcabin.nogoproto;

import java.util.ArrayList;

/** GameBoardVertex class for the Go game
 * Created by Michael Nip on 2/6/2015.
 */
public class GoGameBoardVertex extends GameBoardVertex {
    private GoPiece pieceAtVertex;
    private ArrayList<GoGameBoardVertex> neighbors;

    /**
     * Default Constructor
     */
    GoGameBoardVertex(){}

    /**
     * Constructor for placing a piece but no neighboring vertices
     */
    GoGameBoardVertex(GoPiece pieceAtVertex){this.pieceAtVertex = pieceAtVertex;}

    /**
     * Constructor for specifying neighbors but no piece
     */
    GoGameBoardVertex(ArrayList<GoGameBoardVertex> neighbors){this.neighbors = neighbors;}

    /**
     * Constructor for specifying only a single neighbor
     */
    GoGameBoardVertex(GoGameBoardVertex neighbor){this.neighbors.add(neighbor);}

    /**
     * Constructor for specifying everything
     */
    GoGameBoardVertex(GoPiece pieceAtVertex, ArrayList<GoGameBoardVertex> neighbors){
        this.pieceAtVertex = pieceAtVertex;
        this.neighbors = neighbors;
    }

    /**
     * getNeighbors
     * @return neighbor vertices
     */
    public ArrayList<GameBoardVertex> getNeighbors(){
        ArrayList<GameBoardVertex> neighborsCopy = new ArrayList<GameBoardVertex>();
        for (int ii = 0; ii < neighbors.size(); ii++){
            neighborsCopy.add(neighbors.get(ii));
        }
        return neighborsCopy;}

    /**
     * getPiece
     * @return piece (if any) stored at this vertex.
     */
    public GoPiece getPiece(){return pieceAtVertex;}

    public void placePiece(GoPiece newPiece){pieceAtVertex = newPiece;}
}
