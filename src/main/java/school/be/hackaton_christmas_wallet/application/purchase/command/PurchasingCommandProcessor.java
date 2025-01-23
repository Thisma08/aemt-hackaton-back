package school.be.hackaton_christmas_wallet.application.purchase.command;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.purchase.command.createPurchasing.CreatePurchasingOutput;
import school.be.hackaton_christmas_wallet.application.purchase.command.createPurchasing.CreatePurchasingQuery;
import school.be.hackaton_christmas_wallet.application.purchase.command.updatePurchasing.UpdatePurchasingOutput;
import school.be.hackaton_christmas_wallet.application.purchase.command.updatePurchasing.UpdatePurchasingQuery;
import school.be.hackaton_christmas_wallet.application.utils.IEmptyOutputCommandHandler;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;

@Service
public class PurchasingCommandProcessor {
    private final IQueryHandler<CreatePurchasingQuery, CreatePurchasingOutput> createPurchasingHandler;
    private final IQueryHandler<UpdatePurchasingQuery, UpdatePurchasingOutput> updatePurchasingHandler;
    private final IEmptyOutputCommandHandler<Long> deletePurchasingHandler;

    public PurchasingCommandProcessor(IQueryHandler<CreatePurchasingQuery, CreatePurchasingOutput> createPurchasingHandler, IQueryHandler<UpdatePurchasingQuery, UpdatePurchasingOutput> updatePurchasingHandler, IEmptyOutputCommandHandler<Long> deletePurchasingHandler) {
        this.createPurchasingHandler = createPurchasingHandler;
        this.updatePurchasingHandler = updatePurchasingHandler;
        this.deletePurchasingHandler = deletePurchasingHandler;
    }

    public CreatePurchasingOutput CreatePurchasing(CreatePurchasingQuery createPurchasingQuery) {
        return createPurchasingHandler.handle(createPurchasingQuery);
    }

    public UpdatePurchasingOutput UpdatePurchasing(UpdatePurchasingQuery updatePurchasingQuery) {
        return updatePurchasingHandler.handle(updatePurchasingQuery);
    }

    public void delete(Long id) {
        deletePurchasingHandler.handle(id);
    }
}
