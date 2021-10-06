package fizzbuzz.strategy;

public interface BaseStrategy  {

    public String apply(int number);
    public boolean isApplicable(int number);
    public int order();
}
