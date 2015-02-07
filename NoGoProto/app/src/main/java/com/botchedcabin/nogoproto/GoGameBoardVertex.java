package com.botchedcabin.nogoproto;

import java.util.ArrayList;

/** GameBoardVertex class for the Go game
 * Created by Michael Nip on 2/6/2015.
 */
public class GoGameBoardVertex extends GameBoardVertex {
    private GoPiece pieceAtVertex;
    private ArrayList<GoGameBoardVertex> neighbors = new ArrayList<GoGameBoardVertex>();

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
}