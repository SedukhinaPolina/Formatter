 package it.sevenbits.homework.writer.implementation.filewriter;

/**
 * Created by polly on 26.04.16.
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
