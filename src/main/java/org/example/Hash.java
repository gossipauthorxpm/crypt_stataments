package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hash {
    private String text;
    private byte[] hash;
    private List<String> textBytes = new ArrayList<>();
    private List<Integer> intBytes = new ArrayList<>();
    private int randomInt = new Random().nextInt(31999, 79000);

    public Hash(String data) {
        this.text = data;
        this.getHash();
    }

    //    <get hash>
    private void getHash() {
        this.hash = Encoding.UTF8.GetBytes(this.text);
        this.getBytes();
        this.createStringBytes();
        this.intBytes = this.convertToIntArray(this.textBytes);
        this.encodeIntArray();
    }

    private void getBytes() {
        for (int i = 0; i < this.hash.Length; i++) {
            Console.Write(Convert.ToString(this.hash[i]) + " ");
        }
        Console.WriteLine();
    }

    private List<Integer> getEncodeHash() {
        return this.intBytes;
    }

    private void createStringBytes() {
        String dampString = "";
        for (int i = 0; i < this.hash.length; i++) {
            dampString += this.toString(this.hash[i]);
            if (dampString.length() >= 32) {
                this.textBytes.add(dampString);
                dampString = "";
            }
            if (i == this.hash.length - 1) {
                this.textBytes.add(dampString);
            }
        }
    }

    private List<Integer> convertToIntArray(List<String> list) {
        List<Integer> list_int = new ArrayList<>();
        for (String textByte : this.textBytes) {
            list_int.add(this.toInt(textByte));
        }
        return list_int;
    }

    private List<Integer> encodeIntArray() {
//        encode bytes array
        List<Integer> array = new ArrayList<>();
        for (Integer intByte : this.intBytes) {
            array.add(intByte ^ this.randomInt);
        }
        return array;
    }

    //    </get hash>
    private String toString(byte x) {
        return Byte.toString(x);
    }

    private String toString(int x) {
        return Integer.toString(x);
    }

    private String toString(double x) {
        return Double.toString(x);
    }

    private Integer toInt(String x) {
        return Integer.valueOf(x);
    }

}
