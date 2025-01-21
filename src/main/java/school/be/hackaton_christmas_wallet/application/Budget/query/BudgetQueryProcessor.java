package school.be.hackaton_christmas_wallet.application.Budget.query;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.Budget.query.GetBudget.GetAllBudgetOutput;
import school.be.hackaton_christmas_wallet.application.Budget.query.GetBudgetById.GetBudgetByIdHandler;
import school.be.hackaton_christmas_wallet.application.Budget.query.GetBudgetById.GetBudgetByIdOutput;
import school.be.hackaton_christmas_wallet.application.Budget.query.balanceRemaining.BalanceRemainingOutput;
import school.be.hackaton_christmas_wallet.application.Budget.query.balanceRemainingByCategory.BalanceRemainingByCategoryOutput;
import school.be.hackaton_christmas_wallet.application.Budget.query.balanceRemainingByCategory.BalanceRemainingByCategoryQuery;
import school.be.hackaton_christmas_wallet.application.utils.IEmptyQueryHandler;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;

@Service
public class BudgetQueryProcessor {
    private final IEmptyQueryHandler<GetAllBudgetOutput> getAllBudgetHandler;
    private final GetBudgetByIdHandler getBudgetByIdHandler;
    private final IQueryHandler<Long, BalanceRemainingOutput> balanceRemainingHandler;
    private final IQueryHandler<BalanceRemainingByCategoryQuery, BalanceRemainingByCategoryOutput> balanceRemainingByCategoryHandler;

    public BudgetQueryProcessor(IEmptyQueryHandler<GetAllBudgetOutput> getAllBudgetHandler,
                                GetBudgetByIdHandler getBudgetByIdHandler,
                                IQueryHandler<Long, BalanceRemainingOutput> balanceRemainingHandler,
                                IQueryHandler<BalanceRemainingByCategoryQuery, BalanceRemainingByCategoryOutput> balanceRemainingByCategoryHandler) {
        this.getAllBudgetHandler = getAllBudgetHandler;
        this.getBudgetByIdHandler = getBudgetByIdHandler;
        this.balanceRemainingHandler = balanceRemainingHandler;
        this.balanceRemainingByCategoryHandler = balanceRemainingByCategoryHandler;
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

    public BalanceRemainingByCategoryOutput balanceRemainingByCategory(BalanceRemainingByCategoryQuery input) {
        return balanceRemainingByCategoryHandler.handle(input);
    }
}
