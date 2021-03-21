package main.hashMap;

import main.hashTable.MyHashTable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

class MyHashMap<K, V> implements Map<K, V> {
    private MyHashTable hashTable;

    MyHashMap() {
        hashTable = new MyHashTable();
    }

    MyHashMap(int startCapacity) {
        hashTable = new MyHashTable(startCapacity);
    }

    public int size() {
        return hashTable.size();
    }

    public boolean isEmpty() {
        return hashTable.isEmpty();
    }

    public boolean containsKey(Object key) {
        return hashTable.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return hashTable.containsValue(value);
    }

    public V get(Object key) {
        return (V) hashTable.get(key);
    }

    public V put(Object key, Object value) {
        return (V) hashTable.put(key, value);
    }

    public V remove(Object key) {
        return (V) hashTable.remove(key);
    }

    public void putAll(Map m) {
        m.forEach((key, value) -> hashTable.put(key, value));
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Set keySet() {
        throw new UnsupportedOperationException();
    }

    public Collection values() {
        throw new UnsupportedOperationException();
    }

    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }
}
