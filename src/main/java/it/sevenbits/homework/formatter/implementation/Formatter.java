package it.sevenbits.homework.formatter.implementation;

import it.sevenbits.homework.formatter.FormatterException;
import it.sevenbits.homework.formatter.IFormatter;
import it.sevenbits.homework.handlers.IndentMaker;
import it.sevenbits.homework.lexer.Token;
import it.sevenbits.homework.reader.ReaderException;
import it.sevenbits.homework.states.IState;
import it.sevenbits.homework.states.StateChanger;
import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.reader.IReader;
import it.sevenbits.homework.writer.WriterException;


/**
 * Formats data received from string.
 */
public class Formatter implements IFormatter {

    private IndentMaker indentMaker;
    private StateChanger stateChanger;

    /**
     * Default constructor
     */
    public Formatter() {
        indentMaker = new IndentMaker();
        stateChanger = new StateChanger(indentMaker);
    }
    /**
     * Format string.
     * @param in input string
     * @param out output string
     * @throws FormatterException exception
     */
    public void format(final IReader<Token> in, final IWriter<String> out) throws FormatterException {
        try {
            indentMaker.setCountOfTabs(0);
            IState state = stateChanger.initState();
            Token temp;
            while (!in.isEnd()) {
                temp = in.read();
                state.execute(out, temp);
                state = stateChanger.getNextState(state, temp);
            }
        } catch (ReaderException e) {
            throw new FormatterException(e);
        } catch (WriterException e) {
            throw new FormatterException(e);
        }
    }
}
