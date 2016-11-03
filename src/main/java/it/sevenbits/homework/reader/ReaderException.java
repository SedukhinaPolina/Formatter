package it.sevenbits.homework.reader;

/**
 * Reader exception.
 */
public class ReaderException extends Exception {
    /**
     * Exception in FileReader.
     */
        /**
         * Constructor.
         * @param e is incoming param
         */
        public ReaderException(final Throwable e) {
            initCause(e);
        }
    }
