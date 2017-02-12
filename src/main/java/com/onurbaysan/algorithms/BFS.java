package com.onurbaysan.algorithms;

import com.onurbaysan.datastructures.GraphNode;
import com.onurbaysan.datastructures.IGraph;

import java.util.*;

/**
 * Created by stall10n on 12.02.2017.
 */
public class BFS
{
    public List<GraphNode> getBFSTraversalList(IGraph graph, GraphNode startingNode)
    {
        List<GraphNode> bfsTraversalList = new ArrayList<GraphNode>();
        List<GraphNode> nodes = graph.getNodes();
        Map<GraphNode, Boolean> visitedMap = new HashMap();
        Queue<GraphNode> queue = new ArrayDeque<GraphNode>();

        for (GraphNode node : nodes) {
            visitedMap.put(node, false);
        }

        queue.add(startingNode);

        while (queue.size() != 0)
        {
            GraphNode poll = queue.poll();
            if (!visitedMap.get(poll))
            {
                visitedMap.put(poll, true);

                bfsTraversalList.add(poll);

                List<GraphNode> neighbors = graph.getNeighbors(poll);

                for (GraphNode neighbor : neighbors)
                {
                    queue.add(neighbor);
                }
            }
        }

        return bfsTraversalList;

    }
}
