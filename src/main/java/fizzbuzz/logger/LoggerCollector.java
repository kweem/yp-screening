package fizzbuzz.logger;

import java.util.ArrayList;
import java.util.List;

public class LoggerCollector implements Loggable {

    private List<String> printedLines;

    public LoggerCollector() {
        this.printedLines = new ArrayList<>();
    }

    @Override
    public void print(String log) {
        System.out.println(log);
        printedLines.add(log);
    }

    public List<String> getPrintedLines() {
        return printedLines;
    }
}
