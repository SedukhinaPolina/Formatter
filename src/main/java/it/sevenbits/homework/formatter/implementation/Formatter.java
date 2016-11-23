package it.sevenbits.homework.formatter.implementation;

import it.sevenbits.homework.formatter.FormatterException;
import it.sevenbits.homework.formatter.IFormatter;
import it.sevenbits.homework.handlers.IndentMaker;
import it.sevenbits.homework.reader.ReaderException;
import it.sevenbits.homework.states.IState;
import it.sevenbits.homework.states.StateChanger;
import it.sevenbits.homework.states.implementation.DefaultState;
import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.reader.IReader;
import it.sevenbits.homework.writer.WriterException;


/**
 * Formats data received from string.
 */
public class Formatter implements IFormatter {

    private IndentMaker indentMaker;
    private IState state;
    private StateChanger stateChanger;

    /**
     * Default constructor
     */
    public Formatter() {
        indentMaker = new IndentMaker();
        state = new DefaultState(indentMaker);
        stateChanger = new StateChanger();
    }
    /**
     * Format string.
     * @param in input string
     * @param out output string
     * @throws FormatterException exception
     * @throws ReaderException exception
     * @throws WriterException exception
     */
    public void format(final IReader in, final IWriter out) throws FormatterException, ReaderException, WriterException {
        try {
            char temp;
            while (!in.isEnd()) {
                temp = in.read();
                state.execute(out, temp);
                state = stateChanger.getNextState(state, temp);
            }
        } catch (ReaderException e) {
            throw new FormatterException(e);
        }
    }
}
