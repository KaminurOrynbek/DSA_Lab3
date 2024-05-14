package org.example;

import java.util.Iterator;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size;

    public BST() {
        size = 0;
    }

    public int size() {
        return size;
    }

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value; // update value if key already exists
        }
        return node;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;

            Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
            size--;
        }
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    public Iterable<K> iterator() {
        CustomArrayList<K> keys = new CustomArrayList<>();
        inorder(root, keys);
        return keys;
    }

    private void inorder(Node node, CustomArrayList<K> keys) {
        if (node == null) return;
        inorder(node.left, keys);
        keys.add(node.key);
        inorder(node.right, keys);
    }

    private class CustomArrayList<T> implements Iterable<T> {
        private Object[] array;
        private int size;
        private static final int DEFAULT_CAPACITY = 10;

        public CustomArrayList() {
            array = new Object[DEFAULT_CAPACITY];
            size = 0;
        }

        public void add(T item) {
            if (size == array.length) {
                Object[] newArray = new Object[array.length * 2];
                System.arraycopy(array, 0, newArray, 0, array.length);
                array = newArray;
            }
            array[size++] = item;
        }

        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private int currentIndex = 0;

                public boolean hasNext() {
                    return currentIndex < size && array[currentIndex] != null;
                }
                public T next() {
                    return (T) array[currentIndex++];
                }

                public void remove() {
                    // Removing elements is not supported in this implementation
                }
            };
        }
    }
}