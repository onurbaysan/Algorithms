package com.onurbaysan.datastructures;

import java.util.*;

/**
 * Created by stall10n on 7.02.2017.
 */
public class DirectedWeightedGraph
{
    private Map<GraphNode, List<WeightedEdge>> neighborMap;
    private int vertices;

    public DirectedWeightedGraph(int vertices)
    {
        this.vertices = vertices;
        neighborMap = new HashMap<GraphNode, List<WeightedEdge>>(vertices);
    }

    public void addEdge(GraphNode from, GraphNode to, int distance)
    {
        if (!neighborMap.containsKey(from))
        {
            neighborMap.put(from, new ArrayList<WeightedEdge>());
        }

        if (!neighborMap.containsKey(to))
        {
            neighborMap.put(to, new ArrayList<WeightedEdge>());
        }

        WeightedEdge weightedEdge = new WeightedEdge(from, to, distance);
        neighborMap.get(from).add(weightedEdge);
    }

    public List<GraphNode> getNeighbors(GraphNode GraphNode)
    {
        List<GraphNode> neighborList = new ArrayList<GraphNode>();
        List<WeightedEdge> weightedEdges = neighborMap.get(GraphNode);

        for (WeightedEdge weightedEdge : weightedEdges)
        {
            neighborList.add(weightedEdge.getTo());
        }

        return neighborList;
    }

    /**
     * Returns null if there is no edge between two GraphNodes
     * @param from
     * @param to
     * @return
     */
    public WeightedEdge getEdge(GraphNode from, GraphNode to)
    {
        List<WeightedEdge> edges = neighborMap.get(from);

        for (WeightedEdge edge : edges)
        {
            if (edge.getTo().equals(to))
            {
                return edge;
            }
        }

        return null;
    }

    public List<WeightedEdge> getEdges(GraphNode GraphNode)
    {
        return neighborMap.get(GraphNode);
    }

    public List<GraphNode> getNodes()
    {
        return new ArrayList<GraphNode>(neighborMap.keySet());
    }

    public void printGraph()
    {
        for (GraphNode GraphNode : neighborMap.keySet())
        {
            System.out.print(GraphNode.getIdentifier() + " => ");

            List<WeightedEdge> edges = neighborMap.get(GraphNode);

            for (WeightedEdge edge : edges)
            {
                System.out.print(edge.getTo().getIdentifier() + " (" + edge.getDistance() + ") ");
            }

            System.out.println();
        }
    }

    public int getNodeCount()
    {
        return neighborMap.keySet().size();
    }
}
