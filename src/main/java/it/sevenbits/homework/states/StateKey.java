package it.sevenbits.homework.states;

/**
 * Data for the next state.
 */
public class StateKey {
    private IState oldState;
    private Character symbol;

    /**
     * Constructor.
     * @param state old state
     * @param symbol current symbol
     */
    public StateKey(final IState state, final Character symbol) {
        oldState = state;
        this.symbol = symbol;
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
                ((symbol != null) ? symbol.equals(oldState1.symbol) : (oldState1.symbol == null)));

    }

    @Override
    public int hashCode() {
        int result = oldState != null ? oldState.hashCode() : 0;
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        return result;
    }
}
