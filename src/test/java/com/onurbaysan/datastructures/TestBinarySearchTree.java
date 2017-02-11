package com.onurbaysan.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by stall10n on 9.02.2017.
 */
public class TestBinarySearchTree
{
    private TreeNode root;
    private BinarySearchTree bst;

    @Before
    public void initializeTree()
    {
        root = new TreeNode(10);

        bst = new BinarySearchTree(root);
        bst.insertNode(5);
        bst.insertNode(3);
        bst.insertNode(7);
        bst.insertNode(12);
        bst.insertNode(11);
    }

    @Test
    public void testChildCount()
    {
        assertEquals(6, bst.getChildCount(root));
    }

    @Test
    public void testInsertNodeToBST()
    {
        assertEquals(bst.getChildCount(root), 6);
        bst.insertNode(16);
        assertEquals(7, bst.getChildCount(root));
    }

    @Test
    public void testFindNodeRecursively()
    {
        TreeNode node = bst.findNodeRecursive(root, 7);
        assertNotNull(node);
        assertEquals(7, node.getValue());
    }

    @Test
    public void testFindNodeNegative()
    {
        TreeNode node = bst.findNodeRecursive(root, 13);
        assertNull(node);
    }

    @Test
    public void testFindNodeIteratively()
    {
        TreeNode node = bst.findNode(7);
        assertNotNull(node);
        assertEquals(7, node.getValue());
    }

    @Test
    public void testFindNodeInSubtreeIteratively()
    {
        TreeNode subTreeRoot = bst.findNode(5);
        assertNotNull(subTreeRoot);
        assertEquals(5, subTreeRoot.getValue());

        TreeNode node = bst.findNode(subTreeRoot, 7);
        assertNotNull(node);
        assertEquals(7, node.getValue());
    }


    @Test
    public void testGetMinimum()
    {
        TreeNode minimumNode = bst.getMinimumNode();
        assertNotNull(minimumNode);
        assertEquals(3, minimumNode.getValue());
    }

    @Test
    public void testGetMaximum()
    {
        TreeNode maximumNode = bst.getMaximumNode();
        assertNotNull(maximumNode);
        assertEquals(12, maximumNode.getValue());
    }

    @Test
    public void testParent()
    {
        TreeNode parent = bst.getParent(3);
        assertNotNull(parent);
        assertEquals(5, parent.getValue());
    }

    @Test
    public void testParentRoot()
    {
        TreeNode parent = bst.getParent(10);
        assertNull(parent);
    }

    @Test
    public void testSuccessor()
    {
        TreeNode successor = bst.getSuccessor(bst.findNode(7));
        assertNotNull(successor);
        assertEquals(10, successor.getValue());
    }

    @Test
    public void testSuccessorRoot()
    {
        TreeNode successor = bst.getSuccessor(root);
        assertNotNull(successor);
        assertEquals(11, successor.getValue());
    }

    @Test
    public void testPredecessor()
    {
        TreeNode predecessor = bst.getPredecessor(bst.findNode(11));
        assertNotNull(predecessor);
        assertEquals(10, predecessor.getValue());
    }

    @Test
    public void testPredecessorRoot()
    {
        TreeNode predecessor = bst.getPredecessor(root);
        assertNotNull(predecessor);
        assertEquals(7, predecessor.getValue());
    }

}
