package com.example.fintech2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void CounterBlank () {
        Outsidecalc counter = new Outsidecalc();
        int charCountWords = counter.Count("", "Words");
        int charCountChar = counter.Count("", "Char");
        assertEquals(0, charCountWords);
        assertEquals(0, charCountChar);
    }

    @Test
    public void CounterText () {
        Outsidecalc counter = new Outsidecalc();
        int charCountWords = counter.Count("simple", "Words");
        int charCountChar = counter.Count("simple", "Char");
        assertEquals(1, charCountWords);
        assertEquals(6, charCountChar);

        charCountWords = counter.Count("simple 123", "Words");
        charCountChar = counter.Count("simple 123", "Char");
        assertEquals(2, charCountWords);
        assertEquals(9, charCountChar);

        charCountWords = counter.Count(" left space", "Words");
        charCountChar = counter.Count(" left space", "Char");
        assertEquals(2, charCountWords);
        assertEquals(9, charCountChar);

        charCountWords = counter.Count("right space ", "Words");
        charCountChar = counter.Count("right space ", "Char");
        assertEquals(2, charCountWords);
        assertEquals(10, charCountChar);

        charCountWords = counter.Count(" both spaces ", "Words");
        charCountChar = counter.Count(" both spaces ", "Char");
        assertEquals(2, charCountWords);
        assertEquals(10, charCountChar);
    }

    @Test
    public void CounterDelimiters () {
        Outsidecalc counter = new Outsidecalc();
        int charCountWordsEmpty = counter.Count(" ", "Words");
        int charCountCharEmpty = counter.Count(" ", "Char");
        assertEquals(0, charCountWordsEmpty);
        assertEquals(0, charCountCharEmpty);

        int charCountWordsDelimiter = counter.Count("@#$", "Words");
        int charCountCharDelimiter = counter.Count("@#$", "Char");
        assertEquals(1, charCountWordsDelimiter);
        assertEquals(3, charCountCharDelimiter);

        int charCountWordsBlankDelimiter = counter.Count(" @#$ ", "Words");
        int charCountCharBlankDelimiter = counter.Count(" @#$ ", "Char");
        assertEquals(1, charCountWordsBlankDelimiter);
        assertEquals(3, charCountCharBlankDelimiter);
    }

    @Test
    public void CounterLetter () {
        Outsidecalc counter = new Outsidecalc();
        int charCountWordsLetter = counter.Count("5k4ic1u5 r4id3", "Letter");
        assertEquals(7, charCountWordsLetter);

        charCountWordsLetter = counter.Count("123", "Letter");
        assertEquals(0, charCountWordsLetter);

        charCountWordsLetter = counter.Count(" 1@2 ", "Letter");
        assertEquals(0, charCountWordsLetter);

        charCountWordsLetter = counter.Count("1@2 ", "Letter");
        assertEquals(0, charCountWordsLetter);

        charCountWordsLetter = counter.Count(" 1@2", "Letter");
        assertEquals(0, charCountWordsLetter);

        charCountWordsLetter = counter.Count("1234s6789o", "Letter");
        assertEquals(2, charCountWordsLetter);

    }
    @Test
    public void CounterNumber () {
        Outsidecalc counter = new Outsidecalc();
        int charCountWordsNumber = counter.Count("5k4ic1u5 r4id3", "Numbers");
        assertEquals(6, charCountWordsNumber);

        charCountWordsNumber = counter.Count("qwerty", "Numbers");
        assertEquals(0, charCountWordsNumber);

        charCountWordsNumber = counter.Count(" qwerty ", "Numbers");
        assertEquals(0, charCountWordsNumber);

        charCountWordsNumber = counter.Count("qwerty ", "Numbers");
        assertEquals(0, charCountWordsNumber);

        charCountWordsNumber = counter.Count(" qwerty", "Numbers");
        assertEquals(0, charCountWordsNumber);

        charCountWordsNumber = counter.Count(" qw4rty qw4rty ", "Numbers");
        assertEquals(2, charCountWordsNumber);
    }
    @Test
    public void CounterCharWithSpace () {
        Outsidecalc counter = new Outsidecalc();
        int charCountCharWithSpace = counter.Count("5k4ic1u5 r4id3", "Character and space");
        assertEquals(14, charCountCharWithSpace);

        charCountCharWithSpace = counter.Count(" 5k4ic1u5 r4id3 ", "Character and space");
        assertEquals(14, charCountCharWithSpace);

        charCountCharWithSpace = counter.Count("5k4ic1u5 r4id3 ", "Character and space");
        assertEquals(14, charCountCharWithSpace);

        charCountCharWithSpace = counter.Count(" 5k4ic1u5 r4id3", "Character and space");
        assertEquals(14, charCountCharWithSpace);
    }
}