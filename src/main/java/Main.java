import data.Line;
import io.*;
import java.io.IOException;

/**
 * Main class that runs the program.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        String file;
        Loader loader = new Loader("input2.txt");    //name of the file to be opened
        file = loader.readFile();

        Line line = new Line(file);
        line.computeLine();
        Printer printer = new Printer();

        printer.printToFile(line, "output2.txt");    //name of the output file
        System.out.println(line);
    }

}
