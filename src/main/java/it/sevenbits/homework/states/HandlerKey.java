package it.sevenbits.homework.states;


import it.sevenbits.homework.lexer.Token;

/**
 * Data for select handler.
 */
public class HandlerKey {
    private IState state;
    private Token token;

    /**
     * Constructor
     * @param state current state
     * @param token input token
     */
    HandlerKey(final IState state, final Token token) {
        this.state = state;
        this.token = token;
    }

    /**
     * Constructor
     * @param state current state
     */
    HandlerKey(final IState state) {
        this.state = state;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HandlerKey that = (HandlerKey) o;

        return (state != null) ? state.equals(that.state) : ((that.state == null) &&
                ((token != null) ? token.equals(that.token) : (that.token == null)));

    }

    @Override
    public int hashCode() {
        int result = state != null ? state.hashCode() : 0;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }
}
