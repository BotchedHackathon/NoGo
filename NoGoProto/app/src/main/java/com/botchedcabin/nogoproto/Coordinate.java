package com.botchedcabin.nogoproto;

/**
 * Storage for references to coordinates of node one level up.
 * [x,y] = [-1,-1] indicates the node has no parents.
 * x is row coordinate and y is column coordinate
 *
 * Created by Michael Nip on 1/31/2015.
 */

public class Coordinate {
    // Stores a tuple of coordinate values.
    private int x;
    private int y;

    static final int defaultCoord = -1;

    /**
    * Default constructor.  Sets node to top of tree.
    */
    public Coordinate(){ setCoordinate(defaultCoord,defaultCoord); }

    /**
     * More elaborate constructor.  Sets parent node with coordinate [x1,y1]
     */
    public Coordinate(int x1, int y1){ setCoordinate(x1,y1); }


    /**
     * Set parent to [x1,y1]
     */
    public void setCoordinate(int x1, int y1){
        x = x1;
        y = y1;
    }

    /**
     * Fetch x or y coordinate of parent node
     */
    public int getXCoordinate(){
        return x;
    }

    public int getYCoordinate(){
        return y;
    }
}
