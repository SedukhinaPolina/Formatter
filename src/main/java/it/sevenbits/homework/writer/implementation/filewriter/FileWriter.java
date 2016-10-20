 package it.sevenbits.homework.writer.implementation.filewriter;

import it.sevenbits.homework.writer.IWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

 /**
 * Writes string to file.
 */
public class FileWriter implements IWriter {
     /**
      * output file.
      */
    private OutputStream outputFile;

    /**
     * Default constructor.
     * @param fileName is output file
     * @throws WriterException exception
     */
     public FileWriter(final String fileName) throws WriterException {
         try {
             outputFile = new FileOutputStream(fileName);
         } catch (FileNotFoundException e) {
             throw new WriterException(e);
         }
     }
     /**
     * Write string in file.
     * @param s input string
      * @throws WriterException exception
     */
    public final void write(final String s) throws  WriterException {
        try {
            outputFile.write(s.getBytes());
        } catch (IOException e) {
            throw new WriterException(e);
        }
    }
}
