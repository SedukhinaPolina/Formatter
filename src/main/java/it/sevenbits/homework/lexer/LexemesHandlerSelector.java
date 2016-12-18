package it.sevenbits.homework.lexer;

import it.sevenbits.homework.lexer.handlers.ILexemesHandler;
import it.sevenbits.homework.lexer.handlers.implementation.AddHandler;
import it.sevenbits.homework.lexer.handlers.implementation.ReturnHandler;
import it.sevenbits.homework.lexer.handlers.implementation.ReturnWithPreviousHandler;
import it.sevenbits.homework.lexer.handlers.implementation.SkipHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Select handler.
 */
public class LexemesHandlerSelector {
    private Map<LexemesHandlerKey, ILexemesHandler> map;

    /**
     * Constructor
     */
    public LexemesHandlerSelector() {
        map = new HashMap<LexemesHandlerKey, ILexemesHandler>();
        LexerState addState = new LexerState("add");
        LexerState returnState = new LexerState("return");
        LexerState returnWithPreviousState = new LexerState("return with previous");
        LexerState continueState = new LexerState("continue");
        LexerState skipState = new LexerState("skip");
        map.put(new LexemesHandlerKey(addState), new AddHandler());
        map.put(new LexemesHandlerKey(continueState), new AddHandler());
        map.put(new LexemesHandlerKey(skipState), new SkipHandler());
        map.put(new LexemesHandlerKey(returnState, '*'), new ReturnWithPreviousHandler());
        map.put(new LexemesHandlerKey(returnState, '/'), new ReturnWithPreviousHandler());
        map.put(new LexemesHandlerKey(returnState), new ReturnHandler());
        map.put(new LexemesHandlerKey(returnWithPreviousState), new ReturnWithPreviousHandler());

    }

    /**
     * Returns handler in the state
     * @param state current state
     * @param symbol symbol
     * @return handler
     */
    public ILexemesHandler getHandler(final LexerState state, final char symbol) {
        LexemesHandlerKey keyWithSymbol = new LexemesHandlerKey(state, symbol);
        if (map.containsKey(keyWithSymbol)) {
            return map.get(keyWithSymbol);
        }
        return map.get(new LexemesHandlerKey(state));
    }
}
