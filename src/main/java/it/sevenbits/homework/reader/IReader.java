package it.sevenbits.homework.reader;

import it.sevenbits.homework.reader.implementation.filereader.ReaderException;

/**
 * Reads information from different sources.
 */
public interface IReader {
    /**
     * Reads one character.
     * @return character
     * @throws ReaderException
     */
    char read() throws ReaderException;

    /**
     * Closes thread.
     * @throws ReaderException
     */
    void close() throws ReaderException;

    /**
     * The end of the file verification.
     */
    boolean isEnd() throws ReaderException;
}
