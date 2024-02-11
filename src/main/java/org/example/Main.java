package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter(1000, 3);

        bloomFilter.add("apple");
        bloomFilter.add("banana");
        bloomFilter.add("orange");

        System.out.println(bloomFilter.contains("Utkarsh"));   // true
        System.out.println(bloomFilter.contains("Raj"));  // true
        System.out.println(bloomFilter.contains("DemoCheck"));   // false

        }
    }