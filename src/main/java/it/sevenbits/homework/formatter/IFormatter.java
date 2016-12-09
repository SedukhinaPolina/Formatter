package it.sevenbits.homework.formatter;

import it.sevenbits.homework.lexer.Token;
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
     * @throws FormatterException exception in formatter
     */
    void format(IReader<Token> in, IWriter<String> out) throws FormatterException;
}
