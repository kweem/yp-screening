package vertical;

import fizzbuzz.logger.LoggerCollector;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VerticalTest {

    @Test
    void printSentencesVertically() {
        final LoggerCollector logger = new LoggerCollector();
        final Vertical vertical = new Vertical(logger);
        final List<String> sentences = List.of("It is a beautiful day.", "Don't eat yellow snow");

        vertical.printSentencesVertically(sentences);

        final List<String> printedLines = logger.getPrintedLines();
        assertEquals(5, printedLines.size());
        assertEquals("It Dont", printedLines.get(0));
        assertEquals("is eat", printedLines.get(1));
        assertEquals("a yellow", printedLines.get(2));
        assertEquals("beautiful snow", printedLines.get(3));
        assertEquals("day", printedLines.get(4));
    }

    @Test
    void givenNull_whenPrintSentencesVertically_thenNothingIsPrinted() {
        final LoggerCollector logger = new LoggerCollector();
        final Vertical vertical = new Vertical(logger);

        vertical.printSentencesVertically(null);

        final List<String> printedLines = logger.getPrintedLines();
        assertTrue(printedLines.isEmpty());
    }

    @Test
    void givenEmptyOrNullSentence_whenPrintSentencesVertically_thenEmptySentenceIsIgnored() {
        final LoggerCollector logger = new LoggerCollector();
        final Vertical vertical = new Vertical(logger);
        final String emptySentence = " ";
        final List<String> sentences = new ArrayList<>();
        sentences.add("It is a beautiful day.");
        sentences.add(emptySentence);
        sentences.add(null);
        sentences.add("Don't eat yellow snow");

        vertical.printSentencesVertically(sentences);

        final List<String> printedLines = logger.getPrintedLines();
        assertEquals(5, printedLines.size());
        assertEquals("It Dont", printedLines.get(0));
        assertEquals("is eat", printedLines.get(1));
        assertEquals("a yellow", printedLines.get(2));
        assertEquals("beautiful snow", printedLines.get(3));
        assertEquals("day", printedLines.get(4));
    }
}
