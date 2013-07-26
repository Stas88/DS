package com.example.datastructures;

import java.util.TreeMap;


/**
 * Created by stanislavsikorsyi on 08.07.13.
 */
public class Treemap {



    private TreeMap map;

    public Treemap() {
        map = new TreeMap();
    }

    public long fill(int size) {
        long start = System.nanoTime();
        for(int i = 0; i < size; i++) {
            map.put(i,""+i);
        }
        return  System.nanoTime() - start;
    }

    public <T> long  containsKey(int key) {
        long start = System.nanoTime();
        map.containsKey(key);
        return  System.nanoTime() - start;
    }


    public <T> long containsValue(String value) {
        long start = System.nanoTime();
        map.containsValue(value);
        return  System.nanoTime() - start;
    }

    public <T> long get(int key) {
        long start = System.nanoTime();
        Object o = map.get(key);
        return  System.nanoTime() - start;
    }

    public <T> long remove(int key) {
        long start = System.nanoTime();
        Object o = map.remove(key);
        return  System.nanoTime() - start;
    }
}
