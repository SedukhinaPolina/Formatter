package it.sevenbits.homework.lexer.handlers.implementation;

import it.sevenbits.homework.lexer.handlers.ILexemesHandler;

/**
 * Skip symbol.
 */
public class SkipHandler implements ILexemesHandler {
    /**
     * Skip symbol
     *
     * @param stringBuilder current lexeme
     * @param symbol        current symbol
     */
    public void execute(final StringBuilder stringBuilder, final Character symbol) {
    }

    /**
     * is the end of the token
     *
     * @return true if end of the token
     */
    public boolean isEndOfToken() {
        return false;
    }
}
