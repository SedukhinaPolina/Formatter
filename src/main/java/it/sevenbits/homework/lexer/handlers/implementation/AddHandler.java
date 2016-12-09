package it.sevenbits.homework.lexer.handlers.implementation;

import it.sevenbits.homework.lexer.handlers.ILexemesHandler;

/**
 * Add symbol to lexeme.
 */
public class AddHandler implements ILexemesHandler {
    /**
     * Add symbol to lexeme
     *
     * @param stringBuilder current lexeme
     * @param symbol        current symbol
     * @return true if end of the token
     */
    public boolean execute(final StringBuilder stringBuilder, final Character symbol) {
        stringBuilder.append(symbol);
        return false;
    }
}
