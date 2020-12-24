package com.cache.strategies;

import lombok.Getter;

import java.util.Map;
import java.util.TreeMap;

@Getter
public abstract class CacheStrategy<K> {
    private final Map<K, Long> objectsStorage;
    private final TreeMap<K, Long> sortedObjectsStorage;

    CacheStrategy() {
        this.objectsStorage = new TreeMap<>();
        this.sortedObjectsStorage = new TreeMap<>(new ComparatorImpl<>(objectsStorage));
    }

    /**
     * Добавление
     * @param key - объект
     */
    public abstract void putObject(K key);

    /**
     * Удаление
     * @param key - ключ
     */
    public void removeObject(K key) {
        if (isObjectPresent(key)) {
            objectsStorage.remove(key);
        }
    }

    /**
     * Наличие объекта в харнилище
     * @param key - ключ
     * @return
     */
    public boolean isObjectPresent(K key) {
        return objectsStorage.containsKey(key);
    }

    /**
     * Получение
     * @return - возвращает ключ
     */
    public K getReplacedKey() {
        sortedObjectsStorage.putAll(objectsStorage);
        return sortedObjectsStorage.firstKey();
    }

    /**
     * Очистка хранилища
     */
    public void clear() {
        objectsStorage.clear();
    }
}
