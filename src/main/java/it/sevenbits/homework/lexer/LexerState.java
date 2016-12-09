package it.sevenbits.homework.lexer;

/**
 * States in parsing.
 */
public class LexerState {
    private String state;

    /**
     * constructor
     * @param state state
     */
    public LexerState(final String state) {
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

        LexerState that = (LexerState) o;

        return state.equals(that.state);

    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }
}
