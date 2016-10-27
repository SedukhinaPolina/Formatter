package it.sevenbits.homework.reader.implementation.stringreader;

import it.sevenbits.homework.reader.IReader;

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
     */
    public final char read() {
        position++;
        return inputString[position - 1];
    }


    /**
     * The end of the file verification.
     * @return true if end of string, else false
     */
    public final boolean isEnd() {
        return (position > inputString.length - 1);
    }
}
