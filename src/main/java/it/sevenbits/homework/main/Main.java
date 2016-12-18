package it.sevenbits.homework.main;

import it.sevenbits.homework.formatter.FormatterException;
import it.sevenbits.homework.formatter.implementation.Formatter;
import it.sevenbits.homework.lexer.Token;
import it.sevenbits.homework.reader.IReader;
import it.sevenbits.homework.reader.ReaderException;
import it.sevenbits.homework.reader.implementation.filereader.FileReader;
import it.sevenbits.homework.reader.implementation.lexemesreader.Lexer;
import it.sevenbits.homework.writer.implementation.filewriter.FileWriter;
import it.sevenbits.homework.writer.WriterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Main class.
 */
public final class Main {
    /**
     * logger
     */
    final static Logger logger = LoggerFactory.getLogger(Main.class);
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
            logger.info("input file is opened");
            FileWriter out = new FileWriter(args[1]);
            logger.info("output file is opened");
            IReader<Token> lexer = new Lexer(in);
            Formatter formatter = new Formatter();
            formatter.format(lexer, out);
            in.close();
            logger.info("input file is closed");
            out.close();
            logger.info("output file is closed");
        } catch (ReaderException e) {
            logger.info("reader exception in file");
        } catch (WriterException e) {
            logger.info("writer exception in file");
        }

    }
}
