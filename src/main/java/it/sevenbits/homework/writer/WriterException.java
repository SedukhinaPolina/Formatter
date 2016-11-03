 package it.sevenbits.homework.writer;

/**
 * Exception in FileWriter.
 */
public class WriterException extends Exception {
    /**
     * Constructor.
     * @param e is incoming param
     */
    public WriterException(final Throwable e) {
        initCause(e);
    }
}
