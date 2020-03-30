package com.danielptuttle.pacman.model.barrier;

public class WallNode {
    private WallNode top;
    private WallNode right;
    private WallNode bottom;
    private WallNode left;

    public WallNode() {

    }

    public WallNode getTop() {
        return top;
    }

    public void setTop(WallNode top) {
        this.top = top;
    }

    public WallNode getRight() {
        return right;
    }

    public void setRight(WallNode right) {
        this.right = right;
    }

    public WallNode getBottom() {
        return bottom;
    }

    public void setBottom(WallNode bottom) {
        this.bottom = bottom;
    }

    public WallNode getLeft() {
        return left;
    }

    public void setLeft(WallNode left) {
        this.left = left;
    }
}
