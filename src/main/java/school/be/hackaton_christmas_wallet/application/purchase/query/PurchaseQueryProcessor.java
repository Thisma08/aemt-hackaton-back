package school.be.hackaton_christmas_wallet.application.purchase.query;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.purchase.query.getAllPurchasing.GetAllPurchasingOutput;
import school.be.hackaton_christmas_wallet.application.utils.IEmptyQueryHandler;

@Service
public class PurchaseQueryProcessor {
    private final IEmptyQueryHandler<GetAllPurchasingOutput> getAllPurchasingHandler;

    public PurchaseQueryProcessor(IEmptyQueryHandler<GetAllPurchasingOutput> getAllPurchasingHandler) {
        this.getAllPurchasingHandler = getAllPurchasingHandler;
    }

    public GetAllPurchasingOutput getAllPurchasing(){
        return this.getAllPurchasingHandler.handle();
    }

}
