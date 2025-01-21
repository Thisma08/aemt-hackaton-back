package school.be.hackaton_christmas_wallet.application.budget.query;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.budget.query.GetBudget.GetAllBudgetOutput;
import school.be.hackaton_christmas_wallet.application.budget.query.GetBudgetById.GetBudgetByIdHandler;
import school.be.hackaton_christmas_wallet.application.budget.query.GetBudgetById.GetBudgetByIdOutput;
import school.be.hackaton_christmas_wallet.application.budget.query.GetByCategoryAndDateCategory.GetByCategoryAndDateCategoryOutput;
import school.be.hackaton_christmas_wallet.application.budget.query.GetByCategoryAndDateCategory.GetByCategoryAndDateCategoryQuery;
import school.be.hackaton_christmas_wallet.application.budget.query.GetByDateCategory.GetByDateCategoryOutput;
import school.be.hackaton_christmas_wallet.application.budget.query.GetByDateCategory.GetByDateCategoryQuery;
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
    private final IQueryHandler<GetByCategoryAndDateCategoryQuery, GetByCategoryAndDateCategoryOutput> getByCategoryAndDateCategoryHandler;
    private final IQueryHandler<GetByDateCategoryQuery, GetByDateCategoryOutput> getByDateCategoryHandler;

    public BudgetQueryProcessor(IEmptyQueryHandler<GetAllBudgetOutput> getAllBudgetHandler,
                                GetBudgetByIdHandler getBudgetByIdHandler,
                                IQueryHandler<Long, BalanceRemainingOutput> balanceRemainingHandler,
                                IQueryHandler<BalanceRemainingByCategoryQuery, BalanceRemainingByCategoryOutput> balanceRemainingByCategoryHandler,
                                IQueryHandler<GetByCategoryAndDateCategoryQuery, GetByCategoryAndDateCategoryOutput> getByCategoryAndDateCategoryHandler,
                                IQueryHandler<GetByDateCategoryQuery, GetByDateCategoryOutput> getByDateCategoryHandler) {
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

    public GetByCategoryAndDateCategoryOutput GetByCategoryAndDateCategory(GetByCategoryAndDateCategoryQuery input) {
        return getByCategoryAndDateCategoryHandler.handle(input);
    }

    public GetByDateCategoryOutput GetByDateCategory(GetByDateCategoryQuery input) {
        return getByDateCategoryHandler.handle(input);
    }

}
