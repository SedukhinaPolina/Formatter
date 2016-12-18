package it.sevenbits.homework.lexer;

import java.util.HashMap;
import java.util.Map;

/**
 * Change state when read tokens.
 */
public class LexerStateChanger {
    private Map<StateLexerKey, LexerState> map;
    private LexerState addState = new LexerState("add");

    /**
     * Constructor.
     */
    public LexerStateChanger() {
        map = new HashMap<StateLexerKey, LexerState>();
        LexerState skipState = new LexerState("skip");
        LexerState returnState = new LexerState("return");
        LexerState returnWithPreviousState = new LexerState("return with previous");
        LexerState continueState = new LexerState("continue");
        map.put(new StateLexerKey(skipState, ' '), skipState);
        map.put(new StateLexerKey(skipState, '\n'), skipState);
        map.put(new StateLexerKey(returnState), addState);
        map.put(new StateLexerKey(returnWithPreviousState), addState);
        map.put(new StateLexerKey(skipState), returnState);
        map.put(new StateLexerKey(addState, '{'), returnState);
        map.put(new StateLexerKey(addState, '}'), returnState);
        map.put(new StateLexerKey(addState, '('), returnState);
        map.put(new StateLexerKey(addState, ')'), returnState);
        map.put(new StateLexerKey(addState, ';'), returnState);
        map.put(new StateLexerKey(addState, ' '), returnState);
        map.put(new StateLexerKey(addState, '\n'), returnState);
        map.put(new StateLexerKey(addState, '"'), returnState);
        map.put(new StateLexerKey(addState, '\''), returnState);
        map.put(new StateLexerKey(addState, '/'), continueState);
        map.put(new StateLexerKey(addState, '*'), continueState);

        map.put(new StateLexerKey(continueState, '*'), returnWithPreviousState);
        map.put(new StateLexerKey(continueState, '/'), returnWithPreviousState);
    }

    /**
     * Init state
     * @return default state
     */
    public LexerState initState() {
        return addState;
    }
    /**
     * Get next state
     * @param state current state
     * @param symbol symbol
     * @return next state
     */
    public LexerState getNextState(final LexerState state, final Character symbol) {
        if (map.containsKey(new StateLexerKey(state, symbol))) {
            return map.get(new StateLexerKey(state, symbol));
        }
        return addState;
    }
}
