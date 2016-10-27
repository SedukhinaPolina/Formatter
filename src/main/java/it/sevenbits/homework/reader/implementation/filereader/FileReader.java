package it.sevenbits.homework.reader.implementation.filereader;

import it.sevenbits.homework.reader.IReader;

import java.io.*;

/**
 * Reads characters from file.
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
        try {
            int count = inputFile.available();
            return (count == 0);
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }
}
