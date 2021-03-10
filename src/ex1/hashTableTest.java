package ex1;

import org.junit.jupiter.api.Assertions;
import ex1.HashTable;

import static org.junit.jupiter.api.Assertions.*;

class hashTableTest {

    @org.junit.jupiter.api.Test
    void count() {
        HashTable hashTable = new HashTable();
        Assertions.assertEquals(0,hashTable.count());
    }

    @org.junit.jupiter.api.Test
    void size() {
        HashTable hashTable = new HashTable();
        Assertions.assertEquals(16,hashTable.size());
    }

    @org.junit.jupiter.api.Test
    void put() {
        HashTable hashTable = new HashTable();
        hashTable.put("test1","123");
        hashTable.put("test2","231");
        hashTable.put("test3","312");
//        hashTable.count();
//        hashTable.size();
//        Assertions.assertEquals(3,);
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void drop() {
    }
}