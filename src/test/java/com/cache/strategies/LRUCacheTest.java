package com.cache.strategies;

import com.cache.TwoLevelCache;
import org.junit.After;
import org.junit.Test;

import java.util.stream.IntStream;

import static com.cache.strategies.StrategyType.LRU;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LRUCacheTest {
    private TwoLevelCache<Integer, String> twoLevelCache;

    @After
    public void clearCache() {
        twoLevelCache.clearCache();
    }

    @Test
    public void shouldMoveObjectFromCacheTest() {
        twoLevelCache = new TwoLevelCache<>(2, 2, LRU);

        // i=0 - Least Recently Used - will be removed
        IntStream.range(0, 4).forEach(i -> {
            twoLevelCache.putToCache(i, "String " + i);
            assertTrue(twoLevelCache.isObjectPresent(i));
            twoLevelCache.getFromCache(i);
        });

        twoLevelCache.putToCache(4, "String 4");

        assertFalse(twoLevelCache.isObjectPresent(0)); //Least Recently Used - has been removed
        assertTrue(twoLevelCache.isObjectPresent(1));
        assertTrue(twoLevelCache.isObjectPresent(2));
        assertTrue(twoLevelCache.isObjectPresent(3));
        assertTrue(twoLevelCache.isObjectPresent(4));
    }
}
