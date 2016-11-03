package it.sevenbits.homework.formatter.implementation;

import it.sevenbits.homework.formatter.FormatterException;
import it.sevenbits.homework.formatter.IFormatter;
import it.sevenbits.homework.reader.ReaderException;
import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.reader.IReader;
import it.sevenbits.homework.writer.WriterException;


/**
 * Formats data received from string.
 */
public class Formatter implements IFormatter {

    /**
     * Format string.
     * @param in input string
     * @param out output string
     * @throws FormatterException exception
     */
    public final void format(final IReader in, final IWriter out) throws FormatterException {
        try {
            int countOfTabs = 0;
            char temp;
            while (!in.isEnd()) {
                temp = in.read();

                switch (temp) {
                    case '{':
                        countOfTabs++;
                        out.write(" {\n");
                        out.write(writeSpaces(countOfTabs));

                        break;
                    case '}':
                        countOfTabs--;
                        out.write(writeSpaces(countOfTabs));
                        out.write("}\n");
                        break;
                    case ';':
                        out.write(";\n");
                        out.write(writeSpaces(countOfTabs));
                        break;
                    default:
                        out.write("" + temp);
                }
            }
            if (countOfTabs != 0) {
                out.write("error: incorrect number of braces");
            }
        } catch (ReaderException e) {
            System.out.print("Reader exception in formatter");
            throw new FormatterException(e);

        } catch (WriterException e) {
            System.out.print("Writer exception in formatter");
            throw new FormatterException(e);
        }
    }

    /**
     *
     * @param countOfTabs count of tabs
     * @return string with a specified number of spaces
     */

    private String writeSpaces(final int countOfTabs) {
        String temp = "";
        for (int i = 0; i < countOfTabs; i++) {
            temp += "\t";
        }
        return temp;
    }
}
