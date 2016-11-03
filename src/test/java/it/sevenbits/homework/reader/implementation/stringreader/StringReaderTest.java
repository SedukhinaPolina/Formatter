package it.sevenbits.homework.reader.implementation.stringreader;

import it.sevenbits.homework.reader.IReader;
import it.sevenbits.homework.reader.ReaderException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * StringReader class testing.
 */
public class StringReaderTest {
    private IReader reader;

    @Before
    public void SetUp() {
        reader = new StringReader("abc");
    }

    @Test
    public void readTest() throws ReaderException {
        assertEquals("wrong", 'a', reader.read());
    }

    @Test
    public void isEndTest() throws ReaderException {
        assertEquals("wrong", false, reader.isEnd());
    }

}
