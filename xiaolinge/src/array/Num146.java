package array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by asia
 * @Classname Num146
 * @Description Num146
 * @Date 2024/9/26 11:38
 */
public class Num146 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

    }

}

class LRUCache {

    int size;
    int count;
    Deque<Integer> deque;
    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        size = capacity;
        deque = new ArrayDeque<>(capacity);
        count = 0;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            deque.remove(key);
            deque.addFirst(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (count < size) {
                ++count;
            } else {
                map.remove(deque.removeLast());
            }
            deque.addFirst(key);
        } else {
            deque.remove(key);
            deque.addFirst(key);
        }
        map.put(key, value);
    }
}