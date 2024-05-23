package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


public class BST<K extends Comparable<K>, V> implements Iterable<BST.Pair<K, V>> {
    private TreeNode root;
    private int size;

    private class TreeNode {
        private K key;
        private V value;
        private TreeNode left, right;

        public TreeNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Returns the number of nodes (key-value pairs) in the BST.
     *
     * @return the number of nodes in the BST
     */
    public int size() {
        return size;
    }

    /**
     * Inserts a new key-value pair or updates the value of an existing key in the BST.
     *
     * @param key the key to be inserted or updated in the BST
     * @param value the value associated with the key
     */
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    /**
     * Helper method to insert a new key-value pair or update the value of an existing key in the BST.
     *
     * @param root the current node in the recursion
     * @param key the key to be inserted or updated in the BST
     * @param value the value associated with the key
     * @return the updated tree node after the insertion or update
     */
    private TreeNode put(TreeNode root, K key, V value) {
        if (root == null) {
            size++;
            return new TreeNode(key, value);
        }
        int comp = key.compareTo(root.key);
        if (comp < 0) {
            root.left = put(root.left, key, value);
        } else if (comp > 0) {
            root.right = put(root.right, key, value);
        } else {
            root.value = value;
        }
        return root;
    }

    /**
     * Retrieves the value associated with the given key.
     *
     * @param key the key to be searched in the BST
     * @return the value associated with the key if found, otherwise null
     */
    public V get(K key) {
        return get(root, key);
    }

    /**
     * Helper method to retrieve the value associated with the given key.
     *
     * @param root the current node in the search
     * @param key the key to be searched in the BST
     * @return the value associated with the key if found, otherwise null
     */
    private V get(TreeNode root, K key) {
        while (root != null) {
            int comp = key.compareTo(root.key);
            if (comp < 0) {
                root = root.left;
            } else if (comp > 0) {
                root = root.right;
            } else {
                return root.value;
            }
        }
        return null;
    }

    /**
     * Deletes the node with the given key from the BST.
     *
     * @param key the key of the node to be deleted
     */
    public void delete(K key) {
        root = delete(root, key);
    }

    /**
     * Helper method to delete the node with the given key from the BST.
     *
     * @param root the current node in the deletion process
     * @param key the key of the node to be deleted
     * @return the updated tree node after the deletion
     */
    private TreeNode delete(TreeNode root, K key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            root.left = delete(root.left, key);
        } else if (cmp > 0) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode t = root;
            root = getMin(t.right);
            root.right = deleteMin(t.right);
            root.left = t.left;
        }
        return root;
    }

    /**
     * Retrieves the minimum node in the subtree rooted at the given node.
     *
     * @param root the root of the subtree
     * @return the minimum node in the subtree
     */
    private TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    /**
     * Deletes the minimum node in the subtree rooted at the given node.
     *
     * @param root the root of the subtree
     * @return the updated tree node after the deletion of the minimum node
     */
    private TreeNode deleteMin(TreeNode root) {
        if (root.left == null) return root.right;
        root.left = deleteMin(root.left);
        return root;
    }

    /**
     * Performs an in-order traversal and collects the keys in the BST.
     *
     * @return a list of keys in the BST
     */
    public List<K> keyIterator() {
        List<K> keys = new ArrayList<>();
        inOrderKey(root, keys);
        return keys;
    }

    /**
     * Helper method to perform an in-order traversal and collect the keys in the BST.
     *
     * @param root the current node in the traversal
     * @param keys the list to collect the keys
     */
    private void inOrderKey(TreeNode root, List<K> keys) {
        if (root == null) return;
        inOrderKey(root.left, keys);
        keys.add(root.key);
        inOrderKey(root.right, keys);
    }

    /**
     * Performs an in-order traversal and collects the values in the BST.
     *
     * @return a list of values in the BST
     */
    public List<V> valueIterator() {
        List<V> values = new ArrayList<>();
        inOrderValue(root, values);
        return values;
    }

    /**
     * Helper method to perform an in-order traversal and collect the values in the BST.
     *
     * @param root the current node in the traversal
     * @param values the list to collect the values
     */
    private void inOrderValue(TreeNode root, List<V> values) {
        if (root == null) return;
        inOrderValue(root.left, values);
        values.add(root.value);
        inOrderValue(root.right, values);
    }

    /**
     * Performs an in-order traversal and collects the key-value pairs in the BST.
     *
     * @return a list of key-value pairs in the BST
     */
    public List<Pair<K, V>> pairIterator() {
        List<Pair<K, V>> pairs = new ArrayList<>();
        inOrder(root, pairs);
        return pairs;
    }

    /**
     * Helper method to perform an in-order traversal and collect the key-value pairs in the BST.
     *
     * @param root the current node in the traversal
     * @param pairs the list to collect the key-value pairs
     */
    private void inOrder(TreeNode root, List<Pair<K, V>> pairs) {
        if (root == null) return;
        inOrder(root.left, pairs);
        pairs.add(new Pair<>(root.key, root.value));
        inOrder(root.right, pairs);
    }

    /**
     * Returns an iterator over the key-value pairs in the BST.
     *
     * @return an iterator over the key-value pairs in the BST
     */
    @Override
    public Iterator<Pair<K, V>> iterator() {
        return pairIterator().iterator();
    }

    /**
     * The Pair class represents a key-value pair.
     *
     * @param <K> the type of key
     * @param <V> the type of value
     */
    public static class Pair<K, V> {
        private final K key;  // The key of the pair
        private final V value; // The value of the pair

        /**
         * Constructor to initialize a new pair with the given key and value.
         *
         * @param key   the key of the pair
         * @param value the value of the pair
         */
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Returns the key of the pair.
         *
         * @return the key of the pair
         */
        public K getKey() {
            return key;
        }

        /**
         * Returns the value of the pair.
         *
         * @return the value of the pair
         */
        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "{" + "key=" + key + ", value=" + value + '}';
        }
    }

    public static void main(String[] args) {
        // Create a new BST
        BST<Integer, String> bst = new BST<>();

        // Insert some key-value pairs
        bst.put(5, "Apple");
        bst.put(3, "Banana");
        bst.put(7, "Orange");
        bst.put(2, "Grape");
        bst.put(4, "Mango");
        bst.put(6, "Pineapple");
        bst.put(8, "Peach");

        // Print the size of the BST
        System.out.println("Size of BST: " + bst.size());

        // Retrieve values for specific keys
        System.out.println("Value for key 3: " + bst.get(3));
        System.out.println("Value for key 7: " + bst.get(7));

        // Delete a key-value pair
        bst.delete(2);

        // Print the size of the BST after deletion
        System.out.println("Size of BST after deletion: " + bst.size());

        // Print all key-value pairs using an iterator
        System.out.println("Key-Value pairs:");
        for (BST.Pair<Integer, String> pair : bst) {
            System.out.println(pair);
        }
    }
}
