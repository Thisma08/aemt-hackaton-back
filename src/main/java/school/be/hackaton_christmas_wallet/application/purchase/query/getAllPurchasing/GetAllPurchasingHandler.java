package school.be.hackaton_christmas_wallet.application.purchase.query.getAllPurchasing;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IEmptyQueryHandler;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IPurchasesRepository;

@Service
public class GetAllPurchasingHandler implements IEmptyQueryHandler<GetAllPurchasingOutput> {
    private final IPurchasesRepository purchasesRepository;

    public GetAllPurchasingHandler(IPurchasesRepository purchasesRepository) {
        this.purchasesRepository = purchasesRepository;
    }

    @Override
    public GetAllPurchasingOutput handle() {
        GetAllPurchasingOutput getAllPurchasingOutput = new GetAllPurchasingOutput();
        purchasesRepository.findAll().forEach(dbPurchases -> {
            GetAllPurchasingOutput.PurchasingOutput purchasingOutput = new GetAllPurchasingOutput.PurchasingOutput();
            purchasingOutput.id = dbPurchases.getId();
            purchasingOutput.date = dbPurchases.getPurchaseDate();
            purchasingOutput.amount = dbPurchases.getAmount();
            purchasingOutput.category = dbPurchases.getCategory().getName();
            getAllPurchasingOutput.Purchasings.add(purchasingOutput);
        });
        return getAllPurchasingOutput;
    }
}
