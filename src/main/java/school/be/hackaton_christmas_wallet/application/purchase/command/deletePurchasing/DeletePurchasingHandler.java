package school.be.hackaton_christmas_wallet.application.purchase.command.deletePurchasing;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IEmptyOutputCommandHandler;
import school.be.hackaton_christmas_wallet.domains.exceptions.NotFoundException;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IPurchasesRepository;

@Service
public class DeletePurchasingHandler implements IEmptyOutputCommandHandler<Long> {
    private final IPurchasesRepository purchasesRepository;

    public DeletePurchasingHandler(IPurchasesRepository purchasesRepository) {
        this.purchasesRepository = purchasesRepository;
    }

    @Override
    public void handle(Long id) {
        if (purchasesRepository.existsById(id))
            purchasesRepository.deleteById(id);
        else
            throw new NotFoundException(id);
    }
}
