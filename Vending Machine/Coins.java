public enum Coins{
    ONE(0.01), TWO(0.05), FIVE(0.1), TEN(0.25), TWENTY(1.0);
    
    private final double value;

    Coins(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}