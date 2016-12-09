package it.sevenbits.homework.lexer;

import it.sevenbits.homework.lexer.handlers.ILexemesHandler;
import it.sevenbits.homework.lexer.handlers.implementation.AddHandler;
import it.sevenbits.homework.lexer.handlers.implementation.ReturnHandler;
import it.sevenbits.homework.lexer.handlers.implementation.SkipHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Select handler.
 */
public class LexemesHandlerSelector {
    private Map<LexerState, ILexemesHandler> map;

    /**
     * Constructor
     */
    public LexemesHandlerSelector() {
        map = new HashMap<LexerState, ILexemesHandler>();
        LexerState addState = new LexerState("add");
        LexerState returnState = new LexerState("return");
        LexerState continueState = new LexerState("continue");
        LexerState skipState = new LexerState("skip");
        map.put(addState, new AddHandler());
        map.put(continueState, new AddHandler());
        map.put(skipState, new SkipHandler());
        map.put(returnState, new ReturnHandler());
    }

    /**
     * Returns handler in the state
     * @param state current state
     * @return handler
     */
    public ILexemesHandler getHandler(final LexerState state) {
        return map.get(state);
    }
}
