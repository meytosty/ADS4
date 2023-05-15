import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable<TestingClass, String>();
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            int val = r.nextInt(0, 9999999);
            hashTable.put(new TestingClass(val), "Student " + val);
        }
    }
}