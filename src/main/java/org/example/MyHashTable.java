package org.example;

public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next; // helps when collision occurs

        // constructor of HashNode
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M; // default capacity M = 11
    private int size; // number of HashNodes

    public int getSizeOfArray(int i){
        return chainArray.length;
    }

    // default constructor of MyHashTable with no parameter
    public MyHashTable() {
        this(11);
    }

    // constructor of MyHashTable
    // @param: int M -> user entered capacity
    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M]; // creating new instance of HashNode by array with size M
        this.size = 0; // at first our number of HashNode will be 0, because we don't have inserted key,value pair yet
    }

    // my implemented hash function that returns chainArray index of our HashNode
    // @param: K (generic type) key
    // @return: int
    public int hash(K key) {
        return key.toString().length() % M; // our key's type is generic and that's why we need toString func to access length of key
    }

    // insertion new key, value pair with addFirst method
    // @param: K key, V value
    // @return: no return type;
    public void put(K key, V value) {
        if(key == null || value == null) {
            throw new IllegalArgumentException("Key or Value is null !!!");
        }

        int chainArrayIndex = hash(key); // receiving index in our array
        HashNode<K, V> head = chainArray[chainArrayIndex]; // head of chain of HashNodes is first node
        while(head != null) {
            if(head.key.equals(key)) { // if head.key equals inserted key I'm simply updating value
                head.value = value;
                return; // if it equals we stop our while loop
            }
            head = head.next; // if it is not equal we are searching head.next -> null to place our node
        }
        head = chainArray[chainArrayIndex]; // we are saying to our prev node be a head
        HashNode node = new HashNode(key, value); // creating new node
        node.next = head; // we are placing our prev node next to new node
        chainArray[chainArrayIndex] = node; // and now our first node of chainArray is new node
        size++; // our number of HashNodes incremented
    }

    // this function gets value by key from chainArray
    // @param: K key
    // @return: V value
    public V get(K key) {
        if(key == null) {
            throw new IllegalArgumentException("Key is null !!!");
        }

        int chainArrayIndex = hash(key);
        HashNode<K, V> head = chainArray[chainArrayIndex];
        while(head != null) {
            if(head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key) {
        if(key == null) {
            throw new IllegalArgumentException("Key is null !!!");
        }

        int chainArrayIndex = hash(key);
        HashNode<K, V> head = chainArray[chainArrayIndex];
        HashNode<K, V> prev = null;
        while(head != null) {
            if(head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }
        if(prev != null){
            prev.next = head.next;
        } else {
            chainArray[chainArrayIndex] = head.next;
        }
        return head.value;
    }

    // checks whether chainArray is empty or not
    // @param: V value
    // @return: true or false
    public boolean contains(V value) {
        return size == 0;
    }

    // gets key of HasNode by value
    // @param: V value
    // @return: K key
    public K getKey(V value) {
        for (HashNode<K, V> chain : chainArray) {
            HashNode<K, V> current = chain;
            while(current != null) {
                if(current.value.equals(value)) {
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;
    }
}
