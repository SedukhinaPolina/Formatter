package it.sevenbits.homework.formatter;

import it.sevenbits.homework.reader.IReader;
import it.sevenbits.homework.writer.IWriter;

/**
 * Formats data received from different sources.
 */
public interface IFormatter {
    /**
     * Format the input data and sends to output.
     * @param in input stream
     * @param out output stream
     * @throws FormatterException exception
     */
    void format(IReader in, IWriter out) throws FormatterException;
}
