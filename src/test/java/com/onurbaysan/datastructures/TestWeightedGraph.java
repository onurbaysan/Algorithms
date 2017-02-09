package com.onurbaysan.datastructures;

import com.onurbaysan.algorithms.FloydWarshall;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by stall10n on 7.02.2017.
 */
public class TestWeightedGraph
{
    private DirectedWeightedGraph weightedGraph;
    private GraphNode GraphNodeA, GraphNodeB, GraphNodeC;

    @Before
    public void initGraph()
    {
        weightedGraph = new DirectedWeightedGraph(3);

        GraphNodeA = new GraphNode("A", 5);
        GraphNodeB = new GraphNode("B", 12);
        GraphNodeC = new GraphNode("C", 6);

        weightedGraph.addEdge(GraphNodeA, GraphNodeC, 10);
        weightedGraph.addEdge(GraphNodeC, GraphNodeB, 5);
    }

    @Test
    public void testGraphNodeCount()
    {
        assertEquals(weightedGraph.getNodeCount(), 3);
    }

    @Test
    public void testContainsNeighbor()
    {
        assertTrue(weightedGraph.getNeighbors(GraphNodeA).contains(GraphNodeC));
        assertFalse(weightedGraph.getNeighbors(GraphNodeA).contains(GraphNodeB));
    }

    @Test
    public void testDistance()
    {
        assertEquals(weightedGraph.getEdges(GraphNodeA).get(0).getDistance(), 10);
        assertEquals(weightedGraph.getEdges(GraphNodeC).get(0).getDistance(), 5);
    }

    @Test
    public void print()
    {
        weightedGraph.printGraph();
        FloydWarshall.printDistances(weightedGraph);
    }
}
