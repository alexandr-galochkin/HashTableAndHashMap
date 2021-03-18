package main.hashMap;

import main.hashTable.MyHashTable;
import org.junit.Assert;
import org.junit.Test;

public class MyHashMapTest {
    @Test
    public void put() {
        MyHashMap<Integer, String> testMap = new MyHashMap<Integer, String>();
        Assert.assertEquals("1", testMap.put(1, "1"));
        Assert.assertEquals("a", testMap.put(4, "a"));
        MyHashMap<Integer, Integer> testMap1 = new MyHashMap<Integer, Integer>();
        for (Integer i = 1; i <= 33; i++){
            Assert.assertEquals(i, testMap1.put(i, i));
        }
    }

    @Test
    public void size() {
        MyHashMap<Integer, Integer> testMap = new MyHashMap<Integer, Integer>();
        Assert.assertEquals(0, testMap.size());
        testMap.put(1, 1);
        Assert.assertEquals(1, testMap.size());
        testMap.put(2, 1);
        Assert.assertEquals(2, testMap.size());
        testMap.remove(2);
        Assert.assertEquals(1, testMap.size());
    }

    @Test
    public void isEmpty() {
        MyHashMap<Integer, Integer> testMap = new MyHashMap<Integer, Integer>();
        Assert.assertTrue(testMap.isEmpty());
        testMap.put(1, 1);
        Assert.assertFalse(testMap.isEmpty());
    }

    @Test
    public void get() {
        MyHashMap<String, String> testMap = new MyHashMap<String, String>();
        testMap.put("1", "1");
        Assert.assertEquals("1", testMap.get("1"));
        Assert.assertNull(testMap.get("2"));
    }

    @Test
    public void containsKey() {
        MyHashMap<String, String> testMap = new MyHashMap<String, String>();
        testMap.put("1", "1");
        Assert.assertTrue(testMap.containsKey("1"));
        Assert.assertFalse(testMap.containsKey("2"));
    }

    @Test
    public void containsValue() {
        MyHashMap<String, String> testMap = new MyHashMap<String, String>();
        testMap.put("1", "1");
        Assert.assertTrue(testMap.containsValue("1"));
        Assert.assertFalse(testMap.containsValue("2"));
    }

    @Test
    public void remove() {
        MyHashMap<String, String> testMap = new MyHashMap<String, String>();
        testMap.put("1", "1");
        testMap.remove("2");
        Assert.assertTrue(testMap.containsValue("1"));
        Assert.assertFalse(testMap.isEmpty());
        testMap.remove("1");
        Assert.assertFalse(testMap.containsValue("1"));
        Assert.assertTrue(testMap.isEmpty());
    }
}
