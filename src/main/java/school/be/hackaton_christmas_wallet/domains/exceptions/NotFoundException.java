package school.be.hackaton_christmas_wallet.domains.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int month, int year) {
        super("budget for month " + month + " and year " + year + " does not exist.");
    }

    public NotFoundException(String categories, long id) {
        super("Not found " + categories + " : " + id);
    }
}
