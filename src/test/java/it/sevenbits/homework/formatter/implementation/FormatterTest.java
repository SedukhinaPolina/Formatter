package it.sevenbits.homework.formatter.implementation;

import it.sevenbits.homework.formatter.FormatterException;
import it.sevenbits.homework.lexer.Token;
import it.sevenbits.homework.reader.IReader;
import it.sevenbits.homework.reader.ReaderException;
import it.sevenbits.homework.reader.implementation.filereader.FileReader;
import it.sevenbits.homework.reader.implementation.lexemesreader.Lexer;
import it.sevenbits.homework.reader.implementation.stringreader.StringReader;
import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.writer.WriterException;
import it.sevenbits.homework.writer.implementation.filewriter.FileWriter;
import it.sevenbits.homework.writer.implementation.stringwriter.StringWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

/**
 * Formatter class testing.
 */
public class FormatterTest {
    private Formatter formatter;

    @Before
    public void SetUp() throws WriterException, IOException, ReaderException {

        formatter = new Formatter();
    }

    @Test
    public void formatterTestBraces() throws FormatterException, WriterException, ReaderException {
        IReader<Token> lexer = new Lexer(new StringReader("{a;}"));
        StringWriter out = new StringWriter("");
        formatter.format(lexer, out);
        assertEquals("wrong"," {\n\ta;\n\t\n}\n", out.getString());
    }

    @Test
    public void formatterTestComment() throws FormatterException, WriterException, ReaderException {
        IReader<Token> lexer = new Lexer(new StringReader("//{}\n{}"));
        StringWriter out = new StringWriter("");
        formatter.format(lexer, out);
        assertEquals("wrong","//{}\n {\n\t\n}\n", out.getString());
    }


    @Test
    public void formatterTestQuote() throws FormatterException, WriterException, ReaderException {
        IReader<Token> lexer = new Lexer(new StringReader("{\"{}\"}"));
        StringWriter out = new StringWriter("");
        formatter.format(lexer, out);
        assertEquals("wrong"," {\n\t\"{}\"\n}\n", out.getString());
    }

    @Test
    public void formatterTestCharQuote() throws FormatterException, WriterException, ReaderException {
        IReader<Token> lexer = new Lexer(new StringReader("{'{'}"));
        StringWriter out = new StringWriter("");
        formatter.format(lexer, out);
        assertEquals("wrong"," {\n\t'{'\n}\n", out.getString());
    }

    @Test
    public void formatterTestSemicolonWithoutBrace() throws FormatterException, WriterException, ReaderException {
        IReader<Token> lexer = new Lexer(new StringReader("{a;b;}"));
        StringWriter out = new StringWriter("");
        formatter.format(lexer, out);
        assertEquals("wrong", " {\n\ta;\n\tb;\n\t\n}\n", out.getString());
    }

    @Test
    public void formatterTestWrongNumberOfBraces() throws FormatterException, WriterException, ReaderException {
        IReader<Token> lexer = new Lexer(new StringReader("{}}"));
        StringWriter out = new StringWriter("");
        formatter.format(lexer, out);
        assertEquals("wrong", " {\n\t\n}\n\n}\n", out.getString());
    }

    @Test (expected = FormatterException.class)
    public void formatterReaderExceptionTest() throws IOException, WriterException, ReaderException, FormatterException {
        File inFile = File.createTempFile("file", null);
        FileWriter out = new FileWriter(inFile.getAbsolutePath());
        FileReader in = new FileReader(inFile.getAbsolutePath());
        IReader<Token> lexer = new Lexer(in);
        in.close();
        formatter.format(lexer, out);
        fail();
    }

}
