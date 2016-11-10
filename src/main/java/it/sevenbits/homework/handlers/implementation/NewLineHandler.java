package it.sevenbits.homework.handlers.implementation;

import it.sevenbits.homework.handlers.CodeClearance;
import it.sevenbits.homework.handlers.IHandler;
import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.writer.WriterException;

/**
 * '\n' handler.
 */
public class NewLineHandler implements IHandler {
    /**
     * Handle symbol '\n'.
     *
     * @param symbol        input symbol
     * @param codeClearance specific symbols in code
     * @param out           output stream
     * @throws WriterException if something wrong
     */
    public void handle(final char symbol, final CodeClearance codeClearance, final IWriter out) throws WriterException {
        out.write("\n");
        if (codeClearance.isComment() && !codeClearance.isMultilineComment()) {
            codeClearance.setComment(false);
        }
        out.write(codeClearance.makeIndent());
    }
}
