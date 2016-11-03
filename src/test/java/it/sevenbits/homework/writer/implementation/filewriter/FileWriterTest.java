package it.sevenbits.homework.writer.implementation.filewriter;

import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.writer.WriterException;
import org.junit.Before;
import org.junit.Test;

import javax.activation.FileDataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Test FileWriter.
 */
public class FileWriterTest {

    private IWriter out;

    @Before
    public void SetUp() throws WriterException {
        out = new FileWriter("щдщдщ");
    }

    @Test
    public void writeTest() {

    }
}
