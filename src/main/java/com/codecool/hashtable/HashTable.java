package com.codecool.hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class HashTable <K, V>{

    // Number of all buckets - Do not modify!
    private final int bucketsSize = 16;

    private List<List<Entry>> buckets;

    private void initBuckets() {
        buckets = new ArrayList<List<Entry>>();
    }
    private int getBucketIndexForKey(K key) {
        return key.toString().chars().sum() % bucketsSize; // toString then .chars converts to stream, than sums.
    }

    private List<Entry> getBucketAtIndex(int position) {
        return buckets.get(position);
    }

    private Entry findEntryInBucket(K key, List<Entry> bucket) {
        throw new RuntimeException("FIXME");
    }

    public V get(K key) {
        throw new RuntimeException("FIXME");
    }

    public void put(K key, V value) {
        if (buckets == null) initBuckets();
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
