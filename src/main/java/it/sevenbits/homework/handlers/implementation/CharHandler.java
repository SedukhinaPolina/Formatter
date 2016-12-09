package it.sevenbits.homework.handlers.implementation;

import it.sevenbits.homework.handlers.IHandler;
import it.sevenbits.homework.handlers.IndentMaker;
import it.sevenbits.homework.lexer.Token;
import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.writer.WriterException;

/**
 * Handler of other symbols.
 */
public class CharHandler implements IHandler {
    /**
     * Handle some symbols.
     *
     * @param token input token
     * @param indent current indent
     * @param out    output stream
     * @throws WriterException if something wrong
     */
    public void handle(final Token token, final IndentMaker indent, final IWriter<String> out) throws WriterException {
        out.write(token.getToken() + "");
    }
}
