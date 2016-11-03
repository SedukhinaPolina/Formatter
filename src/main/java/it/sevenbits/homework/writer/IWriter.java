package it.sevenbits.homework.writer;

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
