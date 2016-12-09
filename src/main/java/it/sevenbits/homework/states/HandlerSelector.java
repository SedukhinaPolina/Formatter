package it.sevenbits.homework.states;

import it.sevenbits.homework.handlers.IHandler;
import it.sevenbits.homework.handlers.IndentMaker;
import it.sevenbits.homework.handlers.implementation.CharHandler;
import it.sevenbits.homework.handlers.implementation.CloseBraceHandler;
import it.sevenbits.homework.handlers.implementation.NewLineHandler;
import it.sevenbits.homework.handlers.implementation.OpenBraceHandler;
import it.sevenbits.homework.lexer.Token;
import it.sevenbits.homework.states.implementation.AfterSemicolonState;
import it.sevenbits.homework.states.implementation.CharQuoteState;
import it.sevenbits.homework.states.implementation.DefaultState;
import it.sevenbits.homework.states.implementation.LineCommentState;
import it.sevenbits.homework.states.implementation.MultilineCommentState;
import it.sevenbits.homework.states.implementation.QuoteState;

import java.util.HashMap;
import java.util.Map;

/**
 * Select handler.
 */
public class HandlerSelector {
    private Map<HandlerKey, IHandler> map;

    /**
     * Constructor
     */
    public HandlerSelector(final IndentMaker indent) {
        map = new HashMap<HandlerKey, IHandler>();
        IHandler closeBraceHandler = new CloseBraceHandler();
        IHandler newLineHandler = new NewLineHandler();
        IHandler charHandler = new CharHandler();
        IHandler openBraceHandler = new OpenBraceHandler();
        IState afterSemicolonState = new AfterSemicolonState(indent);
        IState charQuoteState = new CharQuoteState(indent);
        IState defaultState = new DefaultState(indent);
        IState lineCommentState = new LineCommentState(indent);
        IState multilineCommentState = new MultilineCommentState(indent);
        IState quoteState = new QuoteState(indent);
        map.put(new HandlerKey(afterSemicolonState, new Token("}")), closeBraceHandler);
        map.put(new HandlerKey(defaultState, new Token("{")), openBraceHandler);
        map.put(new HandlerKey(afterSemicolonState), newLineHandler);
        map.put(new HandlerKey(charQuoteState), charHandler);
        map.put(new HandlerKey(defaultState, new Token("}")), closeBraceHandler);
        map.put(new HandlerKey(defaultState, new Token("\n")), newLineHandler);
        map.put(new HandlerKey(defaultState), charHandler);
        map.put(new HandlerKey(lineCommentState), charHandler);
        map.put(new HandlerKey(multilineCommentState), charHandler);
        map.put(new HandlerKey(quoteState), charHandler);
    }

    /**
     * Get handler
     * @param state current state
     * @param token input token
     * @return handler
     */
    public IHandler getHandler(final IState state, final Token token) {
        HandlerKey key = new HandlerKey(state, token);
        HandlerKey keyWithoutSymbol = new HandlerKey(state);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return map.get(keyWithoutSymbol);

    }
}
