package it.sevenbits.homework.lexer;

/**
 * Stores the token.
 */
public class Token {
    private String token;
    /**
     * Default constructor.
     * @param inputString is the token
     */
    public Token(final String inputString) {
        token = inputString;
    }

    public String getToken() {
        return token;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;

        Token token1 = (Token) o;

        return token.equals(token1.token);

    }

    @Override
    public int hashCode() {
        return token.hashCode();
    }
}
