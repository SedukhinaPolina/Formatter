package it.sevenbits.homework.writer;

/**
 * Writes information in different sources.
 * @param <T> string or char
 */
public interface IWriter<T> {
    /**
     * Write string.
     * @param s input string
     * @throws WriterException exception
     */
    void write(T s) throws WriterException;
}
