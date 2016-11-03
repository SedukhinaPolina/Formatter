package it.sevenbits.homework.formatter.implementation;

import it.sevenbits.homework.reader.implementation.stringreader.StringReader;
import it.sevenbits.homework.writer.implementation.stringwriter.StringWriter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by polly on 02.11.16.
 */
public class FormatterTest {
    private Formatter formatter;

    @Before
    public void SetUp() {
        formatter = new Formatter();
    }

    @Test
    public void formatterTest() {
        StringReader in = new StringReader("{a;}");
        StringWriter out = new StringWriter("");
        formatter.format(in, out);
        assertEquals("wrong", " {\n" +
                "\ta;\n" +
                "}", out.getString());
    }

}
