package com.onurbaysan.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stall10n on 7.02.2017.
 */
public class BasicGraph
{
    private Map<GraphNode, List<GraphNode>> neighborMap;
    private int vertices;

    public BasicGraph(int vertices)
    {
        this.vertices = vertices;
        neighborMap = new HashMap<GraphNode, List<GraphNode>>(vertices);
    }

    public void addEdge(GraphNode from, GraphNode to)
    {
        if (!neighborMap.containsKey(from))
        {
            neighborMap.put(from, new ArrayList<GraphNode>());
        }

        if (!neighborMap.containsKey(to))
        {
            neighborMap.put(to, new ArrayList<GraphNode>());
        }

        neighborMap.get(from).add(to);
    }

    public List<GraphNode> getNeighbors(GraphNode GraphNode)
    {
        return neighborMap.get(GraphNode);
    }

    public void printGraph()
    {
        for (GraphNode GraphNode : neighborMap.keySet())
        {
            System.out.print(GraphNode.getIdentifier() + " => ");

            List<GraphNode> GraphNodes = neighborMap.get(GraphNode);

            for (GraphNode neighbor : GraphNodes) {
                System.out.print(neighbor.getIdentifier() + " ");
            }

            System.out.println();
        }
    }

    public int getNodeCount()
    {
        return neighborMap.keySet().size();
    }

}
