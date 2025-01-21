package school.be.hackaton_christmas_wallet.application.budget.query.balanceRemainingByCategory;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;
import school.be.hackaton_christmas_wallet.domains.exceptions.NotFoundException;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbPurchases;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IBudgetsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BalanceRemainingByCategoryHandler implements IQueryHandler<BalanceRemainingByCategoryQuery, BalanceRemainingByCategoryOutput> {

    private final IBudgetsRepository budgetsRepository;

    public BalanceRemainingByCategoryHandler(IBudgetsRepository budgetsRepository) {
        this.budgetsRepository = budgetsRepository;
    }

    @Override
    public BalanceRemainingByCategoryOutput handle(BalanceRemainingByCategoryQuery input) {
        Optional<DbBudgets> byId = budgetsRepository.findById(input.id);

        if (byId.isEmpty())
            throw new NotFoundException("budget", input.id);

        List<DbPurchases> purchases = byId.get().getPurchases().stream()
                .filter(dbPurchases -> dbPurchases.getCategory().getName().equalsIgnoreCase(input.name))
                .toList();


        BalanceRemainingByCategoryOutput output = new BalanceRemainingByCategoryOutput();
        output.month = byId.get().getMonth();
        output.year = byId.get().getYear();
        output.budget = byId.get().getBudget();
        output.balanceRemaining = output.budget;

        purchases.forEach(purchase -> output.balanceRemaining -= purchase.getAmount());

        return output;
    }
}
