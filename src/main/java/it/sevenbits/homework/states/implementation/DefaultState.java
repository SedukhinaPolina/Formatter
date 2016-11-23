package it.sevenbits.homework.states.implementation;

import it.sevenbits.homework.handlers.IHandler;
import it.sevenbits.homework.handlers.IndentMaker;
import it.sevenbits.homework.handlers.implementation.*;
import it.sevenbits.homework.states.IState;
import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.writer.WriterException;

import java.util.HashMap;
import java.util.Map;

/**
 * Default state.
 */
public class DefaultState implements IState {

    private Map<Character, IHandler> map;
    private IndentMaker indent;
    private IHandler charHandler;

    /**
     * Constructor
     * @param indent is current indent
     */
    public DefaultState(final IndentMaker indent) {
        map = new HashMap<Character, IHandler>();
        map.put('{', new OpenBraceHandler());
        map.put('}', new CloseBraceHandler());
        map.put('\n', new NewLineHandler());
        map.put(';', new SemicolonHandler());
        charHandler = new CharHandler();
        this.indent = indent;
    }

    /**
     * Method for writing char in output stream in some state.
     *
     * @param out    output stream
     * @param symbol input symbol
     * @throws WriterException exception
     */
    public void execute(final IWriter out, final char symbol) throws WriterException {
        if (map.containsKey(symbol)) {
            map.get(symbol).handle(symbol, indent, out);
            return;
        }
        charHandler.handle(symbol, indent, out);
    }
}
