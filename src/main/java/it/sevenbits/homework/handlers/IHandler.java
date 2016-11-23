package it.sevenbits.homework.handlers;

import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.writer.WriterException;

/**
 * Interface to handle input symbol.
 */
public interface IHandler {

    /**
     * Handle some symbols.
     * @param symbol input symbol
     * @param indent current indent
     * @param out output stream
     * @throws WriterException if something wrong
     */

    void handle(char symbol, IndentMaker indent, IWriter out) throws WriterException;
}
