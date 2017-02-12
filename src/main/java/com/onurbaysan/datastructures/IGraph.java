package com.onurbaysan.datastructures;

import java.util.List;

/**
 * Created by stall10n on 12.02.2017.
 */
public interface IGraph
{
    List<GraphNode> getNeighbors(GraphNode node);

    List<GraphNode> getNodes();
}
