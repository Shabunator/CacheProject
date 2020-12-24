package com.cache.strategies;


/**
 * Стратегия LFU - Least Frequently Used (пер. Наименее часто используемый)
 * Частота использования определяется по счетчику frequency
 */

public class LFUStrategy<K> extends CacheStrategy<K> {
    @Override
    public void putObject(K key) {
        long frequency = 1;
        if (getObjectsStorage().containsKey(key)) {
            frequency = getObjectsStorage().get(key) + 1;
        }
        getObjectsStorage().put(key, frequency);
    }
}
