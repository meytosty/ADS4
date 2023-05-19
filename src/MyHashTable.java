import java.util.LinkedList;
public class MyHashTable<K, V> {
    private LinkedList<HashNode<K, V>>[] chainArray; // linked list to store nodes
    private int M = 11;
    private int size; // table size
    /**
     * MyHashTable - constructor to create hash table
     */
    public MyHashTable() {
        this.size = 0;
        this.chainArray = new LinkedList[M];
    }
    /**
     * MyHashTable - constructor with additional M to change
     * @param M - given M to change
     */
    public MyHashTable(int M) {
        this.M = M;
        this.size = 0;
        this.chainArray = new LinkedList[M];
    }
    /**
     * hash - method to hashing key
     * @param key - given key to hash
     * @return int
     */
    public int hash(K key) {
        return key.hashCode() % M;
    }
    /**
     * put - method puts a value in hash table with key
     * @param key - given key to put within
     * @param value - given value to put
     */
    public void put(K key, V value) {
        int index = hash(key);
        if (chainArray[index] == null) {
            chainArray[index] = new LinkedList<HashNode<K, V>>();
        }
        for (HashNode<K, V> node : chainArray[index]) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
        }
        chainArray[index].add(new HashNode<K, V>(key, value));
        size++;
    }
    /**
     * get - method gets a value with key
     * @param key - given key to get value within
     * @return V - value type
     */
    public V get(K key) {
        int index = hash(key);
        if (chainArray[index] == null) {
            return null;
        }
        for (HashNode<K, V> node : chainArray[index]) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        return null;
    }
    /**
     * remove - method removes value with key
     * @param key - given key to remove value within
     * @return V - value type
     */
    public V remove(K key) {
        int index = hash(key);
        if (chainArray[index] == null) {
            return null;
        }
        for (HashNode<K, V> node : chainArray[index]) {
            if (node.getKey().equals(key)) {
                chainArray[index].remove(node);
                size--;
                return node.getValue();
            }
        }
        size--;
        return null;
    }
    /**
     * contains - method checks is hash table contains given value
     * @param value - given value to check
     * @return boolean
     */
    public boolean contains(V value) {
        for (LinkedList<HashNode<K, V>> list : chainArray) {
            for (HashNode<K, V> node : list) {
                if (node.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * getKey - method returns key of value
     * @param value - given value to get key
     * @return K - key type
     */
    public K getKey(V value) {
        for (LinkedList<HashNode<K, V>> list : chainArray) {
            for (HashNode<K, V> node : list) {
                if (node.getValue().equals(value)) {
                    return node.getKey();
                }
            }
        }
        return null;
    }
    public void replace(K key , V value){
        int index = hash(key);
        if(chainArray[index] == null){
            chainArray[index] = new LinkedList<HashNode<K, V>>();
        }
        for (HashNode<K, V> node : chainArray[index]) {
            if (node.getKey().equals(key)) {
                node.getValue();
                chainArray[index].remove(node);
                size--;
                node.setValue(value);
                return;
            }
        }
        chainArray[index].add(new HashNode<K, V>(key, value));
        size++;
    }
}
