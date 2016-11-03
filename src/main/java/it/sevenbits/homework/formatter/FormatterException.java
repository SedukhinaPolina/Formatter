package it.sevenbits.homework.formatter;

/**
 * Exception in formatter.
 */
public class FormatterException extends Exception {
    /**
     * Constructor.
     * @param e is incoming param
     */
    public FormatterException(final Throwable e) {
        initCause(e);
    }
}
