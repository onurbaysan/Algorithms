package com.onurbaysan.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by stall10n on 27.02.2017.
 */
public class StringAlgorithms
{
    private static Set<String> permutationSet = new HashSet<String>();

    public static Set<String> getAllPermutations(String originalStr)
    {
        permutationSet.clear();
        permutationUtil(originalStr, 0, originalStr.length() - 1);

        return permutationSet;
    }

    public static void permutationUtil(String word, int left, int right)
    {
        if (left == right)
        {
            permutationSet.add(word);
        }
        else
        {
            for (int i = left; i <= right; i++) {
                word = swap(word, i, left);
                permutationUtil(word, left + 1, right);
                word = swap(word, i, left);
            }
        }
    }

    private static String swap(String originalStr, int left, int right)
    {
        char[] charArray = originalStr.toCharArray();
        char tmp = charArray[left];
        charArray[left] = charArray[right];
        charArray[right] = tmp;

        return String.valueOf(charArray);
    }


}
