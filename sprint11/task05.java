class InsufficientAmountException extends Exception {
    private double amount;

    public InsufficientAmountException(double message) {
        super("Sorry, but you are short $" + message);
        amount = message;
    }

    @Override
    public void printStackTrace() {
        System.out.println("     **standard stack trace output**");
    }

    public double getAmount() {
        return amount;
    }
     @Override
    public String getMessage() {
        return super.getMessage();
    }

}
