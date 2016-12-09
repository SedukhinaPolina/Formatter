package it.sevenbits.homework.handlers.implementation;

import it.sevenbits.homework.formatter.FormatterException;
import it.sevenbits.homework.handlers.IHandler;
import it.sevenbits.homework.handlers.IndentMaker;
import it.sevenbits.homework.reader.ReaderException;
import it.sevenbits.homework.reader.implementation.stringreader.StringReader;
import it.sevenbits.homework.writer.WriterException;
import it.sevenbits.homework.writer.implementation.stringwriter.StringWriter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for CharHandler.
 */
public class CharHandlerTest {
    private StringReader in;
    private StringWriter out;
    private IHandler handler;
    private IndentMaker indent;

    /*@Test
    public void charHandlerTest() throws WriterException, ReaderException, FormatterException {
        in = new StringReader("a");
        out = new StringWriter("");
        handler = new CharHandler();
        handler.handle(in.read(), new IndentMaker(), out);
        assertEquals("wrong", "a", out.getString());
    }*/
}
