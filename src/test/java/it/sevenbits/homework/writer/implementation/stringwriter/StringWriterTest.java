package it.sevenbits.homework.writer.implementation.stringwriter;

import it.sevenbits.homework.writer.WriterException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * StringWriter class testing.
 */
public class StringWriterTest {
    private StringWriter writer;

    @Before
    public void SetUp() {
        writer = new StringWriter("");
    }

    @Test
    public void writeTest() throws WriterException {
        writer.write("abc");
        assertEquals("wrong", "abc", writer.getString());
    }
}
