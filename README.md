# ADS 4 assignment. Ketebay Bakhtiyar
## Algorithms and Data Structures | Khaimuldin Nursultan
### 🎁 hash
*Description:* Method hashing a key and get index from this.
```java
public int hash(K key) {
    return key.hashCode() % M;
}
```

### 🎁 put
*Description:* Method use hashing method to get index from key and put a value in hash table.
```java
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
```

### 🎁 get
*Description:* Method use hashing method to get index from key and returns value from this index.
```java
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
```

### 🎁 remove
*Description:* Method use hashing method to get index from key and remove value from this index.
```java
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
```

### 🎁 contains
*Description:* Method with loop check is value contain in hash table.
```java
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
```

### 🎁 getKey
*Description:* Method with loop finds specific value in hash table and returns key of this.
```java
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
```









