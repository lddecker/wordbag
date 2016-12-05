package com.lddecker;

import com.lddecker.dictionary.DictionaryBuilder;
import com.lddecker.display.ResultDisplay;
import com.lddecker.words.WordAnalyzer;

import java.util.Collection;
import java.util.List;

public class Wordbag {

    public static void main(String[] args) {
        String letters = args[0];
        List<String> dictionary = DictionaryBuilder.getDictionary();
        WordAnalyzer wordAnalyzer = new WordAnalyzer(dictionary);
        Collection<String> words = wordAnalyzer.getWords(letters);
        ResultDisplay.printWords(words, System.out);
    }

}
