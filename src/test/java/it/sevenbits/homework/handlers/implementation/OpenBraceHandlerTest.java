package it.sevenbits.homework.handlers.implementation;

import it.sevenbits.homework.formatter.FormatterException;
import it.sevenbits.homework.handlers.IHandler;
import it.sevenbits.homework.handlers.IndentMaker;
import it.sevenbits.homework.lexer.Token;
import it.sevenbits.homework.reader.IReader;
import it.sevenbits.homework.reader.ReaderException;
import it.sevenbits.homework.reader.implementation.lexemesreader.Lexer;
import it.sevenbits.homework.reader.implementation.stringreader.StringReader;
import it.sevenbits.homework.writer.WriterException;
import it.sevenbits.homework.writer.implementation.stringwriter.StringWriter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for OpenBraceHandler.
 */
public class OpenBraceHandlerTest {
    private StringReader in;
    private StringWriter out;
    private IHandler handler;
    private IndentMaker indent;

    @Test
    public void openBraceHandlerTest() throws WriterException, ReaderException, FormatterException {
        indent = new IndentMaker();
        IReader<Token> lexer = new Lexer(new StringReader("{"));
        out = new StringWriter("");
        handler = new OpenBraceHandler();
        handler.handle(lexer.read(), indent, out);
        assertEquals("wrong", " {\n\t", out.getString());
    }
}
