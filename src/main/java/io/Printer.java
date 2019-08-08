package io;

import data.Line;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Saves results to a local file.
 */
public class Printer {
    /**
     *
     * @param line  Parsed {@link Line} to be printed.
     * @param filename  Name of the file to be saved.
     * @throws IOException if unable to create a new file.
     */
    public void printToFile (Line line, String filename) throws IOException
    {
        try (PrintWriter pw  = new PrintWriter(new File(filename)))
        {

            pw.write(line.toString());
        }
        System.out.println("File '"+filename+"' saved");
    }
}
