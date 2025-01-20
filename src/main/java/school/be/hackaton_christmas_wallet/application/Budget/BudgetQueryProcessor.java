package school.be.hackaton_christmas_wallet.application.Budget;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.Budget.query.GetBudget.GetAllBudgetOutput;
import school.be.hackaton_christmas_wallet.application.utils.IEmptyQueryHandler;

@Service
public class BudgetQueryProcessor {
    IEmptyQueryHandler<GetAllBudgetOutput> getAllBudgetHandler;

    public BudgetQueryProcessor(IEmptyQueryHandler<GetAllBudgetOutput> getAllBudgetHandler) {
        this.getAllBudgetHandler = getAllBudgetHandler;
    }
    public GetAllBudgetOutput GetAllBudget() {
        return getAllBudgetHandler.handle();
    }
}
