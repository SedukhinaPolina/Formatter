package it.sevenbits.homework.formatter.implementation;

import it.sevenbits.homework.formatter.FormatterException;
import it.sevenbits.homework.reader.ReaderException;
import it.sevenbits.homework.reader.implementation.filereader.FileReader;
import it.sevenbits.homework.reader.implementation.stringreader.StringReader;
import it.sevenbits.homework.writer.WriterException;
import it.sevenbits.homework.writer.implementation.filewriter.FileWriter;
import it.sevenbits.homework.writer.implementation.stringwriter.StringWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
    public void formatterTest() throws FormatterException {
        StringReader in = new StringReader("{abc;}");
        StringWriter out = new StringWriter("");
        formatter.format(in, out);
        assertEquals("wrong"," {\n\tabc;\n\t}\n", out.getString());
    }

    @Test
    public void formatterWrongBracesTest() throws FormatterException {
        StringReader in = new StringReader("{}}");
        StringWriter out = new StringWriter("");
        formatter.format(in, out);
        assertEquals("wrong"," {\n\t}\n}\nerror: incorrect number of braces", out.getString());
    }


    @Test (expected = FormatterException.class)
    public void formatterReaderExceptionTest() throws IOException, WriterException, ReaderException, FormatterException {

        File inFile = File.createTempFile("file", null);
        FileWriter out = new FileWriter(inFile.getAbsolutePath());
        FileReader in = new FileReader(inFile.getAbsolutePath());
        in.close();
        formatter.format(in, out);
        fail();
    }
}
