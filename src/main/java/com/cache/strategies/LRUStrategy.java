package com.cache.strategies;

/**
 * LRU Strategy - Least Recently Used (пер. Наименее недавно используемый)
 * Определяется по времени с помощью System.nanoTime()
 */

public class LRUStrategy<K> extends CacheStrategy<K> {
    @Override
    public void putObject(K key) {
        getObjectsStorage().put(key, System.nanoTime());
    }
}
