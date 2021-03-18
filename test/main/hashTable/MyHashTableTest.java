package main.hashTable;
import main.hashTable.MyHashTable;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class MyHashTableTest {
    @Test
    public void put() {
        MyHashTable<Integer, String> testTable = new MyHashTable<Integer, String>();
        Assert.assertEquals("1", testTable.put(1, "1"));
        Assert.assertEquals("a", testTable.put(4, "a"));
        MyHashTable<Integer, Integer> testTable1 = new MyHashTable<Integer, Integer>();
        for (Integer i = 1; i <= 33; i++){
            Assert.assertEquals(i, testTable1.put(i, i));
        }
    }

    @Test
    public void size() {
        MyHashTable<Integer, Integer> testTable = new MyHashTable<Integer, Integer>();
        Assert.assertEquals(0, testTable.size());
        testTable.put(1, 1);
        Assert.assertEquals(1, testTable.size());
        testTable.put(2, 1);
        Assert.assertEquals(2, testTable.size());
        testTable.remove(2);
        Assert.assertEquals(1, testTable.size());
    }

    @Test
    public void isEmpty() {
        MyHashTable<Integer, Integer> testTable = new MyHashTable<Integer, Integer>();
        Assert.assertTrue(testTable.isEmpty());
        testTable.put(1, 1);
        Assert.assertFalse(testTable.isEmpty());
    }

    @Test
    public void get() {
        MyHashTable<String, String> testTable = new MyHashTable<String, String>();
        testTable.put("1", "1");
        Assert.assertEquals("1", testTable.get("1"));
        Assert.assertNull(testTable.get("2"));
    }

    @Test
    public void containsKey() {
        MyHashTable<String, String> testTable = new MyHashTable<String, String>();
        testTable.put("1", "1");
        Assert.assertTrue(testTable.containsKey("1"));
        Assert.assertFalse(testTable.containsKey("2"));
    }

    @Test
    public void containsValue() {
        MyHashTable<String, String> testTable = new MyHashTable<String, String>();
        testTable.put("1", "1");
        Assert.assertTrue(testTable.containsValue("1"));
        Assert.assertFalse(testTable.containsValue("2"));
    }

    @Test
    public void remove() {
        MyHashTable<String, String> testTable = new MyHashTable<String, String>();
        testTable.put("1", "1");
        testTable.remove("2");
        Assert.assertTrue(testTable.containsValue("1"));
        Assert.assertFalse(testTable.isEmpty());
        testTable.remove("1");
        Assert.assertFalse(testTable.containsValue("1"));
        Assert.assertTrue(testTable.isEmpty());
    }

}
