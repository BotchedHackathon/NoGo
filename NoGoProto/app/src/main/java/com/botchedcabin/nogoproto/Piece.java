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

    public boolean equals(Piece p){
        return (pieceColor == p.pieceColor);
    }
}

class testPieceEquals {
    public static void main(String[] Args){
        Piece p1 = new Piece(Color.BLACK);
        Piece p2 = new Piece(Color.BLACK);
        Piece p3 = new Piece(Color.WHITE);
        Piece p4 = new Piece();
        Piece p5 = new Piece();

        System.out.println("p1 == p2: " + (p1.equals(p2)));
        System.out.println("p1 == p3: " + (p1.equals(p3)));
        System.out.println("p1 == p4: " + (p1.equals(p4)));
        System.out.println("p4 == p5: " + p4.equals(p5));
    }
}