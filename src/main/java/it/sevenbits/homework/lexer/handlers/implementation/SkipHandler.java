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
     * @return true if end of the token
     */
    public boolean execute(final StringBuilder stringBuilder, final Character symbol) {
        return false;
    }
}
