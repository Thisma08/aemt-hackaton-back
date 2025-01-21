package school.be.hackaton_christmas_wallet.application.Budget.query;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.Budget.query.GetBudget.GetAllBudgetOutput;
import school.be.hackaton_christmas_wallet.application.Budget.query.GetBudgetById.GetBudgetByIdHandler;
import school.be.hackaton_christmas_wallet.application.Budget.query.GetBudgetById.GetBudgetByIdOutput;
import school.be.hackaton_christmas_wallet.application.Budget.query.balanceRemaining.BalanceRemainingOutput;
import school.be.hackaton_christmas_wallet.application.utils.IEmptyQueryHandler;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;

@Service
public class BudgetQueryProcessor {
    private final IEmptyQueryHandler<GetAllBudgetOutput> getAllBudgetHandler;
    private final GetBudgetByIdHandler getBudgetByIdHandler;
    private final IQueryHandler<Long, BalanceRemainingOutput> balanceRemainingHandler;

    public BudgetQueryProcessor(IEmptyQueryHandler<GetAllBudgetOutput> getAllBudgetHandler, GetBudgetByIdHandler getBudgetByIdHandler, IQueryHandler<Long, BalanceRemainingOutput> balanceRemainingHandler) {
        this.getAllBudgetHandler = getAllBudgetHandler;
        this.getBudgetByIdHandler = getBudgetByIdHandler;
        this.balanceRemainingHandler = balanceRemainingHandler;
    }

    public GetAllBudgetOutput GetAllBudget() {
        return getAllBudgetHandler.handle();
    }

    public GetBudgetByIdOutput GetBudgetById(long id) {
        return getBudgetByIdHandler.handle(id);
    }

    public BalanceRemainingOutput balanceRemaining(Long id) {
        return balanceRemainingHandler.handle(id);
    }
}
