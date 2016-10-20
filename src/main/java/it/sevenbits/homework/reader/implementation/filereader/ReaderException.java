package it.sevenbits.homework.reader.implementation.filereader;

/**
 * Exception in FileReader.
 */
public class ReaderException extends Exception {
    /**
     * Constructor.
     * @param e is incoming param
     */
    public ReaderException(final Throwable e) {
        initCause(e);
    }
}
