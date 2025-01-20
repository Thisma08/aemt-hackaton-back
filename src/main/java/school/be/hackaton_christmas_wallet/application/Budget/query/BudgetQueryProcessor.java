package school.be.hackaton_christmas_wallet.application.Budget.query;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.Budget.query.GetBudget.GetAllBudgetOutput;
import school.be.hackaton_christmas_wallet.application.Budget.query.GetBudgetById.GetBudgetByIdHandler;
import school.be.hackaton_christmas_wallet.application.Budget.query.GetBudgetById.GetBudgetByIdOutput;
import school.be.hackaton_christmas_wallet.application.utils.IEmptyQueryHandler;

@Service
public class BudgetQueryProcessor {
    private final IEmptyQueryHandler<GetAllBudgetOutput> getAllBudgetHandler;
    private final GetBudgetByIdHandler getBudgetByIdHandler;

    public BudgetQueryProcessor(IEmptyQueryHandler<GetAllBudgetOutput> getAllBudgetHandler, GetBudgetByIdHandler getBudgetByIdHandler) {
        this.getAllBudgetHandler = getAllBudgetHandler;
        this.getBudgetByIdHandler = getBudgetByIdHandler;
    }

    public GetAllBudgetOutput GetAllBudget() {
        return getAllBudgetHandler.handle();
    }

    public GetBudgetByIdOutput GetBudgetById(long id) {
        return getBudgetByIdHandler.handle(id);
    }
}
