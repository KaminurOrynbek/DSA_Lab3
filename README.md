# MyHashTable

MyHashTable is a Java implementation of a hash table data structure with chaining for collision resolution.

## Overview

MyHashTable allows you to store key-value pairs and retrieve the values based on their keys. It handles collisions by chaining, where each bucket in the hash table holds a linked list of elements.

## Fields

- `chainArray`: An array of linked lists where each bucket stores elements with the same hash code.
- `M`: The capacity of the hash table.
- `size`: The number of elements stored in the hash table.

## Methods

- `public MyHashTable()`: Constructs a hash table with a default capacity of 11.
- `public MyHashTable(int M)`: Constructs a hash table with a specified capacity.
- `public void put(K key, V value)`: Inserts a key-value pair into the hash table.
- `public V get(K key)`: Retrieves the value associated with the specified key.
- `public V remove(K key)`: Removes the key-value pair with the specified key from the hash table.
- `public boolean contains(V value)`: Checks if the hash table contains the specified value.
- `public K getKey(V value)`: Retrieves the key associated with the specified value.

## Usage

```java
MyHashTable<String, Integer> hashTable = new MyHashTable<>();
hashTable.put("key1", 10);
hashTable.put("key2", 20);
int value = hashTable.get("key1"); // Retrieves 10
```
## Subjects Class

The `Subjects` class represents a subject with a unique subject ID.

### Fields
- `subjectId`: The unique identifier for the subject.

### Constructors
- `public Subjects(String subjectId)`: Constructs a `Subjects` object with the specified subject ID.

### Methods
- `public String getSubjectId()`: Returns the subject ID.
- `public void setSubjectId(String subjectId)`: Sets the subject ID.
- `@Override public boolean equals(Object obj)`: Compares this subject with another object for equality.
- `@Override public int hashCode()`: Generates a hash code for this subject.
- `@Override public String toString()`: Returns a string representation of the subject.

## Student Class

The `Student` class represents a student with an ID, first name, and surname.

### Fields
- `id`: The unique identifier for the student.
- `firstname`: The first name of the student.
- `surname`: The surname of the student.

### Constructors
- `public Student(int id, String firstname, String surname)`: Constructs a `Student` object with the specified ID, first name, and surname.

### Methods
- `public int getId()`: Returns the student ID.
- `public void setId(int id)`: Sets the student ID.
- `public String getFirstname()`: Returns the first name of the student.
- `public void setFirstname(String firstname)`: Sets the first name of the student.
- `public String getSurname()`: Returns the surname of the student.
- `public void setSurname(String surname)`: Sets the surname of the student.
- `@Override public String toString()`: Returns a string representation of the student.

## MyHashTableTest Class

The `MyHashTableTest` class contains a test program for the `MyHashTable` class.

### Methods
- `public static void main(String[] args)`: The main method that tests the functionality of the `MyHashTable` class. It populates a hash table with subjects and students, demonstrating the usage of the hash table.
# BST
This Java class implements a Binary Search Tree (BST) data structure with key-value pairs.

## BST Class

The `BST` class represents a binary search tree with keys of type `K` and values of type `V`.

### Fields
- `root`: The root node of the BST.
- `size`: The number of nodes (key-value pairs) in the BST.

### Methods
- `public int size()`: Returns the number of nodes in the BST.
- `public void put(K key, V value)`: Inserts a new key-value pair or updates the value of an existing key in the BST.
- `public V get(K key)`: Retrieves the value associated with the given key.
- `public void delete(K key)`: Deletes the node with the given key from the BST.
- `public List<K> keyIterator()`: Performs an in-order traversal and collects the keys in the BST.
- `public List<V> valueIterator()`: Performs an in-order traversal and collects the values in the BST.
- `public List<Pair<K, V>> pairIterator()`: Performs an in-order traversal and collects the key-value pairs in the BST.
- `@Override public Iterator<Pair<K, V>> iterator()`: Returns an iterator over the key-value pairs in the BST.

### Pair Class
- `BST.Pair<K, V>`: Represents a key-value pair.
