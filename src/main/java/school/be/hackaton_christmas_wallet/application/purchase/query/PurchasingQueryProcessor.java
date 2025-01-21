package school.be.hackaton_christmas_wallet.application.purchase.query;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.purchase.query.createPurchasing.CreatePurchasingHandler;
import school.be.hackaton_christmas_wallet.application.purchase.query.createPurchasing.CreatePurchasingOutput;
import school.be.hackaton_christmas_wallet.application.purchase.query.createPurchasing.CreatePurchasingQuery;
import school.be.hackaton_christmas_wallet.application.purchase.query.updatePurchasing.UpdatePurchasingOutput;
import school.be.hackaton_christmas_wallet.application.purchase.query.updatePurchasing.UpdatePurchasingQuery;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;

@Service
public class PurchasingQueryProcessor {
    private final IQueryHandler<CreatePurchasingQuery, CreatePurchasingOutput> createPurchasingHandler;
    private final IQueryHandler<UpdatePurchasingQuery, UpdatePurchasingOutput> updatePurchasingHandler;

    public PurchasingQueryProcessor(IQueryHandler<CreatePurchasingQuery, CreatePurchasingOutput> createPurchasingHandler, IQueryHandler<UpdatePurchasingQuery, UpdatePurchasingOutput> updatePurchasingHandler) {
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
