package it.sevenbits.homework.states.implementation;

import it.sevenbits.homework.handlers.IndentMaker;
import it.sevenbits.homework.lexer.Token;
import it.sevenbits.homework.states.IState;
import it.sevenbits.homework.writer.WriterException;
import it.sevenbits.homework.writer.implementation.stringwriter.StringWriter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for AfterSemicolonState.
 */
public class AfterSemicolonStateTest {
    private IState state;
    private StringWriter out;
    IndentMaker indent;

    @Test
    public void afterSemicolonStateTest() throws WriterException {
        indent = new IndentMaker();
        indent.setCountOfTabs(2);
        out = new StringWriter("");
        state = new AfterSemicolonState(indent);
        state.execute(out, new Token("a"));
        assertEquals("wrong", "\n\t\ta", out.getString());
    }

    @Test
    public void afterSemicolonStateTestWithCloseBrace() throws WriterException {
        indent = new IndentMaker();
        indent.setCountOfTabs(2);
        out = new StringWriter("");
        state = new AfterSemicolonState(indent);
        state.execute(out, new Token("}"));
        assertEquals("wrong", "\n\t}\n\t", out.getString());
    }
}
