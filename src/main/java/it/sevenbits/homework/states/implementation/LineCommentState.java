package it.sevenbits.homework.states.implementation;

import it.sevenbits.homework.handlers.IHandler;
import it.sevenbits.homework.handlers.IndentMaker;
import it.sevenbits.homework.handlers.implementation.CharHandler;
import it.sevenbits.homework.states.IState;
import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.writer.WriterException;

/**
 * State single line comment.
 */
public class LineCommentState implements IState {
    private IHandler handler;
    private IndentMaker indent;
    /**
     * Default constructor.
     */
    public LineCommentState() {
        handler = new CharHandler();
        indent = new IndentMaker();
    }
    /**
     * Method for writing char in output stream in comment.
     *
     * @param out    output stream
     * @param symbol input symbol
     * @throws WriterException exception
     */
    public void execute(final IWriter out, final char symbol) throws WriterException {
        handler.handle(symbol, indent, out);
    }
}
