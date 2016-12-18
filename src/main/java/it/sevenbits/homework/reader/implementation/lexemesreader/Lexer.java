package it.sevenbits.homework.reader.implementation.lexemesreader;

import it.sevenbits.homework.lexer.LexemesHandlerSelector;
import it.sevenbits.homework.lexer.LexerState;
import it.sevenbits.homework.lexer.LexerStateChanger;
import it.sevenbits.homework.lexer.Token;
import it.sevenbits.homework.reader.IReader;
import it.sevenbits.homework.reader.ReaderException;

/**
 * Read tokens.
 */
public class Lexer implements IReader<Token> {
    private IReader<Character> in;
    private StringBuilder lexeme = new StringBuilder();
    private LexerState state;
    private LexerStateChanger stateChanger;
    private LexemesHandlerSelector handlerSelector;
    private Character temp;
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
            state = stateChanger.initState();
            return new Token(lexeme.toString());
        }
        lexeme = new StringBuilder("");
        while (!in.isEnd()) {
            temp = in.read();
            state = stateChanger.getNextState(state, temp);
            handlerSelector.getHandler(state, temp).execute(lexeme, temp);
            if (handlerSelector.getHandler(state, temp).isEndOfToken()) {
                String token = lexeme.toString();
                lexeme = new StringBuilder(temp + "");
                return new Token(token);
            }
        }
        return new Token(lexeme.toString());
    }

    /**
     * The end of the file verification.
     *
     * @return true if the end of the file
     * @throws ReaderException exception
     */
    public boolean isEnd() throws ReaderException {
        return in.isEnd() && lexeme.toString().equals("");
    }
}
