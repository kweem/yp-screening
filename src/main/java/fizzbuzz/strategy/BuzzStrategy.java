package fizzbuzz.strategy;

public class BuzzStrategy implements BaseStrategy {

    @Override
    public String apply(int number) {
        return "Buzz";
    }

    @Override
    public boolean isApplicable(int number) {
        return number % 5 == 0;
    }

    @Override
    public int order() {
        return 3;
    }
}
