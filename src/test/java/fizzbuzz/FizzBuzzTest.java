package fizzbuzz;

import fizzbuzz.logger.LoggerCollector;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    @Test
    void writeLines() {
        final LoggerCollector logger = new LoggerCollector();
        final FizzBuzz fizzBuzz = new FizzBuzz(logger);

        fizzBuzz.writeLines();

        final List<String> printedLines = logger.getPrintedLines();
        assertEquals(100, printedLines.size());

        IntStream.range(0, 100)
                .forEach(i -> assertEquals(getExpectedBasedOnIndex(i + 1), printedLines.get(i)));
    }

    private String getExpectedBasedOnIndex(int i) {
        if (i % 3 == 0 && i % 5 == 0) {
            return i + " => FizzBuzz";
        } else if (i % 3 == 0) {
            return i + " => Fizz";
        } else if (i % 5 == 0) {
            return i + " => Buzz";
        }
        return i + " => " + i;
    }
}
