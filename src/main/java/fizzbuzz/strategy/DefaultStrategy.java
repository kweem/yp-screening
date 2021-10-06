package fizzbuzz.strategy;

public class DefaultStrategy implements BaseStrategy {

    @Override
    public String apply(int number) {
        return String.valueOf(number);
    }

    @Override
    public boolean isApplicable(int number) {
        return true;
    }

    @Override
    public int order() {
        return 1;
    }
}
