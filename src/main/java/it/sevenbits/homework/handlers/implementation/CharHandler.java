package it.sevenbits.homework.handlers.implementation;

import it.sevenbits.homework.handlers.CodeClearance;
import it.sevenbits.homework.handlers.IHandler;
import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.writer.WriterException;

/**
 * Handle other symbols.
 */
public class CharHandler implements IHandler {
    /**
     * Handle other symbols.
     *
     * @param symbol        input symbol
     * @param codeClearance specific symbols in code
     * @param out           output stream
     * @throws WriterException if something wrong
     */
    public void handle(final char symbol, final CodeClearance codeClearance, final IWriter out) throws WriterException {
        if (codeClearance.isWasSemicolon()) {
            out.write(codeClearance.makeIndent());
            codeClearance.setWasSemicolon(false);
        }
        out.write(symbol + "");
    }
}
