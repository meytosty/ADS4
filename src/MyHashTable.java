import java.util.LinkedList;

public class MyHashTable<K, V> {
    private LinkedList<HashNode<K, V>>[] chainArray;
    private int M = 11;
    private int size;
    public MyHashTable() {
        this.size = 0;
        this.chainArray = new LinkedList[M];
    }
    public MyHashTable(int M) {
        this.M = M;
        this.size = 0;
        this.chainArray = new LinkedList[M];
    }
    public int hash(K key) {
        return 0;
    }
    public void put(K key, V value) {

    }
    public V get(K key) {
        return null;
    }
    public V remove(K key) {
        return null;
    }
    public boolean contains(V value) {
        return false;
    }
    public K getKey(V value) {
        return null;
    }
}
