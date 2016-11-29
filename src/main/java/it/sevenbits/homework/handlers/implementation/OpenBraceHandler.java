package it.sevenbits.homework.handlers.implementation;

import it.sevenbits.homework.handlers.IHandler;
import it.sevenbits.homework.handlers.IndentMaker;
import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.writer.WriterException;

/**
 * '{' handler.
 */
public class OpenBraceHandler implements IHandler {
    /**
     * Handle symbol '{'.
     *
     * @param symbol input symbol
     * @param indent current indent
     * @param out    output stream
     * @throws WriterException if something wrong
     */
    public void handle(final char symbol, final IndentMaker indent, final IWriter<String> out) throws WriterException {
        indent.incCountOfTabs();
        out.write(" {\n");
        out.write(indent.makeIndent());
    }
}
