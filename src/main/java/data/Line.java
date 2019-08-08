package data;

import java.util.*;
import io.*;
/**
 * Represents a line of words read by {@link Loader}
 */
public class Line {
    /**
     * Initial String read by {@link Loader}
     */
    private String line;
    /**
     * A list of separate words present in the line
     */
    private ArrayList<Word> words = new ArrayList<>();

    /**
     * A {@link Map} collection in which key {@link Integer} represents the length of each word in a group
     * and value {@link WordGroup} is a group of words having the same length.
     */
    private Map<Integer, WordGroup> groupedWordsMap = new TreeMap<>(Collections.reverseOrder());

    /**
     * Creates new data.Line.
     * @param line Initial String to be parsed into a data.Line.
     */
    public Line(String line) {
        this.line = line;
    }

    /**
     * Splits initial line of text int separate words on whitespace.
     */
    private void split() {
        String[] splitted = line.split("[ \n]");
        for (String word : splitted) {
            words.add(new Word(word));
        }
    }

    /**
     * Groups words by their length.
     */
    private void groupWordsHMap() {
        for (Word word : words) {
            int wordLength = word.getWordLength();
            if (!groupedWordsMap.containsKey(wordLength)) {
                groupedWordsMap.put(wordLength, new WordGroup());
                groupedWordsMap.get(wordLength).addWord(word);
            } else {
                groupedWordsMap.get(wordLength).addWord(word);
            }
        }
    }

    private void countAverageVowels() {
        for (Map.Entry<Integer, WordGroup> group : groupedWordsMap.entrySet()) {
            WordGroup currentGroup = group.getValue();
            currentGroup.setAverageNumberOfVowels(currentGroup.getNumberOfVowels() / (float) currentGroup.wordsInGroup.size());
            groupedWordsMap.put(group.getKey(), currentGroup);
        }
    }

    /**
     * Runs all private methods - splits line into words, groups them by length and counts average number of vowels in each group.
     */
    public void computeLine() {
        this.split();
        this.groupWordsHMap();
        this.countAverageVowels();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Set set = groupedWordsMap.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            builder.append(me.getValue().toString() + "\n");
        }
        return builder.toString();
    }
}
