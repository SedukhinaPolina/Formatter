package it.sevenbits.homework.reader.implementation.stringreader;

import it.sevenbits.homework.reader.IReader;
import it.sevenbits.homework.reader.ReaderException;

/**
 * Reads characters from string.
 */
public class StringReader implements IReader {
    /**
     * input string.
     */
    private char[] inputString;
    /**
     * current position.
     */
    private int position;
    /**
     * Default constructor.
     * @param theInputString is input string
     */
    public StringReader(final String theInputString) {
        this.inputString = theInputString.toCharArray();
    }

    /**
     * Reads one character.
     * @return get character
     * @throws ReaderException exception
     */
    public final char read() throws ReaderException {
        position++;
        return inputString[position - 1];
    }


    /**
     * The end of the file verification.
     * @return true if end of string, else false
     * @throws ReaderException exception
     */
    public final boolean isEnd() throws ReaderException {
        return (position > inputString.length - 1);
    }
}
