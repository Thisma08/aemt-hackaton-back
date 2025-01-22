package school.be.hackaton_christmas_wallet.application.budget.query;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.budget.query.GetBudget.GetAllBudgetOutput;
import school.be.hackaton_christmas_wallet.application.budget.query.GetBudgetById.GetBudgetByIdHandler;
import school.be.hackaton_christmas_wallet.application.budget.query.GetBudgetById.GetBudgetByIdOutput;
import school.be.hackaton_christmas_wallet.application.budget.query.GetByCategoryDate.GetByCategoryDateOutput;
import school.be.hackaton_christmas_wallet.application.budget.query.GetByCategoryDate.GetByCategoryDateQuery;
import school.be.hackaton_christmas_wallet.application.budget.query.GetByDate.GetByDateOutput;
import school.be.hackaton_christmas_wallet.application.budget.query.GetByDate.GetByDateQuery;
import school.be.hackaton_christmas_wallet.application.budget.query.balanceRemaining.BalanceRemainingOutput;
import school.be.hackaton_christmas_wallet.application.budget.query.balanceRemainingByCategory.BalanceRemainingByCategoryOutput;
import school.be.hackaton_christmas_wallet.application.budget.query.balanceRemainingByCategory.BalanceRemainingByCategoryQuery;
import school.be.hackaton_christmas_wallet.application.utils.IEmptyQueryHandler;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;

@Service
public class BudgetQueryProcessor {
    private final IEmptyQueryHandler<GetAllBudgetOutput> getAllBudgetHandler;
    private final IQueryHandler<Long, GetBudgetByIdOutput> getBudgetByIdHandler;
    private final IQueryHandler<Long, BalanceRemainingOutput> balanceRemainingHandler;
    private final IQueryHandler<BalanceRemainingByCategoryQuery, BalanceRemainingByCategoryOutput> balanceRemainingByCategoryHandler;
    private final IQueryHandler<GetByCategoryDateQuery, GetByCategoryDateOutput> getByCategoryAndDateCategoryHandler;
    private final IQueryHandler<GetByDateQuery, GetByDateOutput> getByDateCategoryHandler;

    public BudgetQueryProcessor(IEmptyQueryHandler<GetAllBudgetOutput> getAllBudgetHandler,
                                GetBudgetByIdHandler getBudgetByIdHandler,
                                IQueryHandler<Long, BalanceRemainingOutput> balanceRemainingHandler,
                                IQueryHandler<BalanceRemainingByCategoryQuery, BalanceRemainingByCategoryOutput> balanceRemainingByCategoryHandler,
                                IQueryHandler<GetByCategoryDateQuery, GetByCategoryDateOutput> getByCategoryAndDateCategoryHandler,
                                IQueryHandler<GetByDateQuery, GetByDateOutput> getByDateCategoryHandler) {
        this.getAllBudgetHandler = getAllBudgetHandler;
        this.getBudgetByIdHandler = getBudgetByIdHandler;
        this.balanceRemainingHandler = balanceRemainingHandler;
        this.balanceRemainingByCategoryHandler = balanceRemainingByCategoryHandler;
        this.getByCategoryAndDateCategoryHandler = getByCategoryAndDateCategoryHandler;
        this.getByDateCategoryHandler = getByDateCategoryHandler;
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

    public GetByCategoryDateOutput GetByCategoryAndDateCategory(GetByCategoryDateQuery input) {
        return getByCategoryAndDateCategoryHandler.handle(input);
    }

    public GetByDateOutput GetByDateCategory(GetByDateQuery input) {
        return getByDateCategoryHandler.handle(input);
    }

}
