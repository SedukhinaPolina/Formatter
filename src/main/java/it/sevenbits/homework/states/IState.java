package it.sevenbits.homework.states;

import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.writer.WriterException;

/**
 * Interface.
 */
public interface IState {
    /**
     * Method for writing char in output stream in some state.
     * @param out output stream
     * @param symbol input symbol
     * @throws WriterException exception
     */
    void execute(IWriter<String> out, char symbol) throws WriterException;
}
