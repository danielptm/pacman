package com.danielptuttle.pacman.model.barrier;

public class WallRoot {
    private int centerPoint;
    private int numWallUnits;

    private WallNode topNode;
    private WallNode rightNode;
    private WallNode bottomNode;
    private WallNode leftNode;

    public WallRoot(int centerPoint) {
        this.centerPoint = centerPoint;
    }

    public WallRoot(int centerPoint, int numWallUnits) {
        this.centerPoint = centerPoint;
        this.numWallUnits = numWallUnits;
    }

    public WallNode getTopNode() {
        return topNode;
    }

    public void setTopNode(WallNode topNode) {
        this.topNode = topNode;
    }

    public WallNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(WallNode rightNode) {
        this.rightNode = rightNode;
    }

    public WallNode getBottomNode() {
        return bottomNode;
    }

    public void setBottomNode(WallNode bottomNode) {
        this.bottomNode = bottomNode;
    }

    public WallNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(WallNode leftNode) {
        this.leftNode = leftNode;
    }
}
