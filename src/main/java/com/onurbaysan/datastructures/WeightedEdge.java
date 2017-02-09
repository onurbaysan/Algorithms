package com.onurbaysan.datastructures;

/**
 * Created by stall10n on 7.02.2017.
 */
public class WeightedEdge
{
    private GraphNode from;
    private GraphNode to;
    private int distance;

    public WeightedEdge (GraphNode from, GraphNode to, int distance)
    {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public GraphNode getFrom() {
        return from;
    }

    public GraphNode getTo() {
        return to;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
