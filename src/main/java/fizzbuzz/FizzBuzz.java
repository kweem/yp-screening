package fizzbuzz;

import fizzbuzz.logger.Loggable;
import fizzbuzz.strategy.BaseStrategy;
import fizzbuzz.strategy.BuzzStrategy;
import fizzbuzz.strategy.DefaultStrategy;
import fizzbuzz.strategy.FizzStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class FizzBuzz {

    private Loggable logger;
    private DefaultStrategy defaultStrategy;
    private List<BaseStrategy> strategyList;

    public FizzBuzz(Loggable logger) {
        this.logger = logger;
        initializeStrategies();
    }

    private void initializeStrategies() {
        defaultStrategy = new DefaultStrategy();

        strategyList = new ArrayList<>();
        strategyList.add(new FizzStrategy());
        strategyList.add(new BuzzStrategy());
        strategyList.sort(Comparator.comparing(BaseStrategy::order));
    }

    public void writeLines() {
        IntStream.range(1, 101).forEach(i -> {
            final Optional<String> fizzBuzzOpt = strategyList.stream()
                    .filter(strategy -> strategy.isApplicable(i))
                    .map(strategy -> strategy.apply(i))
                    .reduce(String::concat);

            final String fizzBuzz = fizzBuzzOpt
                    .orElseGet(() -> applyDefaultStrategy(i));

            log(i, fizzBuzz);
        });
    }

    private void log(int number, String fizzBuzz) {
        final String logLine = number + " => " + fizzBuzz;
        logger.print(logLine);
    }

    private String applyDefaultStrategy(int number) {
        if (!defaultStrategy.isApplicable(number)) {
            throw new IllegalStateException("No applicable strategy found");
        }
        return defaultStrategy.apply(number);
    }
}
