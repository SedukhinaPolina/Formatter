 package it.sevenbits.homework.writer.implementation.filewriter;

import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.writer.WriterException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

 /**
 * Writes string to file.
 */
public class FileWriter implements IWriter<String> {
     /**
      * output file.
      */
    private Writer outputFile;

    /**
     * Default constructor.
     * @param fileName is output file
     * @throws WriterException exception
     */
     public FileWriter(final String fileName) throws WriterException {
         try {
             OutputStream fileStream = new FileOutputStream(new File(fileName));
             outputFile = new OutputStreamWriter(fileStream);
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
            outputFile.write(s);
        } catch (IOException e) {
            throw new WriterException(e);
        }
    }

     /**
      * @throws WriterException exception
      */
     public final void close() throws WriterException {
         try {
             outputFile.close();
         } catch (IOException e) {
             throw new WriterException(e);
         }
     }
}
