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
    void putcontar() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","123");
        hashTable.put("2","231");
        hashTable.put("3","312");
        hashTable.put("4","1");
        hashTable.put("5","2");
        hashTable.put("6","3");
        hashTable.put("7","4");
        hashTable.put("8","5");
        hashTable.put("9","6");
        hashTable.put("10","7");
        hashTable.put("11","8");
        hashTable.put("12","9");
        hashTable.put("13","10");
        hashTable.put("14","11");
        hashTable.put("15","12");
        hashTable.put("16","13");

        hashTable.put("17","14");
        //si la key tiene 6 digitos hash es negativo (teoria)
        //Valor se duplica

        hashTable.count();
        Assertions.assertEquals(16,hashTable.toString());

    }

    @org.junit.jupiter.api.Test
    void get() {

    }

    @org.junit.jupiter.api.Test
    void drop() {
        //No puedes borrar algo que no existe
    }
}