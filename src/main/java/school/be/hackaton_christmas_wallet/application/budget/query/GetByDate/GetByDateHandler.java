package school.be.hackaton_christmas_wallet.application.budget.query.GetByDate;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IBudgetsRepository;

@Service
public class GetByDateHandler implements IQueryHandler<GetByDateQuery, GetByDateOutput> {

    private final IBudgetsRepository budgetsRepository;

    public GetByDateHandler(IBudgetsRepository budgetsRepository) {
        this.budgetsRepository = budgetsRepository;
    }

    @Override
    public GetByDateOutput handle(GetByDateQuery input) {

        DbBudgets dbBudget = budgetsRepository.findAll().stream()
                .filter(budget -> budget.getMonth() == input.month && budget.getYear() == input.year)
                .findFirst()
                .orElse(null);


        // TODO : gerer exception
        if (dbBudget == null) {
            return new GetByDateOutput();
        }

        GetByDateOutput output = new GetByDateOutput();
        GetByDateOutput.PurchasedOutput monthBudgetOutput = new GetByDateOutput.PurchasedOutput();
        output.id = dbBudget.getId();
        output.month = dbBudget.getMonth();
        output.year = dbBudget.getYear();
        output.budget = dbBudget.getBudget();
        output.balanceRemaining = dbBudget.getBudget();

        dbBudget.getPurchases().forEach(dbPurchases -> {
            GetByDateOutput.PurchasedOutput e = new GetByDateOutput.PurchasedOutput();
            e.id = dbPurchases.getId();
            e.date = dbPurchases.getPurchaseDate();
            e.category = dbPurchases.getCategory().getName();
            e.amount = dbPurchases.getAmount();
            output.balanceRemaining -= e.amount;
            output.balanceTotal += e.amount;


            output.Purchased.add(e);
        });

        return output;
    }
}