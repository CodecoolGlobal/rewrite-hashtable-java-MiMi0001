package com.codecool.hashtable;

import java.util.List;

public class HashTable <K, V>{

    // Number of all buckets - Do not modify!
    private final int bucketsSize = 16;

    private List<List<Entry>> buckets;

    private int getBucketIndexForKey(K key) {
        throw new RuntimeException("FIXME");
    }

    private List<Entry> getBucketAtIndex(int position) {
        throw new RuntimeException("FIXME");
    }

    private Entry findEntryInBucket(K key, List<Entry> bucket) {
        throw new RuntimeException("FIXME");
    }

    public V get(K key) {
        throw new RuntimeException("FIXME");
    }

    public void put(K key, V value) {
        throw new RuntimeException("FIXME");
    }

    public V remove(K key) {
        throw new RuntimeException("FIXME");
    }

    public void clear() {
        throw new RuntimeException("FIXME");
    }
}

class Entry <K, V> {

    public K key;
    public V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

}
