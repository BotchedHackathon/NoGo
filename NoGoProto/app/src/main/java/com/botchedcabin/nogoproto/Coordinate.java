package com.botchedcabin.nogoproto;

/**
 * Storage for references to coordinates of node one level up.
 * [x,y] = [-1,-1] indicates the node has no parents.
 * x is row coordinate and y is column coordinate
 *
 * Created by Michael Nip on 1/31/2015.
 */

public class Coordinate {
    // Stores a tuple of coordinate values, and depth of subtree rooted at current node.
    private int x;
    private int y;
    private int depth;

    static final int defaultCoord = -1;
    static final int defaultDepth = 0;

    /**
    * Default constructor.  Sets node to top of tree.
    */
    public Coordinate(){ setCoordinate(defaultCoord,defaultCoord); setDepth(defaultDepth);}


    /**
     * Set parent to [x1,y1]
     */
    public void setCoordinate(int x1, int y1){
        x = x1;
        y = y1;
    }

    /**
     * Set depth of subtree rooted at parent node to depth1.
     */
    public void setDepth(int depth1){
        depth = depth1;
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

    public int getDepth(){
        return depth;
    }
}
