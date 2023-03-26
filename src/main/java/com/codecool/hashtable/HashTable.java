package com.codecool.hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class HashTable <K, V>{

    // Number of all buckets
    private final int bucketsSize = 16;

    private List<List<Entry>> buckets;

    private void initBuckets() {
        buckets = new ArrayList<List<Entry>>();
    }

    private int getBucketIndexForKey(K key) {
        if (key == null) return 0;
        else return key.toString().chars().sum() % bucketsSize; // toString then .chars converts to stream, then sums.
    }

    private List<Entry> getBucketAtIndex(int position) {
        return buckets.get(position);
    }

    private Entry findEntryInBucket(K key, List<Entry> bucket) {
        return (Entry<K, V>) bucket.stream()
                .filter(checkEntry -> checkEntry.getKey()
                        .equals(key)).toArray()[0];
    }

    public V get(K key) {
        if (buckets == null) initBuckets();
        V out = null;
        if (buckets.size() != 0) {
            int bucketIndex = getBucketIndexForKey(key);
            List<Entry> bucket = buckets.get(bucketIndex);
            if (bucket != null) {
                try {
                    Entry<K, V> entry;
                    if (key == null) {
                        entry = (Entry<K, V>) bucket.stream().filter(checkEntry -> checkEntry.getKey() == (key)).toArray()[0];
                    }
                    else {
                        entry = (Entry<K, V>) bucket.stream().filter(checkEntry -> checkEntry.getKey().equals(key)).toArray()[0];
                    }
                    out = entry.getValue();
                } catch (NullPointerException e) {
                }
            }
        }
        return out;
    }

    public void put(K key, V value) {
        if (buckets == null) initBuckets();
        int bucketIndex = getBucketIndexForKey(key);
        try {
            List<Entry> bucket = getBucketAtIndex(bucketIndex);
            if (bucket == null) {
                bucket = new ArrayList<>();
                Entry<K,V> entry = new Entry<K, V>(key, value);
                bucket.add(entry);
                buckets.set(bucketIndex, bucket);
            }
            else {
                boolean foundKey = false;

                for (Entry entry: bucket) {
                    if (entry.getKey().equals(key)) {
                        entry.setValue(value);
                        foundKey = true;
                    }
                }

                if (!foundKey)  {
                    Entry<K,V> newEntry = new Entry<K, V>(key, value);
                    bucket.add(newEntry);
                }
            }
        }
        catch (IndexOutOfBoundsException e) {
            int toAdd = bucketIndex - (buckets.size() - 1);
            for (int i = 0; i < toAdd; i++) {
                buckets.add(null);
            }
            Entry<K, V> newEntry = new Entry<>(key, value);
            List<Entry> newBucket = new ArrayList<Entry>();
            newBucket.add(newEntry);
            buckets.set(bucketIndex, newBucket);
        }
    }

    public V remove(K key) {
        V out = null;
        int bucketIndex = getBucketIndexForKey(key);
        List<Entry> bucket = buckets.get(bucketIndex);
        Entry entry = findEntryInBucket(key, bucket);
        int entryIndex = bucket.indexOf(entry);
        if (entryIndex != -1) {
            out = (V)bucket.get(entryIndex).getValue();
            bucket.remove(entryIndex);
        }
        if (bucket.size() == 0) buckets.set(bucketIndex, null);
        return out;
    }

    public void clear() {
        initBuckets();
    }
}

class Entry <K, V> {

    public K key;
    public V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
