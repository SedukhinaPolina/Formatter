package it.sevenbits.homework.states;

import it.sevenbits.homework.handlers.IndentMaker;
import it.sevenbits.homework.states.implementation.AfterSemicolonState;
import it.sevenbits.homework.states.implementation.CanBeCommentState;
import it.sevenbits.homework.states.implementation.CanBeEndOfMultilineCommentState;
import it.sevenbits.homework.states.implementation.CharQuoteState;
import it.sevenbits.homework.states.implementation.DefaultState;
import it.sevenbits.homework.states.implementation.LineCommentState;
import it.sevenbits.homework.states.implementation.MultilineCommentState;
import it.sevenbits.homework.states.implementation.QuoteState;

import java.util.HashMap;
import java.util.Map;

/**
 * Changes state on the received symbol.
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
        IState canBeCommentState = new CanBeCommentState(indent);
        IState lineCommentState = new LineCommentState(indent);
        IState multilineCommentState = new MultilineCommentState(indent);
        IState canBeEndOfMultilineCommentState = new CanBeEndOfMultilineCommentState(indent);
        map.put(new StateKey(defaultState, '\"'), quoteState);
        map.put(new StateKey(defaultState, '\''), charQuoteState);
        map.put(new StateKey(defaultState, ';'), afterSemicolonState);
        map.put(new StateKey(defaultState, '/'), canBeCommentState);
        map.put(new StateKey(quoteState, '\"'), defaultState);
        map.put(new StateKey(charQuoteState, '\''), defaultState);
        map.put(new StateKey(canBeCommentState, '/'), lineCommentState);
        map.put(new StateKey(canBeCommentState, '*'), multilineCommentState);
        map.put(new StateKey(lineCommentState, '\n'), defaultState);
        map.put(new StateKey(multilineCommentState, '*'), canBeEndOfMultilineCommentState);
        map.put(new StateKey(canBeEndOfMultilineCommentState, '/'), defaultState);
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
     * @param symbol current symbol
     * @return new state
     */
    public IState getNextState(final IState state, final Character symbol) {
        StateKey oldState = new StateKey(state, symbol);
        StateKey oldStateWithoutSymbol = new StateKey(state);
        if (map.containsKey(oldState)) {
            return map.get(oldState);
        }
        if (map.containsKey(oldStateWithoutSymbol)) {
            return map.get(oldStateWithoutSymbol);
        }
            return state;
    }

}
