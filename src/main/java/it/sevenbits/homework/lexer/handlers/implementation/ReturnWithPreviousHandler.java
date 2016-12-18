package it.sevenbits.homework.lexer.handlers.implementation;

import it.sevenbits.homework.lexer.handlers.ILexemesHandler;

/**
 * Returns token with previous symbol.
 */
public class ReturnWithPreviousHandler implements ILexemesHandler {
    /**
     * Build lexemes
     *
     * @param stringBuilder current lexeme
     * @param symbol        current symbol
     */
    public void execute(final StringBuilder stringBuilder, final Character symbol) {
        stringBuilder.append(symbol);
    }

    /**
     * is the end of the token
     *
     * @return true if end of the token
     */
    public boolean isEndOfToken() {
        return true;
    }
}
