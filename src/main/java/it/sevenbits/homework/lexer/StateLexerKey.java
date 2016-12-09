package it.sevenbits.homework.lexer;

/**
 * Created by polly on 09.12.16.
 */
public class StateLexerKey {
    private LexerState state;
    private Character symbol;

    public StateLexerKey(LexerState state) {
        this.state = state;
    }

    public StateLexerKey(LexerState state, Character symbol) {
        this.state = state;
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StateLexerKey that = (StateLexerKey) o;

        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        return symbol != null ? symbol.equals(that.symbol) : that.symbol == null;

    }

    @Override
    public int hashCode() {
        int result = state != null ? state.hashCode() : 0;
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        return result;
    }
}
