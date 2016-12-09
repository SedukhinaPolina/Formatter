package it.sevenbits.homework.states.implementation;

import it.sevenbits.homework.handlers.IHandler;
import it.sevenbits.homework.handlers.IndentMaker;
import it.sevenbits.homework.handlers.implementation.CloseBraceHandler;
import it.sevenbits.homework.handlers.implementation.NewLineHandler;
import it.sevenbits.homework.lexer.Token;
import it.sevenbits.homework.states.IState;
import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.writer.WriterException;

import java.util.HashMap;
import java.util.Map;

/**
 * If was semicolon.
 */
public class AfterSemicolonState implements IState {
    private Map<Token, IHandler> map;
    private IndentMaker indent;
    private IHandler newLineHandler;

    /**
     * Constructor
     * @param indent is current indent
     */
    public AfterSemicolonState(final IndentMaker indent) {
        map = new HashMap<Token, IHandler>();
        map.put(new Token("}"), new CloseBraceHandler());
        newLineHandler = new NewLineHandler();
        this.indent = indent;
    }

    /**
     * Method for writing char in output stream after semicolon.
     *
     * @param out    output stream
     * @param token input token
     * @throws WriterException exception
     */
    public void execute(final IWriter<String> out, final Token token) throws WriterException {
        if (map.containsKey(token)) {
            map.get(token).handle(token, indent, out);
            return;
        }
        newLineHandler.handle(token, indent, out);
    }

}
