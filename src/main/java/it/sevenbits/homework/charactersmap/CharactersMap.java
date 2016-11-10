package it.sevenbits.homework.charactersmap;

import it.sevenbits.homework.handlers.IHandler;
import it.sevenbits.homework.handlers.implementation.CloseBraceHandler;
import it.sevenbits.homework.handlers.implementation.OpenBraceHandler;
import it.sevenbits.homework.handlers.implementation.QuoteHandler;
import it.sevenbits.homework.handlers.implementation.SemicolonHandler;
import it.sevenbits.homework.handlers.implementation.CharQuoteHandler;
import it.sevenbits.homework.handlers.implementation.SlashHandler;
import it.sevenbits.homework.handlers.implementation.AsteriskHandler;
import it.sevenbits.homework.handlers.implementation.NewLineHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Compares handler and symbol.
 */
public class CharactersMap {

    private Map<Character, IHandler> map;

    /**
     * Default constructor.
     */
    public CharactersMap() {
        map = new HashMap<Character, IHandler>();
        map.put('{', new OpenBraceHandler());
        map.put('}', new CloseBraceHandler());
        map.put(';', new SemicolonHandler());
        map.put('"', new QuoteHandler());
        map.put("'".charAt(0), new CharQuoteHandler());
        map.put('/', new SlashHandler());
        map.put('*', new AsteriskHandler());
        map.put('\n', new NewLineHandler());
    }

    public Map<Character, IHandler> getMap() {
        return map;
    }
}
