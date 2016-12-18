package it.sevenbits.homework.handlers;

import static java.util.Arrays.fill;

/**
 * Holds the current indent.
 */
public class IndentMaker {
    private int countOfTabs = 0;

    public void setCountOfTabs(final int countOfTabs) {
        this.countOfTabs = countOfTabs;
    }

    /**
     * Increases indent
     */
    public void incCountOfTabs() {
        countOfTabs++;
    }

    /**
     * Decreases indent
     */
    public void decCountOfTabs() {
        countOfTabs--;
    }

    /**
     * Make indent of tabs
     * @return indent as a string
     */
    public String makeIndent() {
        if (countOfTabs < 0) {
            countOfTabs = 0;
        }
        char[] array = new char[countOfTabs];
        fill(array, '\t');
        return new String(array);
    }

}
