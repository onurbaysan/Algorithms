package com.onurbaysan.datastructures;

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

    public void insertNode(TreeNode node)
    {
        if (node != null)
        {
            root = insertNode(root, node);
        }
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

    public TreeNode findNode(TreeNode rootNode, int value)
    {
        if(rootNode == null)
        {
            return null;
        }
        else
        {
            if (rootNode.getValue() > value)
            {
                return findNode(rootNode.getLeftChild(), value);
            }
            else if (rootNode.getValue() < value)
            {
                return findNode(rootNode.getRightChild(), value);
            }
        }

        return rootNode;

    }

    public void printPreorder(TreeNode rootNode)
    {
        if (rootNode != null)
        {
            printPreorder(rootNode.getLeftChild());
            System.out.println(rootNode.getValue() + " ");
            printPreorder(rootNode.getRightChild());
        }
    }

}
