package it.sevenbits.homework.writer;

import it.sevenbits.homework.writer.implementation.filewriter.WriterException;

/**
 * Writes information in different sources.
 */
public interface IWriter {
    /**
     * Write string.
     * @param s input string
     * @throws WriterException exception
     */
    void write(String s) throws WriterException;
}
