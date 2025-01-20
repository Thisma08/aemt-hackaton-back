package school.be.hackaton_christmas_wallet.domains.exceptions;

public class BudgetNotFoundException extends RuntimeException {
    public BudgetNotFoundException(int month, int year) {
        super("Budget for month " + month + " and year " + year + " does not exist.");
    }
}
