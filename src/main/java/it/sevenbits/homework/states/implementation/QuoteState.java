package it.sevenbits.homework.states.implementation;

import it.sevenbits.homework.handlers.IHandler;
import it.sevenbits.homework.handlers.IndentMaker;
import it.sevenbits.homework.handlers.implementation.CharHandler;
import it.sevenbits.homework.lexer.Token;
import it.sevenbits.homework.states.IState;
import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.writer.WriterException;

/**
 * State in "".
 */
public class QuoteState implements IState {
    private IHandler handler;
    private IndentMaker indent;
    /**
     * Default constructor.
     * @param indent current indent
     */
    public QuoteState(final IndentMaker indent) {
        handler = new CharHandler();
        this.indent = indent;
    }
    /**
     * Method for writing char in output stream in "".
     *
     * @param out    output stream
     * @param token input token
     * @throws WriterException exception
     */
    public void execute(final IWriter<String> out, final Token token) throws WriterException {
        handler.handle(token, indent, out);
    }
}
