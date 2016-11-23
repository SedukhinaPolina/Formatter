package it.sevenbits.homework.states;

/**
 * Data for the next state.
 */
public class OldState {
    private IState oldState;
    private Character symbol;

    /**
     * Constructor.
     * @param state old state
     * @param symbol current symbol
     */
    public OldState(final IState state, final Character symbol) {
        oldState = state;
        this.symbol = symbol;
    }

    /**
     * Constructor.
     * @param state old state
     */
    public OldState(final IState state) {
        oldState = state;
    }
}
