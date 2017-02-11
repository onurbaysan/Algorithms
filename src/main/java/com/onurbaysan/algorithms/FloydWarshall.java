package com.onurbaysan.algorithms;

import com.onurbaysan.datastructures.DirectedWeightedGraph;
import com.onurbaysan.datastructures.GraphNode;
import com.onurbaysan.datastructures.WeightedEdge;

import java.util.List;

/**
 * Created by stall10n on 7.02.2017.
 */
public class FloydWarshall
{
    public static double[][] findDistances(DirectedWeightedGraph weightedGraph)
    {
        int vertices = weightedGraph.getNodeCount();
        List<GraphNode> nodeList = weightedGraph.getNodes();
        double[][] distArr = new double[vertices][vertices];

        initializeDistanceArray(weightedGraph, vertices, nodeList, distArr);


        for (int k=0; k<vertices; k++)
        {
            for (int i=0; i<vertices; i++)
            {
                for (int j=0; j<vertices; j++)
                {
                    if (i != j && i != k && j != k)
                    {
                        distArr[i][j] = Math.min(distArr[i][j],
                                distArr[i][k] + distArr[k][j]);
                    }
                }
            }
        }

        return distArr;

    }

    private static void initializeDistanceArray(DirectedWeightedGraph weightedGraph,
                                                int vertices,
                                                List<GraphNode> nodeList,
                                                double[][] distArr)
    {
        for (int i=0; i<vertices; i++)
        {
            for (int j=0; j<vertices; j++)
            {
                if (i == j)
                {
                    distArr[i][j] = 0;
                }
                else
                {
                    WeightedEdge edge = weightedGraph.getEdge(nodeList.get(i), nodeList.get(j));

                    if (edge != null)
                    {
                        distArr[i][j] = edge.getDistance();
                    }
                    else
                    {
                        distArr[i][j] = Double.POSITIVE_INFINITY;
                    }
                }
            }
        }
    }

    public static void printDistances(DirectedWeightedGraph weightedGraph)
    {
        double[][] distances = findDistances(weightedGraph);
        int vertices = weightedGraph.getNodeCount();
        List<GraphNode> nodes = weightedGraph.getNodes();

        for (int i=0; i<vertices; i++)
        {
            System.out.print(nodes.get(i).getIdentifier() + " -> ");

            for (int j=0; j<vertices; j++)
            {
                System.out.print(nodes.get(j).getIdentifier() + " : " + distances[i][j] + " , ");
            }

            System.out.println();
        }
    }
}
