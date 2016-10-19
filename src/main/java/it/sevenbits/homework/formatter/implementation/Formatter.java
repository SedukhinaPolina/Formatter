package it.sevenbits.homework.formatter.implementation;

import it.sevenbits.homework.formatter.IFormatter;
import it.sevenbits.homework.reader.implementation.filereader.ReaderException;
import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.reader.IReader;
import it.sevenbits.homework.writer.implementation.filewriter.WriterException;

/**
 * Formats data received from string.
 */
public class Formatter implements IFormatter {



    /**
     * Format string.
     * @param in input string
     * @param out output string
     */
    public final void format(final IReader in, final IWriter out) {
        try {
            int countOfTabs = 0;
            char temp;
            while (!in.isEnd()) {
                temp = in.read();

                switch (temp) {
                    case '{':
                        countOfTabs++;
                        out.write(" " + "{\n" + "    ");
                        break;
                    case '}':
                        out.write("}\n");
                        countOfTabs--;
                        break;
                    case ';':
                        out.write("; \n");
                        break;
                    default:
                        out.write("" + temp);
                }

            }
        } catch (ReaderException e) {
            System.out.print("Reader exception in formatter");
        } catch (WriterException e) {
            System.out.print("Writer exception in formatter");
        }
    }

}
