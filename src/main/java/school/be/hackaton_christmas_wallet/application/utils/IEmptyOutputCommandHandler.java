package school.be.hackaton_christmas_wallet.application.utils;

public interface IEmptyOutputCommandHandler<I> {
    void handle(I input);
}
