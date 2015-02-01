package com.botchedcabin.nogoproto;

import java.io.*;

/**
 * Connected component data structure for NoGo.
 * Created by Michael Nip on 1/31/2015.
 */
public class ConnectedComponents {

    /**
     *
     */
    public int m_boardSize;
    public Coordinate[][] ComponentReferences;
    public int count;   // Number of connected components

    /**
     * Initialize an empty union-find data structure for a NoGo board.
     */
    public ConnectedComponents(int boardSize){
        count = (boardSize+2)^2;
        ComponentReferences = new Coordinate[m_boardSize+2][m_boardSize+2];
        for( int ii = 0; ii < boardSize+2; ii++){
            for( int jj = 0; jj < boardSize+2; jj++){
                ComponentReferences[ii][jj].setCoordinate(ii,jj);
                ComponentReferences[ii][jj].setSz(1);
            }
        }
    }

    /**
     * Returns the number of components
     */
    public int count(){
        return count;
    }

    /**
     * Returns the coordinate identifier for the component containing site (x,y)
     * @param x the integer representing x coordinate
     * @param y the integer representing y coordinate
     * @return the coordinate identifier for the component containing site (x,y)
     */
    public Coordinate find(int x, int y){
        while (x != ComponentReferences[x][y].getXCoordinate() || y != ComponentReferences[x][y].getYCoordinate()){
            x = ComponentReferences[x][y].getXCoordinate();
            y = ComponentReferences[x][y].getYCoordinate();
        }
        return ComponentReferences[x][y];
    }

    /**
     * Checks if two sites belong to the same connected component.
     * @param x1 x-coordinate of first site
     * @param y1 y-coordinate of first site
     * @param x2 x-coordinate of second site
     * @param y2 y-coordinate of second site
     * @return true if both sites are in same component, false if not
     */
    public boolean connected(int x1, int y1, int x2, int y2) {
        return find(x1,y1) == find(x2,y2);
    }

    /**
     * Combines connected components of
     * @param x1 is the x coordinate of the first node
     * @param y1 is the y coordinate of the second node
     * @param x2 is the x coordinate of the first node
     * @param y2 is the coordinate of the second node
     */
    public void union(int x1, int y1, int x2, int y2) {

        Coordinate root1 = find(x1,y1);
        Coordinate root2 = find(x2,y2);
        if (root1 == root2) return;

        // make smaller root point to larger one
        if (root1.getSz() < root2.getSz()) {
            ComponentReferences[root1.getXCoordinate()][root1.getYCoordinate()].setCoordinate(root2.getXCoordinate(), root2.getYCoordinate());
            ComponentReferences[root2.getXCoordinate()][root2.getYCoordinate()].setSz(ComponentReferences[root1.getXCoordinate()][root1.getYCoordinate()].getSz() + ComponentReferences[root2.getXCoordinate()][root2.getYCoordinate()].getSz());
        }else {
            ComponentReferences[root2.getXCoordinate()][root2.getYCoordinate()].setCoordinate(root1.getXCoordinate(), root1.getYCoordinate());
            ComponentReferences[root1.getXCoordinate()][root1.getYCoordinate()].setSz(ComponentReferences[root1.getXCoordinate()][root1.getYCoordinate()].getSz() + ComponentReferences[root2.getXCoordinate()][root2.getYCoordinate()].getSz());
        }
        count--;

    }



}

class ConnectedComponentsTest{
    public static void main(String[] args) {
        int boardSize = 9;

        //ConnectedComponents graph = new ConnectedComponents(boardSize);
/**
 *     for(int ii = 0; ii < boardSize+2; ii++){
 *        for(int jj = 0; jj < boardSize+2; jj++){
 *            System.out.println("Root Node: (" + graph.ComponentReferences[ii][jj].getXCoordinate() + ","+ graph.ComponentReferences[ii][jj].getYCoordinate() + ")");
 *            System.out.println("Number of Elements in Subtree: " + graph.ComponentReferences[ii][jj].getSz());
 *
 *           }
 *      }
 */   }
}