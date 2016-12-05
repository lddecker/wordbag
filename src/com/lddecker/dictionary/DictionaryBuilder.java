package com.lddecker.dictionary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryBuilder {
    public static List<String> getDictionary() {
        ArrayList<String> dictionaryWords = new ArrayList<>();
        try {
            InputStream fileInputStream = new FileInputStream(new File("W"));
            Scanner sc = new Scanner(fileInputStream);
            while (sc.hasNextLine()) {
                dictionaryWords.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dictionaryWords;
    }
}