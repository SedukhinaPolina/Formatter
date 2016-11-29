package it.sevenbits.homework.main;

import it.sevenbits.homework.formatter.FormatterException;
import it.sevenbits.homework.formatter.implementation.Formatter;
import it.sevenbits.homework.reader.ReaderException;
import it.sevenbits.homework.reader.implementation.filereader.FileReader;
import it.sevenbits.homework.writer.implementation.filewriter.FileWriter;
import it.sevenbits.homework.writer.WriterException;


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
        try {
            FileReader in = new FileReader(args[0]);
            FileWriter out = new FileWriter(args[1]);
            Formatter formatter = new Formatter();
            formatter.format(in, out);
            in.close();
            out.close();
        } catch (ReaderException e) {
            System.out.print("reader exception in file");
        } catch (WriterException e) {
            System.out.print("writer exception in file");
        }

    }
}
