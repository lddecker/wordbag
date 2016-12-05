package com.lddecker.display;

import java.io.PrintStream;
import java.util.Collection;

public class ResultDisplay {
    public static void printWords(Collection<String> words, PrintStream printStream) {
        if (words.isEmpty()) {
            printStream.println("no words can be made");
        }
        for (String word : words) {
            printStream.println(word);
        }
    }
}