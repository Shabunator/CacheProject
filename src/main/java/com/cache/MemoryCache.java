package com.cache;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class MemoryCache<K extends Serializable, V extends Serializable> implements Cache<K, V> {
    private final Map<K, V> objectsStorage;
    private final int capacity;

    MemoryCache(int capacity) {
        this.capacity = capacity;
        this.objectsStorage = new ConcurrentHashMap<>(capacity);
    }
    // Получение
    @Override
    public V getFromCache(K key) {
        return objectsStorage.get(key);
    }

    // Добавление
    @Override
    public void putToCache(K key, V value) {
        objectsStorage.put(key, value);
    }

    // Удаление
    @Override
    public void removeFromCache(K key) {
        objectsStorage.remove(key);
    }

    // Узнать размер
    @Override
    public int getCacheSize() {
        return objectsStorage.size();
    }

    // Наличие объекта
    @Override
    public boolean isObjectPresent(K key) {
        return objectsStorage.containsKey(key);
    }

    // Наличие свободного места
    @Override
    public boolean hasEmptyPlace() {
        return getCacheSize() < this.capacity;
    }

    // Очистка
    @Override
    public void clearCache() {
        objectsStorage.clear();
    }
}
