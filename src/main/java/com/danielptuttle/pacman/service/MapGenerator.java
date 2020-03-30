package com.danielptuttle.pacman.service;

import com.danielptuttle.pacman.NodeDoesNotExist;
import com.danielptuttle.pacman.model.barrier.WallNode;
import com.danielptuttle.pacman.model.barrier.WallRoot;

public class MapGenerator {

    public static WallRoot createPlus() {
        WallRoot wallRoot = new WallRoot(300);
        int num = 5;
        createLineFromRoot(num, wallRoot, Direction.TOP);
        createLineFromRoot(num, wallRoot, Direction.RIGHT);
        createLineFromRoot(num, wallRoot, Direction.BOTTOM);
        createLineFromRoot(num, wallRoot, Direction.LEFT);
        return wallRoot;
    }

    public WallRoot createLShape() {
        return null;
    }

    public WallRoot createTShape() {
        return null;
    }

    public WallRoot createBox() {
        return null;
    }


    /**
     * @Return the WallNode at the designated position.
     * @param position - A formated string like so: "T:1,R:2,B:3,L:4". Means from the WallRoot, go 1 node up, 2 right, then 3 down from there ad then 4 to the left.
     * @throws NodeDoesNotExist
     */
    public static WallNode getNodeAtPosition(String position) throws NodeDoesNotExist {

        return null;
    }


    /**
     * Creates a line of nodes equal to the number and the direction that is passed in.
     * @param num
     * @param wallNode
     * @param direction
     */
    public static void createLineFromNode(int num, WallNode wallNode, Direction direction) {

    }

    /**
     * Creates a line of nodes from the root. This function fills the WallRoot with the number of items and in the direction.
     * @param num
     * @param wallRoot
     * @param direction
     */
    public static void createLineFromRoot(int num, WallRoot wallRoot, Direction direction) {
        wallRoot.setTopNode(new WallNode());
        switch (direction) {
            case TOP:
                WallNode currentTop = wallRoot.getTopNode();
                for (int i = 0; i < num; i++) {
                    currentTop.setTop(new WallNode());
                    currentTop = currentTop.getTop();
                }
                break;
            case RIGHT:
                WallNode currentRight = wallRoot.getRightNode();
                for (int i = 0; i < num; i++) {
                    currentRight.setRight(new WallNode());
                    currentRight = currentRight.getRight();
                }
                break;
            case BOTTOM:
                WallNode currentBottom = wallRoot.getBottomNode();
                for (int i = 0; i < num; i++) {
                    currentBottom.setBottom(new WallNode());
                    currentBottom = currentBottom.getBottom();
                }
                break;
            case LEFT:
                WallNode currentLeft = wallRoot.getLeftNode();
                for (int i = 0; i < num; i++) {
                    currentLeft.setLeft(new WallNode());
                    currentLeft = currentLeft.getLeft();
                }
                break;
        }
    }
}

enum Direction {
    TOP,
    RIGHT,
    BOTTOM,
    LEFT
}
