package com.datastructures.st;

import java.util.TreeSet;

/**
 * Created by stanislavsikorsyi on 08.07.13.
 */
public class Treeset {


    private TreeSet set;

    public Treeset() {
        set = new TreeSet();
    }

    public <T> long fill(int size) {
        long start = System.nanoTime();
        for(int i = 0; i < size; i++) {
            set.add(""+i);
        }
        return  System.nanoTime() - start;
    }

    public <T> long  contains(T key) {
        long start = System.nanoTime();
        set.contains(key);
        return  System.nanoTime() - start;
    }

    public <T> long  remove(T key) {
        long start = System.nanoTime();
        set.remove(key);
        return  System.nanoTime() - start;
    }
}
