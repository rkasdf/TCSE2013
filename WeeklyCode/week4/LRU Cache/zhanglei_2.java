/**
 * Map接口有四个实现类，分别是HashMap, HashTable, LinkedHashMap和TreeMap
 * public LinkedHashMap (int initialCapacity, float loadFactor, boolean accessOrder)
 * initialCapacity：初始容量；loadFactor：加载因子，一般是0.75f；accessOrder：false 基于插入顺序，true 基于访问顺序
 * removeEldestEntry方法提供在每次添加新条目时移除最旧条目，插入时调用
 */

import java.util.Map;
import java.util.LinkedHashMap;

public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(16, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = super.get(key);
        return value == null ? -1 : value;
    }

    public void set(int key, int value) {
        super.put(key, value);
    }

    public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
