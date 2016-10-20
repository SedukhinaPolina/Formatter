 package it.sevenbits.homework.main;

import it.sevenbits.homework.formatter.implementation.Formatter;
import it.sevenbits.homework.reader.implementation.filereader.FileReader;
import it.sevenbits.homework.reader.implementation.filereader.ReaderException;
import it.sevenbits.homework.reader.implementation.stringreader.StringReader;
import it.sevenbits.homework.writer.implementation.filewriter.FileWriter;
import it.sevenbits.homework.writer.implementation.filewriter.WriterException;
import it.sevenbits.homework.writer.implementation.stringwriter.StringWriter;


/**
 * Main class.
 */
public class Main {

    /**
     * Default constructor.
     */
    public Main() {
    }

    /**
     * main.
     * @param args input arguments
     */
    public static void main(final String[] args) {
        String s = "public final void format(){char temp;while (!in.isEnd()){temp = in.read();}}";
        StringReader in = new StringReader(s);
        StringWriter out = new StringWriter("");
        Formatter formatter = new Formatter();
        formatter.format(in, out);
        System.out.print(out.getString());

        try {
            FileReader fileIn = new FileReader("in.txt");
            FileWriter fileOut = new FileWriter("out.txt");

            formatter.format(fileIn, fileOut);
            fileIn.close();
        } catch (ReaderException e) {
            System.out.print("reader exception in file");
        } catch (WriterException e) {
            System.out.print("writer exception in file");
        }

    }
}
