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
        bst.insertNode(new TreeNode(5));
        bst.insertNode(new TreeNode(3));
        bst.insertNode(new TreeNode(7));
        bst.insertNode(new TreeNode(12));
        bst.insertNode(new TreeNode(11));
    }

    @Test
    public void testChildCount()
    {
        assertEquals(bst.getChildCount(root), 6);
    }

    @Test
    public void testInsertNodeToBST()
    {
        assertEquals(bst.getChildCount(root), 6);
        bst.insertNode(new TreeNode(16));
        assertEquals(bst.getChildCount(root), 7);
    }

    @Test
    public void testFindNode()
    {
        TreeNode node = bst.findNode(root, 7);
        assertNotNull(node);
        assertEquals(node.getValue(), 7);
    }

    @Test
    public void testFindNodeNegative()
    {
        TreeNode node = bst.findNode(root, 13);
        assertNull(node);
    }

}
