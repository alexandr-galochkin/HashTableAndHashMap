package main.hashTable;

import java.util.Map;

public class MyHashTable<K, V> {
    private MyEntry<K, V>[] table;
    private int size;
    private int currentTableCapacity;
    private int startTableCapacity = 32;
    private int maxTableCapacity = Integer.MAX_VALUE - 8;

    public MyHashTable() {
        size = 0;
        currentTableCapacity = startTableCapacity;
        table = new MyEntry[startTableCapacity];
    }

    public MyHashTable(int startTableCapacity) {
        if (startTableCapacity < 0)
            throw new IllegalArgumentException("Ошибка:Размер таблицы не может быть отрицательным.");
        if (startTableCapacity > maxTableCapacity)
            throw new IllegalArgumentException("Ошибка: размер таблицы не может превышать " + maxTableCapacity);
        if (startTableCapacity == 0)
            startTableCapacity = 1;
        size = 0;
        currentTableCapacity = startTableCapacity;
        table = new MyEntry[startTableCapacity];
    }

    public V put(K key, V value) {
        size++;
        if (size >= currentTableCapacity / 2 && currentTableCapacity != maxTableCapacity) {
            recreateTable();
        }
        return putInTable(table, key, value);
    }

    public V get(Object key) {
        int hash = MyHashTable.hash(key) % table.length;
        for (MyEntry<K, V> currentEntry = table[hash]; currentEntry != null; currentEntry = currentEntry.next) {
            if (key.equals(currentEntry.getKey())) {
                return currentEntry.getValue();
            }
        }
        return null;
    }

    public boolean containsKey(Object key) {
        int hash = MyHashTable.hash(key) % table.length;
        for (MyEntry<K, V> currentEntry = table[hash]; currentEntry != null; currentEntry = currentEntry.next) {
            if (key.equals(currentEntry.getKey())) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object value) {
        for (MyEntry firstEntry : table) {
            for (MyEntry<K, V> currentEntry = firstEntry; currentEntry != null; currentEntry = currentEntry.next) {
                if (value.equals(currentEntry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size(){
        return size;
    }

    public V remove(Object key){
        int hash = MyHashTable.hash(key) % table.length;
        MyEntry<K, V> firstEntry = table[hash];
        if ((firstEntry != null) && (key.equals(firstEntry.getKey()))){
            table[hash] = firstEntry.next;
            size--;
            return firstEntry.getValue();
        }
        for (MyEntry<K, V> currentEntry = table[hash]; currentEntry != null; currentEntry = currentEntry.next) {
            MyEntry<K, V> nextEntry = currentEntry.next;
            if ((nextEntry != null) && (key.equals(nextEntry.getKey()))) {
                currentEntry.next = nextEntry.next;
                size--;
                return nextEntry.value;
            }
        }
        return null;
    }

    private V putInTable(MyEntry<K, V>[] table, K key, V value) {
        int hash = MyHashTable.hash(key) % table.length;
        if (table[hash] == null) {
            table[hash] = new MyEntry<K, V>(hash, key, value, null);
        } else {
            MyEntry<K, V> firstEntry = table[hash];
            table[hash] = new MyEntry<K, V>(hash, key, value, firstEntry);
        }
        return value;
    }

    private int recreateTable() {
        int newTableCapacity = maxTableCapacity / 2 > currentTableCapacity ? currentTableCapacity * 2 : maxTableCapacity;
        MyEntry<K, V>[] newTable = new MyEntry[newTableCapacity];
        for (int i = 0; i < currentTableCapacity; i++) {
            MyEntry<K, V> currentEntry = table[i];
            if (currentEntry != null) {
                this.putInTable(newTable, currentEntry.getKey(), currentEntry.getValue());
                MyEntry<K, V> nextEntry = currentEntry.next;
                while (nextEntry != null) {
                    this.putInTable(newTable, nextEntry.getKey(), nextEntry.getValue());
                    nextEntry = nextEntry.next;
                }
            }
        }
        table = newTable;
        currentTableCapacity = newTableCapacity;
        return newTableCapacity;
    }

    private static class MyEntry<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        MyEntry<K, V> next;


        MyEntry(int hash, K key, V value, MyEntry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            if (value == null) {
                throw new NullPointerException();
            }
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public boolean equals(Object o) {
            if (!(o instanceof MyEntry))
                return false;
            MyEntry<?, ?> e = (MyEntry<?, ?>) o;

            return (key == null ? e.getKey() == null : key.equals(e.getKey())) &&
                    (value == null ? e.getValue() == null : value.equals(e.getValue()));
        }

        public String toString() {
            return "Ключ: " + key.toString() + ", значение: " + value.toString();
        }
    }

    private static int hash(Object key) {
        return key == null ? 0 : key.hashCode();
    }
}
