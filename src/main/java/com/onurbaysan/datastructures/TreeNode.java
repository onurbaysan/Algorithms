package com.onurbaysan.datastructures;

/**
 * Created by stall10n on 9.02.2017.
 */
public class TreeNode
{
    private int value;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode (int value)
    {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
