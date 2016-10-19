package it.sevenbits.homework.reader.implementation.filereader;

/**
 * Created by polly on 24.04.16.
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
