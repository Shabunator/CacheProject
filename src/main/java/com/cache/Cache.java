package com.cache;

interface Cache<K, V> {
    void putToCache(K key, V value); // положить

    V getFromCache(K key); // получить

    void removeFromCache(K key); // удалить

    int getCacheSize(); // размер кэша

    boolean isObjectPresent(K key); // нахождение в кэше

    boolean hasEmptyPlace(); // место в кэше

    void clearCache(); // очистить кэш
}
