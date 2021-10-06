package fizzbuzz.strategy;

public class FizzStrategy implements BaseStrategy {

    @Override
    public String apply(int number) {
        return "Fizz";
    }

    @Override
    public boolean isApplicable(int number) {
        return number % 3 == 0;
    }

    @Override
    public int order() {
        return 2;
    }
}
