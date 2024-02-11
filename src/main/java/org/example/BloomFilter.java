package org.example;

import java.util.BitSet;
import java.util.Random;

public class BloomFilter {
    private BitSet bitSet;
    private int size;
    private int[] hashSeeds;
    private int numHashFunctions;

    public BloomFilter(int size, int numHashFunctions) {
        this.size = size;
        this.numHashFunctions = numHashFunctions;
        this.bitSet = new BitSet(size);
        this.hashSeeds = new int[numHashFunctions];
        Random random = new Random();

        // Generate random hash seeds
        for (int i = 0; i < numHashFunctions; i++) {
            hashSeeds[i] = i+100;
        }
    }

    public void add(String element) {
        for (int i = 0; i < numHashFunctions; i++) {
            int hash = hash(element, hashSeeds[i]);
            int index = hash % size;
            if(index<0){
                index+=1000;
            }
            bitSet.set(index);
        }
    }

    public boolean contains(String element) {
        for (int i = 0; i < numHashFunctions; i++) {
            int hash = hash(element, hashSeeds[i]);
            System.out.println(hash);
            int index = hash % size;
            if (!bitSet.get(index)) {
                return false;
            }
        }
        return true;
    }

    private int hash(String element, int seed) {
        int hash = 0;
        for (int i = 0; i < element.length(); i++) {
            hash = seed * hash + element.charAt(i);
        }
        return hash;
    }
}
