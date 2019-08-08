package data;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Represents a group of words having the same length.
 */
public class WordGroup {
    /**
     * Initial number of vowels in all the words in a group.
     */
    private int numberOfVowels = 0;
    /**
     * List containing all the words in a group.
     */
    public ArrayList<Word> wordsInGroup = new ArrayList<>();
    /**
     * Set containing distinct vowels appearing in the group.
     */
    public TreeSet<Character> setOfVowels = new TreeSet<>();
    /**
     * Average number of vowels per word in the group.
     */
    private float averageNumberOfVowels;
    /**
     * Length of a single word in the group.
     */
    private int wordLength;

    /**
     *
     * @return Returns total number of vowels appearing in all the words in th group.
     */
    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    /**
     *
     * Sets the average number of vowels to a calculated value.
     * @param averageNumberOfVowels Calculated average number of vowels in the group.
     */
    public void setAverageNumberOfVowels(float averageNumberOfVowels) {
        this.averageNumberOfVowels = averageNumberOfVowels;
    }

    /**
     * Adds a word to the group.
     * Increases number of vowels in the group on addition.
     * Adds a vowels to the set of vowels in the group.
     * @param word data.Word to be added to the group
     */

    public void addWord(Word word) {
        wordsInGroup.add(word);
        wordLength = word.getWordLength();
        numberOfVowels += word.getNumberOfVowels();
        for (Character c : word.getSetOfVowels()) {
            setOfVowels.add(c);
        }
    }

    /**
     * Prints vowels present in the group
     * @return Returns a formatted String containing vowels present in a group.
     */

    private String printVowels() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (Character c : setOfVowels) {
            builder.append(c + ",");
        }
        if (builder.toString().length()>1)
            builder.setLength(builder.length() - 1);
        builder.append("}");
        return builder.toString();
    }

    /**
     * Prints an average number of vowels in the group.
     * @return Returns a formatted number (as integer or real number) of vowels in a group.
     */
    private String getAverageNumberOfVowelsAsString() {
        if (averageNumberOfVowels - Math.round(averageNumberOfVowels) == 0)
            return String.format("%.0f", averageNumberOfVowels);
        else return String.format("%.2f", averageNumberOfVowels);
    }

    @Override
    public String toString() {
        return "(" + printVowels() + ", " + wordLength + ") -> " + getAverageNumberOfVowelsAsString();
    }
}
