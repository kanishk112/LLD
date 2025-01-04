public enum Notes{
    TEN(10), TWENTY(20), FIVE(5), ONE(1);

    private final double value;

    Notes(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

}