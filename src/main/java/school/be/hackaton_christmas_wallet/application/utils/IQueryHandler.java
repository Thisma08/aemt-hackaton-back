package school.be.hackaton_christmas_wallet.application.utils;

public interface IQueryHandler<I, O> {
    O handle(I input);
}
