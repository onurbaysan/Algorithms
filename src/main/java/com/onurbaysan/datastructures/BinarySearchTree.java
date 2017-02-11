package com.onurbaysan.datastructures;

import com.sun.deploy.panel.TreeBuilder;

import java.util.HashSet;

/**
 * Created by stall10n on 9.02.2017.
 */
public class BinarySearchTree
{

    private TreeNode root;

    public BinarySearchTree(TreeNode root)
    {
        this.root = root;
    }

    public TreeNode getRoot()
    {
        return root;
    }

    public void insertNode(int value)
    {
        root = insertNode(root, new TreeNode(value));
    }

    private TreeNode insertNode(TreeNode rootNode, TreeNode node)
    {
        if (rootNode == null)
        {
            rootNode = node;
        }
        else
        {
            if (rootNode.getValue() >= node.getValue())
            {
                rootNode.setLeftChild(insertNode(rootNode.getLeftChild(), node));
            }
            else
            {
                rootNode.setRightChild(insertNode(rootNode.getRightChild(), node));
            }
        }

        return rootNode;
    }
    

    public TreeNode getParent(int value)
    {
        TreeNode tmp = root;
        TreeNode parent = null;
        int nodeValue;

        while (tmp != null)
        {
            nodeValue = tmp.getValue();

            if (nodeValue == value)
            {
                return parent;
            }
            else if (nodeValue > value)
            {
                parent = tmp;
                tmp = tmp.getLeftChild();
            }
            else
            {
                parent = tmp;
                tmp = tmp.getRightChild();
            }
        }

        return null;
    }

    public TreeNode getSuccessor(TreeNode rootNode)
    {
        if (rootNode != null)
        {
            if (rootNode.getRightChild() != null)
            {
                return getMinimumNode(rootNode.getRightChild());
            }

            TreeNode parent = getParent(rootNode.getValue());

            while (parent != null
                    && parent.getValue() < rootNode.getValue())
            {
                parent = getParent(parent.getValue());
            }

            return parent;
        }

        return null;

    }

    public TreeNode getPredecessor(TreeNode rootNode)
    {
        if (rootNode != null)
        {
            if (rootNode.getLeftChild() != null)
            {
                return getMaximumNode(rootNode.getLeftChild());
            }

            TreeNode parent = getParent(rootNode.getValue());

            while (parent != null
                    && parent.getValue() > rootNode.getValue())
            {
                parent = getParent(parent.getValue());
            }

            return parent;
        }

        return null;
    }

    public int getChildCount(TreeNode node)
    {
        if (node == null)
        {
            return 0;
        }
        else if (node.getLeftChild() == null
                && node.getRightChild() == null)
        {
            return 1;
        }
        else
        {
            return getChildCount(node.getLeftChild()) + getChildCount(node.getRightChild()) + 1;
        }
    }

    public TreeNode findNodeRecursive(TreeNode rootNode, int value)
    {
        if(rootNode != null
                && rootNode.getValue() != value)
        {
            if (rootNode.getValue() > value)
            {
                return findNodeRecursive(rootNode.getLeftChild(), value);
            }
            else
            {
                return findNodeRecursive(rootNode.getRightChild(), value);
            }
        }

        return rootNode;

    }

    public TreeNode findNode(int value)
    {
        return findNode(root, value);
    }

    public TreeNode findNode(TreeNode rootNode, int value)
    {
        TreeNode tmp = rootNode;
        int nodeValue;

        while (tmp != null)
        {
            nodeValue = tmp.getValue();

            if (nodeValue == value)
            {
                return tmp;
            }
            else if (nodeValue > value)
            {
                tmp = tmp.getLeftChild();
            }
            else
            {
                tmp = tmp.getRightChild();
            }
        }

        return tmp;
    }

    public TreeNode getMinimumNode()
    {
        return getMinimumNode(root);
    }

    public TreeNode getMinimumNode(TreeNode rootNode)
    {
        TreeNode tmp = rootNode;

        while (tmp.getLeftChild() != null)
        {
            tmp = tmp.getLeftChild();
        }

        return tmp;
    }

    public TreeNode getMaximumNode()
    {
        return getMaximumNode(root);
    }

    public TreeNode getMaximumNode(TreeNode rootNode)
    {
        TreeNode tmp = rootNode;

        while (tmp.getRightChild() != null)
        {
            tmp = tmp.getRightChild();
        }

        return tmp;
    }

    public int lcaWithHashSet(int value1, int value2)
    {
        int value;
        int destValue = value2;

        TreeNode node1Parent = getParent(value1);
        TreeNode destParent;
        HashSet<Integer> node1ParentSet = new HashSet<Integer>();

        while (node1Parent != null)
        {
            value = node1Parent.getValue();

            node1ParentSet.add(value);
            node1Parent = getParent(value);
        }

        while (!node1ParentSet.contains(destValue))
        {
            destParent = getParent(destValue);

            if (destParent == null)
            {
                return root.getValue();
            }
            else
            {
                destValue = destParent.getValue();
            }
        }

        return destValue;
    }

    public int lcaWithoutExtraSpace(int value1, int value2)
    {
        TreeNode tmp = root;

        while (tmp != null)
        {
            if ((tmp.getValue() >= value1 && tmp.getValue() <= value2)
                    || (tmp.getValue() <= value1 && tmp.getValue() >= value2))
            {
                return tmp.getValue();
            }
            else if (tmp.getValue() > value1)
            {
                tmp = tmp.getLeftChild();
            }
            else
            {
                tmp = tmp.getRightChild();
            }
        }

        return root.getValue();
    }


    public void printInorder(TreeNode rootNode)
    {
        if (rootNode != null)
        {
            printInorder(rootNode.getLeftChild());
            System.out.println(rootNode.getValue() + " ");
            printInorder(rootNode.getRightChild());
        }
    }

}
