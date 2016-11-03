package it.sevenbits.homework.reader;

/**
 * Reads information from different sources.
 */
public interface IReader {
    /**
     * Reads one character.
     * @return character
     * @throws ReaderException exception
     */
    char read() throws ReaderException;


    /**
     * The end of the file verification.
     * @throws ReaderException exception
     * @return true if the end of the file
     */
    boolean isEnd() throws ReaderException;

}
