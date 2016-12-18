package it.sevenbits.homework.lexer;

/**
 * Data for the next state.
 */
public class StateLexerKey {
    private LexerState state;
    private Character symbol;

    /**
     * constructor
     * @param state state
     */
    public StateLexerKey(final LexerState state) {
        this.state = state;
    }

    /**
     * constructor
     * @param state state
     * @param symbol symbol
     */
    public StateLexerKey(final LexerState state, final Character symbol) {
        this.state = state;
        this.symbol = symbol;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StateLexerKey that = (StateLexerKey) o;

        return (state != null) ? state.equals(that.state) : ((that.state == null) &&
                ((symbol != null) ? symbol.equals(that.symbol) : (that.symbol == null)));

    }

    @Override
    public int hashCode() {
        int result = state != null ? state.hashCode() : 0;
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        return result;
    }
}
