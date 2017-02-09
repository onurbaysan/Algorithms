package com.onurbaysan.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by stall10n on 7.02.2017.
 */
public class TestBasicGraph
{
    private BasicGraph graph;
    private GraphNode nodeA, nodeB, nodeC;

    @Before
    public void initGraph()
    {
        graph = new BasicGraph(3);

        nodeA = new GraphNode("A", 5);
        nodeB = new GraphNode("B", 12);
        nodeC = new GraphNode("C", 6);

        graph.addEdge(nodeA, nodeC);
        graph.addEdge(nodeC, nodeB);
    }

    @Test
    public void testNodeCount()
    {
        assertEquals(graph.getNodeCount(), 3);
    }

    @Test
    public void testContainsNeighbor()
    {
        assertTrue(graph.getNeighbors(nodeA).contains(nodeC));
        assertFalse(graph.getNeighbors(nodeA).contains(nodeB));
    }
}
