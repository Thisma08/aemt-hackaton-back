package school.be.hackaton_christmas_wallet.application.Budget.query.balanceRemaining;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;
import school.be.hackaton_christmas_wallet.domains.exceptions.NotFoundException;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbPurchases;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IBudgetsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BalanceRemainingHandler implements IQueryHandler<Long, BalanceRemainingOutput> {

    private final IBudgetsRepository budgetsRepository;

    public BalanceRemainingHandler(IBudgetsRepository budgetsRepository) {
        this.budgetsRepository = budgetsRepository;
    }

    @Override
    public BalanceRemainingOutput handle(Long input) {
        Optional<DbBudgets> byId = budgetsRepository.findById(input);

        if (byId.isEmpty())
            throw new NotFoundException("budget", input);

        List<DbPurchases> purchases = byId.get().getPurchases();


        BalanceRemainingOutput output = new BalanceRemainingOutput();
        output.month = byId.get().getMonth();
        output.year = byId.get().getYear();
        output.budget = byId.get().getBudget();
        output.balanceRemaining = 0;

        purchases.forEach(purchase -> output.balanceRemaining += purchase.getAmount());

        return output;
    }
}
