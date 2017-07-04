package com.onurbaysan.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by stall10n on 4.07.2017.
 */
public class TrieNode
{
    private Character value;
    private TrieNode parent;
    private boolean isEnd;

    private Map<Character, TrieNode> childMap;

    public TrieNode( Character value )
    {
        this.value = value;
        childMap = new HashMap<>();
    }

    public Character getValue()
    {
        return value;
    }

    public void setValue( Character value )
    {
        this.value = value;
    }

    public Map<Character, TrieNode> getChildMap()
    {
        return childMap;
    }

    public void setChildMap( Map<Character, TrieNode> childMap )
    {
        this.childMap = childMap;
    }

    public boolean isEnd()
    {
        return isEnd;
    }

    public void setEnd( boolean end )
    {
        isEnd = end;
    }

    public TrieNode getParent()
    {
        return parent;
    }

    public void setParent( TrieNode parent )
    {
        this.parent = parent;
    }
}
