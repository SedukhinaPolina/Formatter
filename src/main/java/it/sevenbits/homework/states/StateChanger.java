package it.sevenbits.homework.states;

import it.sevenbits.homework.handlers.IndentMaker;
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
 * Changes state on the received token.
 */
public class StateChanger {
    private Map<StateKey, IState> map;
    private IState defaultState;

    /**
     * Constructor
     * @param indent current indent
     */
    public StateChanger(final IndentMaker indent) {
        map = new HashMap<StateKey, IState>();
        defaultState = new DefaultState(indent);
        IState quoteState = new QuoteState(indent);
        IState charQuoteState = new CharQuoteState(indent);
        IState afterSemicolonState = new AfterSemicolonState(indent);
        IState lineCommentState = new LineCommentState(indent);
        IState multilineCommentState = new MultilineCommentState(indent);
        map.put(new StateKey(defaultState, new Token("\"")), quoteState);
        map.put(new StateKey(defaultState, new Token("\'")), charQuoteState);
        map.put(new StateKey(defaultState, new Token(";")), afterSemicolonState);
        map.put(new StateKey(quoteState, new Token("\"")), defaultState);
        map.put(new StateKey(charQuoteState, new Token("\'")), defaultState);
        map.put(new StateKey(lineCommentState, new Token("\n")), defaultState);
        map.put(new StateKey(defaultState, new Token("//")), lineCommentState);
        map.put(new StateKey(defaultState, new Token("/*")), multilineCommentState);
        map.put(new StateKey(multilineCommentState, new Token("*/")), defaultState);
        map.put(new StateKey(afterSemicolonState), defaultState);
    }


    /**
     * Initializes state
     * @return default State
     */

    public IState initState() {
        return defaultState;
    }

    /**
     * Returns new state
     * @param state old state
     * @param token current token
     * @return new state
     */
    public IState getNextState(final IState state, final Token token) {
        StateKey oldState = new StateKey(state, token);
        StateKey oldStateWithoutToken = new StateKey(state);
        if (map.containsKey(oldState)) {
            return map.get(oldState);
        }
        if (map.containsKey(oldStateWithoutToken)) {
            return map.get(oldStateWithoutToken);
        }
            return state;
    }

}
