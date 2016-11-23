package it.sevenbits.homework.states;

import it.sevenbits.homework.handlers.IndentMaker;
import it.sevenbits.homework.states.implementation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Changes state on the received symbol.
 */
public class StateChanger {
    private Map<OldState, IState> map;
    private IndentMaker indent;

    /**
     * Constructor
     */
    public StateChanger() {
        indent = new IndentMaker();
        map = new HashMap<OldState, IState>();
        IState defaultState = new DefaultState(indent);
        IState quoteState = new QuoteState();
        IState charQuoteState = new CharQuoteState();
        IState afterSemicolonState = new AfterSemicolonState(indent);
        IState canBeCommentState = new CanBeCommentState();
        IState lineCommentState = new LineCommentState();
        IState multilineCommentState = new MultilineCommentState();
        IState canBeEndOfMultilineCommentState = new CanBeEndOfMultilineCommentState();
        map.put(new OldState(defaultState, '"'), quoteState);
        map.put(new OldState(defaultState, '\''), charQuoteState);
        map.put(new OldState(defaultState, ';'), afterSemicolonState);
        map.put(new OldState(defaultState, '/'), canBeCommentState);
        map.put(new OldState(quoteState, '"'), defaultState);
        map.put(new OldState(charQuoteState, '\''), defaultState);
        map.put(new OldState(canBeCommentState, '/'), lineCommentState);
        map.put(new OldState(canBeCommentState, '*'), multilineCommentState);
        map.put(new OldState(lineCommentState, '\n'), defaultState);
        map.put(new OldState(multilineCommentState, '*'), canBeEndOfMultilineCommentState);
        map.put(new OldState(canBeEndOfMultilineCommentState, '/'), defaultState);
    }

    /**
     * Returns new state
     * @param state old state
     * @param symbol current symbol
     * @return new state
     */
    public IState getNextState(final IState state, final Character symbol) {
        OldState oldState = new OldState(state, symbol);
        if (map.containsKey(oldState)) {
            return map.get(oldState);
        }
            return state;
    }
}
