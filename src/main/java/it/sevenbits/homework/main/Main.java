package it.sevenbits.homework.main;

import it.sevenbits.homework.formatter.FormatterException;
import it.sevenbits.homework.formatter.implementation.Formatter;
import it.sevenbits.homework.reader.ReaderException;
import it.sevenbits.homework.reader.implementation.filereader.FileReader;
import it.sevenbits.homework.reader.implementation.stringreader.StringReader;
import it.sevenbits.homework.writer.implementation.filewriter.FileWriter;
import it.sevenbits.homework.writer.WriterException;
import it.sevenbits.homework.writer.implementation.stringwriter.StringWriter;


/**
 * Main class.
 */
public final class Main {
    private Main() {}
    /**
     * main.
     * @param args input arguments
     * @throws FormatterException exception
     * @throws ReaderException exception
     * @throws WriterException exception
     */
    public static void main(final String[] args) throws FormatterException, WriterException, ReaderException {
        String s = "main(){}";
        StringReader in = new StringReader(s);
        StringWriter out = new StringWriter("");
        Formatter formatter = new Formatter();
        formatter.format(in, out);
        System.out.print(out.getString());
        try {
            FileReader fileIn = new FileReader(args[0]);
            FileWriter fileOut = new FileWriter(args[1]);
            fileIn.close();
            fileOut.close();
        } catch (ReaderException e) {
            System.out.print("reader exception in file");
        } catch (WriterException e) {
            System.out.print("writer exception in file");
        }

    }
}
