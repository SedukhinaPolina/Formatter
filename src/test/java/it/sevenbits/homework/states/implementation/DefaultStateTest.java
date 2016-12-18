package it.sevenbits.homework.states.implementation;

import it.sevenbits.homework.handlers.IndentMaker;
import it.sevenbits.homework.lexer.Token;
import it.sevenbits.homework.states.IState;
import it.sevenbits.homework.writer.WriterException;
import it.sevenbits.homework.writer.implementation.stringwriter.StringWriter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for DefaultState.
 */
public class DefaultStateTest {
    private IState state;
    private StringWriter out;
    private IndentMaker indent;

    @Test
    public void defaultStateWithOpenBraceTest() throws WriterException {
        indent = new IndentMaker();
        out = new StringWriter("");
        state = new DefaultState(indent);
        state.execute(out, new Token("{"));
        assertEquals("wrong", " {\n\t", out.getString());
    }

    @Test
    public void defaultStateWithCloseBraceTest() throws WriterException {
        indent = new IndentMaker();
        out = new StringWriter("");
        indent.setCountOfTabs(2);
        state = new DefaultState(indent);
        state.execute(out, new Token("}"));
        assertEquals("wrong", "\n\t}\n\t", out.getString());
    }

    @Test
    public void defaultStateWithNewLineTest() throws WriterException {
        indent = new IndentMaker();
        out = new StringWriter("");
        indent.setCountOfTabs(2);
        state = new DefaultState(indent);
        state.execute(out, new Token("\n"));
        assertEquals("wrong", "\n\t\t\n", out.getString());
    }

    @Test
    public void defaultStateTest() throws WriterException {
        indent = new IndentMaker();
        out = new StringWriter("");
        state = new DefaultState(indent);
        state.execute(out, new Token("a"));
        assertEquals("wrong", "a", out.getString());
    }

}
