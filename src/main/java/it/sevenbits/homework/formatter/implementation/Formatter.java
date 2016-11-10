package it.sevenbits.homework.formatter.implementation;

import it.sevenbits.homework.charactersmap.CharactersMap;
import it.sevenbits.homework.formatter.FormatterException;
import it.sevenbits.homework.formatter.IFormatter;
import it.sevenbits.homework.handlers.CodeClearance;
import it.sevenbits.homework.handlers.IHandler;
import it.sevenbits.homework.handlers.implementation.CharHandler;
import it.sevenbits.homework.reader.ReaderException;
import it.sevenbits.homework.writer.IWriter;
import it.sevenbits.homework.reader.IReader;
import it.sevenbits.homework.writer.WriterException;


/**
 * Formats data received from string.
 */
public class Formatter implements IFormatter {

    private CharactersMap hashMap = new CharactersMap();
    private CodeClearance codeClearance = new CodeClearance();
    private IHandler charHandler = new CharHandler();
    /**
     * Format string.
     * @param in input string
     * @param out output string
     * @throws FormatterException exception
     * @throws ReaderException exception
     * @throws WriterException exception
     */
    public void format(final IReader in, final IWriter out) throws FormatterException, ReaderException, WriterException {
        try {
            codeClearance.resetSettings();
            char temp;
            while (!in.isEnd()) {
                temp = in.read();
                if (hashMap.getMap().containsKey(temp)) {
                    hashMap.getMap().get(temp).handle(temp, codeClearance, out);
                } else {
                    charHandler.handle(temp, codeClearance, out);
                }
            }
        } catch (ReaderException e) {
            throw new FormatterException(e);
        }
    }
}
