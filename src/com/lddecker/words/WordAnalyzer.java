package com.lddecker.words;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordAnalyzer {

    private List<String> _dictionary;

    public WordAnalyzer(List<String> dictionary) {
        _dictionary = dictionary;
    }

    public Collection<String> getWords(String letters) {
        List<String> possibleWords = new ArrayList<>();
        Map<Character, Integer> lettersMap = getLetterCounts(letters);
        int lettersSize = letters.length();
        for (String dictionaryWord : _dictionary) {
            if (wordCanBeBuiltFromLetters(dictionaryWord, lettersMap, lettersSize)) {
                possibleWords.add(dictionaryWord);
            }
        }

        return possibleWords;
    }

    private boolean wordCanBeBuiltFromLetters(String dictionaryWord, Map<Character, Integer> lettersMap, int lettersSize) {
        if (dictionaryWord.length() > lettersSize) {
            return false;
        }
        Map<Character, Integer> dictionaryWordLetterMap = getLetterCounts(dictionaryWord);
        for (Map.Entry<Character, Integer> entry : dictionaryWordLetterMap.entrySet()) {
            if (!lettersMap.containsKey(entry.getKey())) {
                return false;
            }
            if (entry.getValue() > lettersMap.get(entry.getKey())) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> getLetterCounts(String word) {
        Map<Character, Integer> characterMap = new HashMap<>();
        for (char character : word.toCharArray()) {
            if (characterMap.containsKey(character)) {
                characterMap.put(character, characterMap.get(character) + 1);
            } else {
                characterMap.put(character, 1);
            }
        }

        return characterMap;
    }
}