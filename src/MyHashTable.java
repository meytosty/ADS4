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
        return key.hashCode() % M;
    }
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
    public K getKey(V value) {
        return null;
    }
}
