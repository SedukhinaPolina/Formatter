package it.sevenbits.homework.states;

import it.sevenbits.homework.lexer.Token;

/**
 * Data for the next state.
 */
public class StateKey {
    private IState oldState;
    private Token token;

    /**
     * Constructor.
     * @param state old state
     * @param token current token
     */
    public StateKey(final IState state, final Token token) {
        oldState = state;
        this.token = token;
    }

    /**
     * Constructor.
     * @param state old state
     */
    public StateKey(final IState state) {
        oldState = state;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StateKey oldState1 = (StateKey) o;
        return (oldState != null) ? oldState.equals(oldState1.oldState) : ((oldState1.oldState == null) &&
                ((token != null) ? token.equals(oldState1.token) : (oldState1.token == null)));

    }

    @Override
    public int hashCode() {
        int result = oldState != null ? oldState.hashCode() : 0;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }
}
