package it.sevenbits.homework.reader.implementation.lexemesreader;

import it.sevenbits.homework.lexer.LexemesHandlerSelector;
import it.sevenbits.homework.lexer.LexerState;
import it.sevenbits.homework.lexer.Token;
import it.sevenbits.homework.reader.IReader;
import it.sevenbits.homework.reader.ReaderException;
import it.sevenbits.homework.lexer.LexerStateChanger;

/**
 * Read tokens.
 */
public class Lexer implements IReader<Token> {
    private IReader<Character> in;
    private StringBuilder lexeme = new StringBuilder();
    private LexerState state;
    private LexerStateChanger stateChanger;
    private LexemesHandlerSelector handlerSelector;
    /**
     * Constructor
     * @param in input stream
     */
    public Lexer(final IReader<Character> in) {
        this.in = in;
        stateChanger = new LexerStateChanger();
        state = stateChanger.initState();
        handlerSelector = new LexemesHandlerSelector();
    }
    /**
     * Reads one character.
     *
     * @return character
     * @throws ReaderException exception
     */
    public Token read() throws ReaderException {
        if (state.equals(new LexerState("return"))) {
            return new Token(lexeme.toString());
        }
        while (!in.isEnd()) {
            Character temp = in.read();
            state = stateChanger.getNextState(state, temp);
            if (handlerSelector.getHandler(state).execute(lexeme, temp)) {
                return new Token(lexeme.toString());
            }
        }
        return new Token("");
    }

    /**
     * The end of the file verification.
     *
     * @return true if the end of the file
     * @throws ReaderException exception
     */
    public boolean isEnd() throws ReaderException {
        return in.isEnd();
    }
}
