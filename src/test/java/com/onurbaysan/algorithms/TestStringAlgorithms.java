package com.onurbaysan.algorithms;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by stall10n on 27.02.2017.
 */
public class TestStringAlgorithms
{
    @Test
    public void testPermute()
    {
        String word = "abcd";
        Set<String> allPermutations = StringAlgorithms.getAllPermutations(word);

        assertNotNull(allPermutations);
        assertEquals(allPermutations.size(), 24);

        assertTrue(allPermutations.contains("abdc"));
        assertTrue(allPermutations.contains("bacd"));
        assertTrue(allPermutations.contains("cdba"));
        assertTrue(allPermutations.contains("dcba"));
    }
}
