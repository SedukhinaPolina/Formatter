package it.sevenbits.homework.handlers;

import static java.util.Arrays.fill;

/**
 * Class for subsidiary variables.
 */
public class CodeClearance {

    private int countOfTabs;
    private boolean isComment;
    private boolean isMultilineComment;
    private boolean isCanBeComment;
    private boolean isQuote;
    private boolean isCanBeEndOfComment;
    private boolean isWasSemicolon;

    /**
     * Default constructor.
     */
    public CodeClearance() {
        countOfTabs = 0;
        isCanBeComment = false;
        isComment = false;
        isMultilineComment = false;
        isQuote = false;
        isCanBeEndOfComment = false;
        isWasSemicolon = false;
    }

    public boolean isCanBeEndOfComment() {
        return isCanBeEndOfComment;
    }

    public void setCanBeEndOfComment(final boolean canBeEndOfComment) {
        isCanBeEndOfComment = canBeEndOfComment;
    }

    public boolean isMultilineComment() {
        return isMultilineComment;
    }

    public void setMultilineComment(final boolean multilineComment) {
        isMultilineComment = multilineComment;
    }


    public boolean isComment() {
        return isComment;
    }

    public void setComment(final boolean comment) {
        isComment = comment;
    }

    public boolean isCanBeComment() {
        return isCanBeComment;
    }

    public void setCanBeComment(final boolean canBeComment) {
        isCanBeComment = canBeComment;
    }

    public boolean isQuote() {
        return isQuote;
    }

    public void setQuote(final boolean quote) {
        isQuote = quote;
    }

    /**
     * Make indent of tabs
     * @return indent as a string
     */

    public String makeIndent() {
        char[] array = new char[countOfTabs];
        fill(array, '\t');
        return new String(array);
    }

    public boolean isWasSemicolon() {
        return isWasSemicolon;
    }

    public void setWasSemicolon(final boolean wasSemicolon) {
        isWasSemicolon = wasSemicolon;
    }

    /**
     * Increase countOfTabs.
     */

    public void incCountOfTabs() {
        countOfTabs++;
    }

    /**
     * Decrease countOfTabs.
     */

    public void decCountOfTabs() {
        countOfTabs--;
    }

    /**
     * Reset settings to default
     */
    public void resetSettings() {
        countOfTabs = 0;
        isCanBeComment = false;
        isComment = false;
        isMultilineComment = false;
        isQuote = false;
        isCanBeEndOfComment = false;
        isWasSemicolon = false;
    }
}
