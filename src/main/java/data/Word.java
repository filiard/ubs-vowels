package data;

import java.util.Set;
import java.util.TreeSet;

/**
 * Represents a single word parsed from input file.
 */

public class Word {
    /**
     * Array containing all the vowels to be found. It was assumed the letter 'Y' is not a pure vowel.
     */
    public static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};
    /**
     * String representing the word.
     */
    private String word;
    /**
     * Length of a word.
     */
    private int wordLength;
    /**
     * Total number of vowels present in the word.
     */
    private int numberOfVowels;
    /**
     * Set of all the vowels in a word.
     */
    private Set<Character> setOfVowels = new TreeSet<>();

    /**
     * @return Returns set of vowels present in the word.
     */
    public Set<Character> getSetOfVowels() {
        return setOfVowels;
    }

    /**
     * @return Returns total number of vowels in the word.
     */
    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    /**
     * @return Returns length of the word.
     */
    public int getWordLength() {
        return wordLength;
    }


    /**
     * @param word A word to be added to the group.
     */
    public Word(String word) {
        this.word = word;
        wordLength = word.length();
        countVowels(word);
    }

    /**
     * Counts all vowels appearing in the word and builds a set of distinct setOfVowels.
     *
     * @param word data.Word to have vowels counted.
     * @return Returns number of vowels present in a word.
     */
    private int countVowels(String word) {
        for (int i = 0; i < wordLength; i++) {
            for (char c : Word.VOWELS) {
                if (word.charAt(i) == c) {
                    numberOfVowels++;
                    setOfVowels.add(c);
                }
            }
        }
        return numberOfVowels;
    }

}
