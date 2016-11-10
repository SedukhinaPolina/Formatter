package it.sevenbits.homework.handlers.implementation;

import it.sevenbits.homework.handlers.CodeClearance;
import it.sevenbits.homework.handlers.IHandler;
import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.writer.WriterException;

/**
 * Handler of '}'.
 */
public class CloseBraceHandler implements IHandler {

    /**
     * Handle '}'.
     *
     * @param symbol        input symbol
     * @param codeClearance specific symbols in code
     * @param out           output stream
     * @throws WriterException if something wrong
     */
    public void handle(final char symbol, final CodeClearance codeClearance, final IWriter out) throws WriterException {
        if (codeClearance.isComment() || codeClearance.isQuote()) {
            out.write("}");
        } else {
            codeClearance.setWasSemicolon(false);
            codeClearance.decCountOfTabs();
            out.write(codeClearance.makeIndent());
            out.write("}\n");
        }

    }
}
