package it.sevenbits.homework.handlers.implementation;

import it.sevenbits.homework.handlers.CodeClearance;
import it.sevenbits.homework.handlers.IHandler;
import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.writer.WriterException;

/**
 * '*' handler.
 */
public class AsteriskHandler implements IHandler {
    /**
     * '*' handler.
     *
     * @param symbol        input symbol
     * @param codeClearance specific symbols in code
     * @param out           output stream
     * @throws WriterException if something wrong
     */
    public void handle(final char symbol, final CodeClearance codeClearance, final IWriter out) throws WriterException {
        out.write("*");
        if (codeClearance.isCanBeComment()) {
            codeClearance.setComment(true);
            codeClearance.setMultilineComment(true);
            codeClearance.setCanBeComment(false);
        }
        if (codeClearance.isMultilineComment()) {
            codeClearance.setCanBeEndOfComment(true);
        }
    }
}
