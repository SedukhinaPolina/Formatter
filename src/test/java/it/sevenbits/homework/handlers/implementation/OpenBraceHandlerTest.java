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
 * Tests for OpenBraceHandler.
 */
public class OpenBraceHandlerTest {
    private StringReader in;
    private StringWriter out;
    private IHandler handler;
    private IndentMaker indent;

    /*@Test
    public void openBraceHandlerTest() throws WriterException, ReaderException, FormatterException {
        indent = new IndentMaker();
        in = new StringReader("{");
        out = new StringWriter("");
        handler = new OpenBraceHandler();
        handler.handle(in.read(), indent, out);
        assertEquals("wrong", " {\n\t", out.getString());
    }*/
}
