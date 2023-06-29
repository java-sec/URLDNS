package com.cc11001100;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static byte[] serialization(Object o) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos);) {
            oos.writeObject(o);
            return baos.toByteArray();
        }
    }

    private static <T> T deserialization(byte[] bytes) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));) {
            return (T) ois.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Map<URL, String> hashMap = new HashMap<>();
        URL url = new URL("http://jauiok.dnslog.cn");
        hashMap.put(url, "steady");

        byte[] bytes = serialization(hashMap);
        Map<URL, String> newMap = deserialization(bytes);
        System.out.println(newMap);

    }

}
