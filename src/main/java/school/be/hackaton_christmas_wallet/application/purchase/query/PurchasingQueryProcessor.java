package school.be.hackaton_christmas_wallet.application.purchase.query;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.purchase.query.createPurchasing.CreatePurchasingHandler;
import school.be.hackaton_christmas_wallet.application.purchase.query.createPurchasing.CreatePurchasingOutput;
import school.be.hackaton_christmas_wallet.application.purchase.query.createPurchasing.CreatePurchasingQuery;

@Service
public class PurchasingQueryProcessor {
    private final CreatePurchasingHandler createPurchasingHandler;

    public PurchasingQueryProcessor(CreatePurchasingHandler createPurchasingHandler) {
        this.createPurchasingHandler = createPurchasingHandler;
    }

    public CreatePurchasingOutput CreatePurchasing(CreatePurchasingQuery createPurchasingQuery) {
        return createPurchasingHandler.handle(createPurchasingQuery);
    }
}
