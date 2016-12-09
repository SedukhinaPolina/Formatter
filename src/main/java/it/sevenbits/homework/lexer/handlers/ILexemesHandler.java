package it.sevenbits.homework.lexer.handlers;

/**
 * Build lexemes.
 */
public interface ILexemesHandler {
    /**
     * Build lexemes
     * @param stringBuilder current lexeme
     * @param symbol current symbol
     * @return true if end of the token
     */
    public boolean execute(StringBuilder stringBuilder, Character symbol);
}
