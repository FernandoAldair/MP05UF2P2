package ex1;

import org.junit.jupiter.api.Assertions;

class hashTableTest {

    //Hay "6" errores:
    //Errores encontrados:
    //- put:
    //  1- No suma
    //  2- Se duplica
    //- get:
    //  3- buscar algo inexistente
    //  4- imprime algo inexistente
    //- drop
    //  5- No resta
    //  6- Borra una fila entera si el elemento que queremos borrar es el primero
    //  7- Borrar algo que no existe

    @org.junit.jupiter.api.Test
    void count_size() {
        HashTable hashTable = new HashTable();
        //comprueba que no hay ningun dato dentro del HashTable
        Assertions.assertEquals(0,hashTable.count());
        //Comprueba que hay 16 posiciones en el hashtable
        Assertions.assertEquals(16,hashTable.size());
        hashTable.put("1","mundo1");
        hashTable.put("2","mundo2");
        hashTable.put("3","mundo3");
        Assertions.assertEquals(3,hashTable.count());
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
    void putMismaKey() {
        HashTable hashTable = new HashTable();

        Assertions.assertEquals("",hashTable.toString());
        hashTable.put("1","mundo1");
        hashTable.put("2","mundo2");
        hashTable.put("3","mundo3");
        hashTable.put("4","mundo4");

        hashTable.put("13","mundo13");
        //El nodo numero 2 se actualiza
        hashTable.put("2","otra cosa");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, mundo1]\n" +
                " bucket[2] = [2, otra cosa] -> [13, mundo13]\n" +
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

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, mundo1]\n" +
                " bucket[2] = [2, mundo2]\n" +
                " bucket[3] = [3, mundo3]\n" +
                " bucket[4] = [4, mundo4]",hashTable.toString());

        hashTable.put("2","otra_cosa");
        hashTable.put("3","otra_cosa");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, mundo1]\n" +
                " bucket[2] = [2, otra_cosa]\n" +
                " bucket[3] = [3, otra_cosa]\n" +
                " bucket[4] = [4, mundo4]",hashTable.toString());


        Assertions.assertEquals("otra_cosa",hashTable.get("3"));

    }

    @org.junit.jupiter.api.Test
    void getNoExiste() {
        //No puedes borrar algo que no existe
        HashTable hashTable = new HashTable();
        hashTable.put("1","mundo1");
        hashTable.get("12");
        Assertions.assertEquals(null,hashTable.get("12"));
    }

    @org.junit.jupiter.api.Test
    void getConColision() {
        HashTable hashTable = new HashTable();
        hashTable.put("1","mundo1");
        hashTable.put("2","mundo2");
        hashTable.put("13","mundo13");
        hashTable.put("3","mundo3");
        hashTable.put("14","mundo14");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, mundo1]\n" +
                " bucket[2] = [2, mundo2] -> [13, mundo13]\n" +
                " bucket[3] = [3, mundo3] -> [14, mundo14]",hashTable.toString());

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

        //Borrar el primero
        hashTable.drop("2");
        //Borrar el ultimo
        hashTable.drop("25");
        //Borrar en medio
        hashTable.drop("12");
        //Borrar en medio
        hashTable.drop("23");
        //Borrar unico valor
        hashTable.drop("4");

        hashTable.drop("37");

        Assertions.assertEquals("\n" +
                " bucket[1] = [1, mundo1] -> [34, mundo34]\n" +
                " bucket[2] = [13, mundo13] -> [24, mundo24]\n" +
                " bucket[3] = [3, mundo3] -> [14, mundo14]", hashTable.toString());

        Assertions.assertEquals(6,hashTable.count());
    }

    @org.junit.jupiter.api.Test
    void dropAlgoinexistente() {
        //No puedes borrar algo que no existe
        HashTable hashTable = new HashTable();
        hashTable.put("1","mundo1");
        hashTable.put("12","mundo1");
        hashTable.drop("23");
    }


}