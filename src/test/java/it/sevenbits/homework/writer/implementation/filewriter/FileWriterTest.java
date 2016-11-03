package it.sevenbits.homework.writer.implementation.filewriter;

import it.sevenbits.homework.reader.ReaderException;
import it.sevenbits.homework.reader.implementation.filereader.FileReader;
import it.sevenbits.homework.writer.WriterException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Test FileWriter.
 */
public class FileWriterTest {

    private FileWriter out;
    private FileReader in;

    @Before
    public void SetUp() throws WriterException, IOException, ReaderException {
        File outFile = File.createTempFile("file", null);
        out = new FileWriter(outFile.getAbsolutePath());
        in = new FileReader(outFile.getAbsolutePath());

    }

    @Test
    public void writeTest() throws WriterException, ReaderException, FileNotFoundException {
        out.write("a");
        assertEquals("wrong", in.read(), 'a');
    }

    @Test(expected = WriterException.class)
    public void closeWriterExceptionTest() throws WriterException {
        out.close();
        out.write("a");
    }





}