package org.example;

import java.util.Random;

public class MyHashTableTest {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();


        // Adding random 10000 elements to the hashtable
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(10000); // Random id
            MyTestingClass key = new MyTestingClass(id);
            Student student = new Student("Student " + i, 20 + random.nextInt(10)); // Random student
            table.put(key, student);
        }

        // Print number of elements in each bucket (chain or linkedlist)
        printBucketSizes(table);
    }

    private static void printBucketSizes(MyHashTable<MyTestingClass, Student> table) {
        int numBuckets = table.getSize(); // Using size() method instead of accessing chainArray directly
        for (int i = 0; i < numBuckets; i++) {
            int count = 0;
            MyHashTable<MyTestingClass, Student>.HashNode<MyTestingClass, Student> node = table.getChainArray()[i]; // Using getChainArray() method
            while (node != null) {
                count++;

            }
            System.out.println("Bucket " + i + ": " + count);
        }
    }

}
