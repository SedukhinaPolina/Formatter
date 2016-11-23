package it.sevenbits.homework.states.implementation;

import it.sevenbits.homework.handlers.IHandler;
import it.sevenbits.homework.handlers.IndentMaker;
import it.sevenbits.homework.handlers.implementation.CharHandler;
import it.sevenbits.homework.states.IState;
import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.writer.WriterException;

/**
 * when current symbol is '/'.
 */
public class CanBeCommentState implements IState {
    private IHandler handler;
    private IndentMaker indent;
    /**
     * Default constructor.
     */
    public CanBeCommentState() {
        handler = new CharHandler();
        indent = new IndentMaker();
    }

    /**
     * Method for write '/'.
     *
     * @param out    output stream
     * @param symbol input symbol
     * @throws WriterException exception
     */
    public void execute(final IWriter out, final char symbol) throws WriterException {
        handler.handle(symbol, indent, out);
    }
}
