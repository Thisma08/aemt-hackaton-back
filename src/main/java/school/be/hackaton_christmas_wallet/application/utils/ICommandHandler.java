package school.be.hackaton_christmas_wallet.application.utils;

public interface ICommandHandler<I, O> {
    O handle(I input);
}
