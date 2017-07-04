package com.onurbaysan.datastructures;

/**
 * Created by stall10n on 4.07.2017.
 */
 public class Trie
{
    private TrieNode rootNode;

    public Trie()
    {
        rootNode = new TrieNode('-');
    }

    public void insert(String word)
    {
        TrieNode tmp = rootNode;
        Character character;

        for (int i=0;i<word.length();i++)
        {
            character = word.charAt(i);
            Map<Character, TrieNode> childMap = tmp.getChildMap();

            if (childMap.containsKey(character))
            {
                tmp = childMap.get(character);
            }
            else
            {
                TrieNode trieNode = new TrieNode(character);
                trieNode.setParent(tmp);
                childMap.put(character, trieNode);
                tmp = trieNode;
            }
        }

        tmp.setEnd(true);
    }

    public TrieNode searchPrefix(String word)
    {
        TrieNode tmp = rootNode;
        Character character;

        for (int i=0;i<word.length();i++)
        {
            character = word.charAt(i);
            Map<Character, TrieNode> childMap = tmp.getChildMap();

            if (childMap.containsKey(character))
            {
                tmp = childMap.get(character);
            }
            else
            {
                return null;
            }
        }

        return tmp;
    }

    public boolean search(String word)
    {
        TrieNode trieNode = searchPrefix(word);

        if (trieNode != null && trieNode.isEnd())
        {
            return true;
        }

        return false;
    }

    public TrieNode getRootNode()
    {
        return rootNode;
    }

    public List<TrieNode> getNodes( TrieNode node)
    {
        ArrayList<TrieNode> nodeList = new ArrayList<>();

        if(node != null)
        {
            Set<TrieNode> visitedSet = new HashSet<>();
            Stack stack = new Stack();
            stack.push(node);

            while( stack.size() != 0 )
            {
                TrieNode tmp = (TrieNode) stack.pop();

                if( !visitedSet.contains(tmp) )
                {
                    visitedSet.add(tmp);

                    if(tmp != rootNode )
                    {
                        nodeList.add(tmp);
                    }

                    for( TrieNode prefixTreeNode : tmp.getChildMap().values() )
                    {
                        stack.push(prefixTreeNode);
                    }
                }
            }
        }

        return nodeList;
    }

    public List<TrieNode> getWords(TrieNode node)
    {
        ArrayList<TrieNode> nodeList = new ArrayList<>();

        if(node != null)
        {
            Set<TrieNode> visitedSet = new HashSet<>();
            Stack stack = new Stack();
            stack.push(node);

            while( stack.size() != 0 )
            {
                TrieNode tmp = (TrieNode) stack.pop();

                if( !visitedSet.contains(tmp) )
                {
                    visitedSet.add(tmp);

                    if (tmp.isEnd())
                    {
                        nodeList.add(tmp);
                    }

                    for( TrieNode trieNode : tmp.getChildMap().values() )
                    {
                        stack.push(trieNode);
                    }
                }
            }
        }

        return nodeList;
    }

    public void printSorted(TrieNode node, String s)
    {
        Map<Character, TrieNode> childMap = node.getChildMap();

        for( Character character : childMap.keySet() )
        {
            TrieNode trieNode = childMap.get(character);
            if (trieNode != null)
            {
                printSorted(trieNode, s + character);
            }
        }

        if (node.isEnd())
        {
            System.out.println(s);
        }
    }
}
