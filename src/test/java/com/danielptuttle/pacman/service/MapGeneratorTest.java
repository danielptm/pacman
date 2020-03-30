package com.danielptuttle.pacman.service;

import com.danielptuttle.pacman.model.barrier.WallNode;
import com.danielptuttle.pacman.model.barrier.WallRoot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapGeneratorTest {

    @Test
    public void testGenerateTopLine() {
        WallRoot wallRoot = new WallRoot(300);
        int num = 5;
        MapGenerator.createLineFromRoot(num, wallRoot, Direction.TOP);
        int itr = 0;
        WallNode wallNode = wallRoot.getTopNode();
        while (wallNode.getTop() != null) {
            wallNode = wallNode.getTop();
            itr++;
        }
        Assertions.assertEquals(5, itr);
    }
}
