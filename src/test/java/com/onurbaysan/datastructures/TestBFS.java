package com.onurbaysan.datastructures;

import com.onurbaysan.algorithms.BFS;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by stall10n on 12.02.2017.
 */
public class TestBFS
{
    private BFS bfs;
    private DirectedWeightedGraph weightedGraph;
    private GraphNode nodeA, nodeB, nodeC, nodeD, nodeE, nodeF, nodeG, nodeH;

    @Before
    public void initGraph()
    {
        bfs = new BFS();
        weightedGraph = new DirectedWeightedGraph(8);

        nodeA = new GraphNode("A", 1);
        nodeB = new GraphNode("B", 2);
        nodeC = new GraphNode("C", 3);
        nodeD = new GraphNode("D", 4);
        nodeE = new GraphNode("E", 5);
        nodeF = new GraphNode("F", 6);
        nodeG = new GraphNode("G", 7);
        nodeH = new GraphNode("H", 8);

        weightedGraph.addEdge(nodeA, nodeC, 10);
        weightedGraph.addEdge(nodeA, nodeB, 8);
        weightedGraph.addEdge(nodeC, nodeD, 5);
        weightedGraph.addEdge(nodeB, nodeE, 3);
        weightedGraph.addEdge(nodeB, nodeF, 7);
        weightedGraph.addEdge(nodeE, nodeG, 12);
        weightedGraph.addEdge(nodeE, nodeF, 9);
        weightedGraph.addEdge(nodeF, nodeG, 14);
        weightedGraph.addEdge(nodeF, nodeH, 2);
        weightedGraph.addEdge(nodeG, nodeH, 5);
    }

    @Test
    public void testBFS()
    {
        List<GraphNode> bfsTraversalList = bfs.getBFSTraversalList(weightedGraph, nodeA);

        assertEquals(8, bfsTraversalList.size());
        assertEquals(nodeA.getIdentifier(), bfsTraversalList.get(0).getIdentifier());
        assertEquals(nodeC.getIdentifier(), bfsTraversalList.get(1).getIdentifier());
        assertEquals(nodeB.getIdentifier(), bfsTraversalList.get(2).getIdentifier());
        assertEquals(nodeD.getIdentifier(), bfsTraversalList.get(3).getIdentifier());
        assertEquals(nodeE.getIdentifier(), bfsTraversalList.get(4).getIdentifier());
        assertEquals(nodeF.getIdentifier(), bfsTraversalList.get(5).getIdentifier());
        assertEquals(nodeG.getIdentifier(), bfsTraversalList.get(6).getIdentifier());
        assertEquals(nodeH.getIdentifier(), bfsTraversalList.get(7).getIdentifier());
    }



}
