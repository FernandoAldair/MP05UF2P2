package ex1;

import org.junit.jupiter.api.Assertions;
import ex1.HashTable;

import static org.junit.jupiter.api.Assertions.*;

class hashTableTest {

    //Hay 6 errores:
    //1- No suma, no resta
    //2- drop borrar el primero ( borra toda la fila)
    //3-
    //4-
    //5-
    //6-

    @org.junit.jupiter.api.Test
    void count() {
        HashTable hashTable = new HashTable();
        Assertions.assertEquals(0,hashTable.count());//comprueba que no hay ningun dato dentro del HashTable
        hashTable.put("1","mundo1");
        hashTable.put("2","mundo2");
        hashTable.put("3","mundo3");
        hashTable.put("4","mundo4");
        hashTable.put("5","mundo5");
        Assertions.assertEquals(5,hashTable.count());

    }

    @org.junit.jupiter.api.Test
    void size() {
        HashTable hashTable = new HashTable();
        Assertions.assertEquals(16,hashTable.size());
        hashTable.put("1","mundo1");
        hashTable.put("2","mundo2");
        hashTable.put("3","mundo3");
        hashTable.put("4","mundo4");
        hashTable.put("5","mundo5");
        Assertions.assertEquals(16,hashTable.size());
    }

    @org.junit.jupiter.api.Test
    void putSinColision() {
        HashTable hashTable = new HashTable();

        Assertions.assertEquals("",hashTable.toString());
        hashTable.put("1","mundo1");
        hashTable.put("2","mundo2");
        hashTable.put("3","mundo3");
        hashTable.put("4","mundo4");
        Assertions.assertEquals("\n" +
                " bucket[1] = [1, mundo1]\n" +
                " bucket[2] = [2, mundo2]\n" +
                " bucket[3] = [3, mundo3]\n" +
                " bucket[4] = [4, mundo4]",hashTable.toString());

        //si la key tiene 6 digitos hash es negativo (teoria)
        hashTable.put("test10","asdasda");

        //Valor se duplica

    }

    @org.junit.jupiter.api.Test
    void putConColision() {
        HashTable hashTable = new HashTable();

        Assertions.assertEquals("",hashTable.toString());
        hashTable.put("1","mundo1");
        hashTable.put("2","mundo2");
        hashTable.put("3","mundo3");
        hashTable.put("4","mundo4");

        hashTable.put("13","mundo13");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, mundo1]\n" +
                " bucket[2] = [2, mundo2] -> [13, mundo13]\n" +
                " bucket[3] = [3, mundo3]\n" +
                " bucket[4] = [4, mundo4]",hashTable.toString());

    }

    @org.junit.jupiter.api.Test
    void getSinColision() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","mundo1");
        hashTable.put("2","mundo2");
        hashTable.put("3","mundo3");
        hashTable.put("4","mundo4");

        Assertions.assertEquals("mundo3",hashTable.get("3"));

    }

    @org.junit.jupiter.api.Test
    void getConColision() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","mundo1");
        hashTable.put("2","mundo2");
        hashTable.put("3","mundo3");
        hashTable.put("4","mundo4");

        hashTable.put("13","mundo13");

        Assertions.assertEquals("mundo13",hashTable.get("13"));

    }

    @org.junit.jupiter.api.Test
    void drop() {
        //No puedes borrar algo que no existe
        HashTable hashTable = new HashTable();
        hashTable.put("1","mundo1");
        hashTable.put("2","mundo2");
        hashTable.put("3","mundo3");
        hashTable.put("4","mundo4");

        hashTable.put("12","mundo12");
        hashTable.put("13","mundo13");
        hashTable.put("14","mundo14");

        hashTable.put("23","mundo23");
        hashTable.put("24","mundo24");
        hashTable.put("25","mundo25");

        hashTable.put("34","mundo34");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, mundo1] -> [12, mundo12] -> [23, mundo23] -> [34, mundo34]\n" +
                " bucket[2] = [2, mundo2] -> [13, mundo13] -> [24, mundo24]\n" +
                " bucket[3] = [3, mundo3] -> [14, mundo14] -> [25, mundo25]\n" +
                " bucket[4] = [4, mundo4]",hashTable.toString());

        hashTable.drop("2");
        hashTable.drop("25");
        hashTable.drop("12");
        hashTable.drop("23");
        hashTable.drop("4");



        Assertions.assertEquals("\n" +
                " bucket[1] = [1, mundo1] -> [34, mundo34]\n" +
                " bucket[2] = [13, mundo13] -> [24, mundo24]\n" +
                " bucket[3] = [3, mundo3] -> [14, mundo14]\n" +
                " bucket[4] = ",hashTable.toString());


    }
}