package it.sevenbits.homework.lexer.handlers;

/**
 * Build lexemes.
 */
public interface ILexemesHandler {
    /**
     * Build lexemes
     * @param stringBuilder current lexeme
     * @param symbol current symbol
     */
    void execute(StringBuilder stringBuilder, Character symbol);

    /**
     * is the end of the token
     * @return true if end of the token
     */
    boolean isEndOfToken();
}
