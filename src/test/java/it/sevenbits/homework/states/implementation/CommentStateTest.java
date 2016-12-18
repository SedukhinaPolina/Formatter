package it.sevenbits.homework.states.implementation;

import com.sun.org.apache.bcel.internal.generic.IREM;
import it.sevenbits.homework.formatter.FormatterException;
import it.sevenbits.homework.formatter.IFormatter;
import it.sevenbits.homework.formatter.implementation.Formatter;
import it.sevenbits.homework.handlers.IndentMaker;
import it.sevenbits.homework.lexer.Token;
import it.sevenbits.homework.reader.IReader;
import it.sevenbits.homework.reader.ReaderException;
import it.sevenbits.homework.reader.implementation.lexemesreader.Lexer;
import it.sevenbits.homework.reader.implementation.stringreader.StringReader;
import it.sevenbits.homework.states.IState;
import it.sevenbits.homework.writer.WriterException;
import it.sevenbits.homework.writer.implementation.stringwriter.StringWriter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for all comment states.
 */
public class CommentStateTest {
    IFormatter formatter;
    private StringWriter out;

    @Before
    public void setUp() {
        formatter = new Formatter();
    }

    @Test
    public void lineCommentStateTest() throws WriterException, FormatterException, ReaderException {
        IReader<Token> lexer = new Lexer(new StringReader("//a;"));
        out = new StringWriter("");
        formatter.format(lexer, out);
        assertEquals("wrong", "//a;", out.getString());
    }

    @Test
    public void multilineCommentStateTest() throws WriterException, FormatterException, ReaderException {
        IReader<Token> lexer = new Lexer(new StringReader("/*a;*/"));
        out = new StringWriter("");
        formatter.format(lexer, out);
        assertEquals("wrong", "/*a;*/", out.getString());
    }
}
