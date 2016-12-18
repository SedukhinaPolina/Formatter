package it.sevenbits.homework.lexer;

/**
 * Key for the next handler.
 */
public class LexemesHandlerKey {
    private LexerState state;
    private Character symbol;

    /**
     * Constructor
     * @param symbol input symbol
     * @param state current state
     */
    public LexemesHandlerKey(final LexerState state, final char symbol) {
        this.symbol = symbol;
        this.state = state;
    }

    /**
     * Constructor
     * @param state current state
     */
    public LexemesHandlerKey(final LexerState state) {
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

        LexemesHandlerKey that = (LexemesHandlerKey) o;

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
