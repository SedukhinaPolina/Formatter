package it.sevenbits.homework.states;

import it.sevenbits.homework.handlers.IndentMaker;
import it.sevenbits.homework.states.implementation.DefaultState;
import it.sevenbits.homework.states.implementation.QuoteState;
import it.sevenbits.homework.states.implementation.AfterSemicolonState;
import it.sevenbits.homework.states.implementation.CanBeCommentState;
import it.sevenbits.homework.states.implementation.CanBeEndOfMultilineCommentState;
import it.sevenbits.homework.states.implementation.CharQuoteState;
import it.sevenbits.homework.states.implementation.LineCommentState;
import it.sevenbits.homework.states.implementation.MultilineCommentState;
import java.util.HashMap;
import java.util.Map;

/**
 * Changes state on the received symbol.
 */
public class StateChanger {
    private Map<OldState, IState> map;
    private IState defaultState;

    /**
     * Constructor
     * @param indent current indent
     */
    public StateChanger(final IndentMaker indent) {
        map = new HashMap<OldState, IState>();
        defaultState = new DefaultState(indent);
        IState quoteState = new QuoteState(indent);
        IState charQuoteState = new CharQuoteState(indent);
        IState afterSemicolonState = new AfterSemicolonState(indent);
        IState canBeCommentState = new CanBeCommentState(indent);
        IState lineCommentState = new LineCommentState(indent);
        IState multilineCommentState = new MultilineCommentState(indent);
        IState canBeEndOfMultilineCommentState = new CanBeEndOfMultilineCommentState(indent);
        map.put(new OldState(defaultState, '\"'), quoteState);
        map.put(new OldState(defaultState, '\''), charQuoteState);
        map.put(new OldState(defaultState, ';'), afterSemicolonState);
        map.put(new OldState(defaultState, '/'), canBeCommentState);
        map.put(new OldState(quoteState, '\"'), defaultState);
        map.put(new OldState(charQuoteState, '\''), defaultState);
        map.put(new OldState(canBeCommentState, '/'), lineCommentState);
        map.put(new OldState(canBeCommentState, '*'), multilineCommentState);
        map.put(new OldState(lineCommentState, '\n'), defaultState);
        map.put(new OldState(multilineCommentState, '*'), canBeEndOfMultilineCommentState);
        map.put(new OldState(canBeEndOfMultilineCommentState, '/'), defaultState);
        map.put(new OldState(afterSemicolonState), defaultState);
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
        OldState oldState = new OldState(state, symbol);
        OldState oldStateWithoutSymbol = new OldState(state);
        if (map.containsKey(oldState)) {
            return map.get(oldState);
        }
        if (map.containsKey(oldStateWithoutSymbol)) {
            return map.get(oldStateWithoutSymbol);
        }
            return state;
    }

}
