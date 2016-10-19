package it.sevenbits.homework.reader.implementation.filereader;

import it.sevenbits.homework.reader.IReader;

import java.io.*;

/**
 * Created by polly on 24.04.16.
 */
public class FileReader implements IReader {
    /**
     * input file.
     */
    private InputStream inputFile;

    /**
     * Default constructor.
     * @param fileName is input file
     * @throws ReaderException exception
     */
    public FileReader(final String fileName) throws ReaderException {
        try {
            inputFile = new FileInputStream(new File(fileName));
        } catch (FileNotFoundException e) {
            throw new ReaderException(e);
        }

    }

    /**
     * Reads one character.
     * @return get character
     * @throws ReaderException exception
     */
    public final char read() throws ReaderException {
        try {
            return (char) inputFile.read();
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }

    /**
     * I don't know for what.
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
     * @return true if end of string, else false
     */
    public final boolean isEnd() throws ReaderException {
        try {
            int count = inputFile.available();
            if (count > 0) {
                return false;
            }
            return true;
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }
}
