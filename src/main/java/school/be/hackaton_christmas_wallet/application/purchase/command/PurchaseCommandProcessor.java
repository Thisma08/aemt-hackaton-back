package school.be.hackaton_christmas_wallet.application.purchase.command;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.purchase.command.getAllPurchasing.GetAllPurchasingHandler;
import school.be.hackaton_christmas_wallet.application.purchase.command.getAllPurchasing.GetAllPurchasingOutput;
import school.be.hackaton_christmas_wallet.application.utils.IEmptyQueryHandler;

@Service
public class PurchaseCommandProcessor{
    private final IEmptyQueryHandler<GetAllPurchasingOutput> getAllPurchasingHandler;

    public PurchaseCommandProcessor(IEmptyQueryHandler<GetAllPurchasingOutput> getAllPurchasingHandler) {
        this.getAllPurchasingHandler = getAllPurchasingHandler;
    }

    public GetAllPurchasingOutput getAllPurchasing(){
        return this.getAllPurchasingHandler.handle();
    }
}
