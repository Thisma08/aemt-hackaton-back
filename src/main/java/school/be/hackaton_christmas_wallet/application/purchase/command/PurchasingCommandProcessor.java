package school.be.hackaton_christmas_wallet.application.purchase.command;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.purchase.command.createPurchasing.CreatePurchasingOutput;
import school.be.hackaton_christmas_wallet.application.purchase.command.createPurchasing.CreatePurchasingQuery;
import school.be.hackaton_christmas_wallet.application.purchase.command.updatePurchasing.UpdatePurchasingOutput;
import school.be.hackaton_christmas_wallet.application.purchase.command.updatePurchasing.UpdatePurchasingQuery;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;

@Service
public class PurchasingCommandProcessor {
    private final IQueryHandler<CreatePurchasingQuery, CreatePurchasingOutput> createPurchasingHandler;
    private final IQueryHandler<UpdatePurchasingQuery, UpdatePurchasingOutput> updatePurchasingHandler;

    public PurchasingCommandProcessor(IQueryHandler<CreatePurchasingQuery, CreatePurchasingOutput> createPurchasingHandler, IQueryHandler<UpdatePurchasingQuery, UpdatePurchasingOutput> updatePurchasingHandler) {
        this.createPurchasingHandler = createPurchasingHandler;
        this.updatePurchasingHandler = updatePurchasingHandler;
    }

    public CreatePurchasingOutput CreatePurchasing(CreatePurchasingQuery createPurchasingQuery) {
        return createPurchasingHandler.handle(createPurchasingQuery);
    }

    public UpdatePurchasingOutput UpdatePurchasing(UpdatePurchasingQuery updatePurchasingQuery) {
        return updatePurchasingHandler.handle(updatePurchasingQuery);
    }
}
