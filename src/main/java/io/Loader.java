package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Used to load a file.
 */
public class Loader {

    /**
     * Name of the file to be opened.
     */
    private String sourceFile;
    /**
     * Responsible for reading the file.
     */
    private FileReader fr;
    /**
     * Contains the content of the read file.
     */
    private String fileContents;
    /**
     * Object used to build a String containing content of the file.
     */
    private StringBuilder builder;

    public Loader(String sourceFile) {
        this.sourceFile = sourceFile;
    }


    /**
     * Loads file and stores it as a String.
     * @return Returns the file as a one-line String.
     */
    private String loadFile() {
        try {
            fr = new FileReader(sourceFile);
        } catch (FileNotFoundException e) {
            System.out.println("File '" + sourceFile + "' not found!");
            System.exit(1);
        }
        builder = new StringBuilder();
        BufferedReader br = new BufferedReader(fr);
        String lastLine;
        try {
            while ((lastLine = br.readLine()) != null) {
                builder.append(lastLine + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    /**
     * Removes all unwanted characters from the text (special characters, digits).
     * @return Returns text having only letters and whitespaces.
     */
    private String sanitizeString() {
        return fileContents.replaceAll("[^a-zA-Z\\s+]", "");
    }

    /**
     * Loads the file and cleans it.
     * @return Returns content of the file as a single line String without any unwanted characters.
     */

    public String readFile() {
        fileContents = this.loadFile();
        fileContents = this.sanitizeString();
        return fileContents;
    }
}
