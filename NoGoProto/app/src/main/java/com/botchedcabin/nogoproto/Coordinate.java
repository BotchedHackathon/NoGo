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
     * Set parent to [x,y]
     */
    public void setCoordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Set size of subtree rooted at parent node to sz.
     */
    public void setSz(int sz){
        this.sz = sz;
    }

    /**
     * Fetch x or y coordinate of parent node or the depth of the subtree rooted at current node
     */
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getSz(){
        return sz;
    }

    /**
     * Print contents of Coordinate object for debugging purposes.
     */
    public void printContents(){
        System.out.println("Tree Root: (" + getX() + "," + getY() + "),");
        System.out.println("Subtree Size: " + getSz() + ",");
    }


    /**
     * Check if Coordinates share the same x,y references
     * @param other Another instance of a Coordinate object.
     * @return true if the references match
     */
    public boolean checkRefsEqual(Object other) {
        boolean result = false;
        if (other instanceof Coordinate) {
            Coordinate that = (Coordinate) other;
            result = (this.getX() == that.getX() && this.getX() == that.getY());
        }
        return result;
    }
}

class CoordinateTest{
    public static void main(String[] args){

        /**
         * Tests Constructor
         */
        System.out.println("Testing Constructor...");
        Coordinate aa = new Coordinate();
        aa.printContents();

        /**
         * Test Modifiers
         */
        System.out.println("Testing Modifiers...");
        aa.setCoordinate(5,5); aa.setSz(5);
        aa.printContents();

        /**
         * Test checkRefsEqual
         */
        Coordinate bb = new Coordinate();
        bb.setCoordinate(5,5);
        System.out.println("Testing checkRefsEqual..." + bb.checkRefsEqual(aa));

    }
}
