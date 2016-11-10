package it.sevenbits.homework.formatter;

import it.sevenbits.homework.reader.IReader;
import it.sevenbits.homework.reader.ReaderException;
import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.writer.WriterException;

/**
 * Formats data received from different sources.
 */
public interface IFormatter {
    /**
     * Format the input data and sends to output.
     * @param in input stream
     * @param out output stream
     * @throws FormatterException exception
     * @throws ReaderException exception
     * @throws WriterException exception
     */
    void format(IReader in, IWriter out) throws FormatterException, ReaderException, WriterException;
}
