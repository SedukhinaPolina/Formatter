package it.sevenbits.homework.reader.implementation.filereader;

import it.sevenbits.homework.reader.IReader;
import it.sevenbits.homework.reader.ReaderException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/**
 * Reads characters from file.
 */
public class FileReader implements IReader<Character> {
    private Reader inputFile;
    private int inputSymbol;
    /**
     * Default constructor.
     * @param fileName is input file
     * @throws ReaderException exception
     */
    public FileReader(final String fileName) throws ReaderException {
        try {
            InputStream fileStream = new FileInputStream(new File(fileName));
            inputFile = new InputStreamReader(fileStream, "utf-8");
        } catch (FileNotFoundException e) {
            throw new ReaderException(e);
        } catch (UnsupportedEncodingException e) {
            throw new ReaderException(e);
        }

    }

    /**
     * Reads one character.
     * @return get character
     * @throws ReaderException exception
     */
    public final Character read() throws ReaderException {
        try {
            inputSymbol = inputFile.read();
            return (char) inputSymbol;
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }

    /**
     * @throws ReaderException exception
     */
    public final void close() throws ReaderException {
        try {
            inputFile.close();
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }
    /**
     * The end of the file verification.
     * @return true if end of file, else false
     * @throws ReaderException exception
     */
    public final boolean isEnd() throws ReaderException {
            return (inputSymbol == -1);
    }
}
