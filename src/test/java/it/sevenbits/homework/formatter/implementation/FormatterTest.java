package it.sevenbits.homework.formatter.implementation;

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
    public void formatterTest() {
        StringReader in = new StringReader("{abc;}");
        StringWriter out = new StringWriter("");
        formatter.format(in, out);
        assertEquals("wrong"," {\n\tabc;\n\t}\n", out.getString());
    }

    @Test
    public void formatterWrongBracesTest() {
        StringReader in = new StringReader("{}}");
        StringWriter out = new StringWriter("");
        formatter.format(in, out);
        assertEquals("wrong"," {\n\t}\n}\nerror: incorrect number of braces", out.getString());
    }


    @Test (expected = ReaderException.class)
    public void formatterReaderExceptionTest() throws IOException, WriterException, ReaderException {

        File inFile = File.createTempFile("file", null);
        FileWriter out = new FileWriter(inFile.getAbsolutePath());
        FileReader in = new FileReader("in");
        in.close();
        formatter.format(in, out);
    }

    /*@Test (expected = WriterException.class)
    public void formatterWriterExceptionTest() throws IOException, WriterException, ReaderException {
        File inFile = File.createTempFile("file", null);
        FileWriter out = new FileWriter("in");
        FileReader in = new FileReader(inFile.getAbsolutePath());
        out.close();
        formatter.format(in, out);
        fail();
    }*/
}
