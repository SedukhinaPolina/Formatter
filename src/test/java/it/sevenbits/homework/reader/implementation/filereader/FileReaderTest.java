package it.sevenbits.homework.reader.implementation.filereader;

import it.sevenbits.homework.reader.ReaderException;
import it.sevenbits.homework.writer.WriterException;
import it.sevenbits.homework.writer.implementation.filewriter.FileWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * FileReader class testing.
 */
public class FileReaderTest {
    private FileReader in;
    private FileWriter out;

    @Before
    public void SetUp() throws WriterException, IOException, ReaderException {
        File inFile = File.createTempFile("file", null);
        out = new FileWriter(inFile.getAbsolutePath());
        in = new FileReader(inFile.getAbsolutePath());

    }

    @Test
    public void readTest() throws WriterException, ReaderException, FileNotFoundException {
        out.write("b");
        assertEquals("wrong", 'b', in.read());
    }

    @Test
    public void isEndTest() throws ReaderException, WriterException {
        out.write("a");
        while(!in.isEnd()) {
            in.read();
        }
        assertEquals("wrong", true, in.isEnd());
    }

    @Test(expected = ReaderException.class)
    public void closeReaderExceptionTest() throws ReaderException {
        in.close();
        in.read();
        fail();
    }
}
