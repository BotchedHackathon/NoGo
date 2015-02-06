package com.botchedcabin.nogoproto;

/** Generic Game Piece Class
 * Created by Michael Nip on 2/5/2015.
 */
public class Piece {
    protected Color pieceColor;

    /**
     * Constructor for Piece Object
     */
    Piece(){
    }

    Piece(Color pieceColor){
        this.pieceColor = pieceColor;
    }

    public Color getColor(){
        return pieceColor;
    }

}
