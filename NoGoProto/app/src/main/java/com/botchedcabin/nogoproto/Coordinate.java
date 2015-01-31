package com.botchedcabin.nogoproto;

/**
 * Created by Michael Nip on 1/31/2015.
 */
public class Coordinate {
    // Stores a tuple of coordinate values.
    public int x;
    public int y;

    static final int defaultCoord = -1;

    /*
    * Constructor Methods
     */
    public Coordinate(int x1, int y1){ setCoordinate(x1,y1); }

    public Coordinate(){ setCoordinate(defaultCoord,defaultCoord); }

    public void setCoordinate(int x1, int y1){
        x = x1;
        y = y1;
    }

    public int getXCoordinate(){
        return x;
    }

    public int getYCoordinate(){
        return y;
    }
}
