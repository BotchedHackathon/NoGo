package com.botchedcabin.nogoproto;

/**
 * Storage for references to coordinates of node one level up.
 * [x,y] = [-1,-1] indicates the node has no parents.
 * x is row coordinate and y is column coordinate
 *
 * Created by Michael Nip on 1/31/2015.
 */

public class Coordinate {
    /**
     * Stores a tuple of coordinate values, and number of elements of subtree rooted at current node.
     */

    private int x;
    private int y;
    private int sz;

    static final int defaultCoord = -1;
    static final int defaultSz = 1;

    /**
    * Default constructor.  Sets node to top of tree.
    */
    public Coordinate(){ setCoordinate(defaultCoord,defaultCoord); setSz(defaultSz);}


    /**
     * Set parent to [x1,y1]
     */
    public void setCoordinate(int x1, int y1){
        x = x1;
        y = y1;
    }

    /**
     * Set size of subtree rooted at parent node to depth1.
     */
    public void setSz(int sz1){
        sz = sz1;
    }

    /**
     * Fetch x or y coordinate of parent node or the depth of the subtree rooted at current node
     */
    public int getXCoordinate(){
        return x;
    }

    public int getYCoordinate(){
        return y;
    }

    public int getSz(){
        return sz;
    }
}
