package it.sevenbits.homework.handlers;

import it.sevenbits.homework.lexer.Token;
import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.writer.WriterException;

/**
 * Interface to handle input symbol.
 */
public interface IHandler {

    /**
     * Handle some symbols.
     * @param token input token
     * @param indent current indent
     * @param out output stream
     * @throws WriterException if something wrong
     */

    void handle(Token token, IndentMaker indent, IWriter<String> out) throws WriterException;
}
