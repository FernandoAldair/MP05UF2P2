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
        hashTable.put("test4","1");
        hashTable.put("test5","2");
        hashTable.put("test6","3");
        hashTable.put("test7","4");
        hashTable.put("test8","5");
        hashTable.put("test9","6");
        //si la key tiene 6 digitos hash es negativo
        hashTable.put("test","7");

        hashTable.count();
        Assertions.assertEquals(10,hashTable.toString());

    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void drop() {
    }
}