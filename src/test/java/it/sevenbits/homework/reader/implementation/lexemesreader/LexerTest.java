package it.sevenbits.homework.reader.implementation.lexemesreader;

import it.sevenbits.homework.lexer.Token;
import it.sevenbits.homework.reader.IReader;
import it.sevenbits.homework.reader.ReaderException;
import it.sevenbits.homework.reader.implementation.stringreader.StringReader;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Lexer class testing.
 */
public class LexerTest {
    private IReader<Character> in;
    private Lexer lexer;

    @Test
    public void lexemeTest() throws ReaderException {
        in = new StringReader("ololo{");
        IReader<Token> lexer = new Lexer(in);
        Token token = lexer.read();
        assertEquals("error", "ololo", token.getToken());
    }

    @Test
    public void openBraceTest() throws ReaderException {
        in = new StringReader("{a");
        IReader<Token> lexer = new Lexer(in);
        lexer.read();
        Token token = lexer.read();
        assertEquals("error", "{", token.getToken());
    }

    @Test
    public void closeBraceTest() throws ReaderException {
        in = new StringReader("}a");
        IReader<Token> lexer = new Lexer(in);
        lexer.read();
        Token token = lexer.read();
        assertEquals("error", "}", token.getToken());
    }

    @Test
    public void commentTest() throws ReaderException {
        in = new StringReader("//a");
        IReader<Token> lexer = new Lexer(in);
        Token token = lexer.read();
        assertEquals("error", "//", token.getToken());
    }

    @Test
    public void multilineCommentTest() throws ReaderException {
        in = new StringReader("/*a");
        IReader<Token> lexer = new Lexer(in);
        Token token = lexer.read();
        assertEquals("error", "/*", token.getToken());
    }

    @Test
    public void endOfMultilineCommentTest() throws ReaderException {
        in = new StringReader("/*;*/");
        IReader<Token> lexer = new Lexer(in);
        assertEquals("error", "/*;*/", lexer.read().getToken() + lexer.read().getToken() + lexer.read().getToken());
    }




}
