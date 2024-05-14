package org.example;

public class MyHashTable<K, V> {
    public class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return this.key;
        }
        public V getValue() {
            return this.value;
        }
        public void setValue(V value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;
    public HashNode<K, V>[] getChainArray() {
        return chainArray;
    }

    public int getSize() {
        return size;
    }

    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
    }

    private int hash(K key) {
        return key.toString().length() % M;
    }

    public void put(K key, V value) {
        int hash = hash(key);
        HashNode<K, V> node = chainArray[hash];

        if (node == null) {
            chainArray[hash] = new HashNode<K, V>(key, value);
        } else {
            while (node.next != null) { // key exists
                if (node.getKey() == key) {
                    node.setValue(value);
                    return;
                }
                node = node.next;
            }
            if (node.getKey() == key) { // key doesn't exist
                node.setValue(value);
                return;
            }
            node.next = new HashNode<K, V>(key, value);
        }
        size++; // Increment size after adding a new element
    }

    public V get(K key) {
        int hash = hash(key);
        HashNode<K, V> node = chainArray[hash];

        if (node == null) {
            return null;
        }
        while (node != null) {
            if (node.getKey() == key) {
                return node.getValue();
            }
            node = node.next;
        }
        return null;
    }

    public V remove(K key) {
        int hash = hash(key);
        HashNode<K, V> node = chainArray[hash];
        HashNode<K, V> prev = null;

        while (node != null) {
            if (node.getKey() == key) {
                if (prev == null) {
                    // If the node to be removed is the first node in the chain
                    chainArray[hash] = node.next;
                } else {
                    prev.next = node.next;
                }
                // Return the value of the removed node
                V removedValue = node.getValue();
                node.next = null; // Disconnect the removed node from the chain
                size--; // Update the size of the hash table
                return removedValue;
            }
            prev = node;
            node = node.next;
        }
        return null; // Key not found
    }


    public boolean contains(V value) {
        // Iterate over each chain in the hash table
        for (HashNode<K, V> chain : chainArray) {
            // Iterate over each node in the current chain
            HashNode<K, V> current = chain;
            while (current != null) {
                // Check if the current node's value matches the given value
                if (current.getValue().equals(value)) {
                    // If found, return true
                    return true;
                }
                // Move to the next node in the chain
                current = current.next;
            }
        }
        // If the value is not found in any chain, return false
        return false;
    }

    public K getKey(V value) {
        // Iterate over each chain in the hash table
        for (HashNode<K, V> chain : chainArray) {
            // Iterate over each node in the current chain
            HashNode<K, V> current = chain;
            while (current != null) {
                // Check if the current node's value matches the given value
                if (current.getValue().equals(value)) {
                    // If found, return the key of the current node
                    return current.getKey();
                }
                // Move to the next node in the chain
                current = current.next;
            }
        }
        // If the value is not found in any chain, return null
        return null;
    }
}
