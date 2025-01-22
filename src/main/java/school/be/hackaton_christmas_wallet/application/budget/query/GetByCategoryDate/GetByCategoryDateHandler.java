package school.be.hackaton_christmas_wallet.application.budget.query.GetByCategoryDate;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IBudgetsRepository;

@Service
public class GetByCategoryDateHandler implements IQueryHandler<GetByCategoryDateQuery, GetByCategoryDateOutput> {

    private final IBudgetsRepository budgetsRepository;

    public GetByCategoryDateHandler(IBudgetsRepository budgetsRepository) {
        this.budgetsRepository = budgetsRepository;
    }

    @Override
    public GetByCategoryDateOutput handle(GetByCategoryDateQuery input) {

        DbBudgets dbBudget = budgetsRepository.findAll().stream()
                .filter(budget -> budget.getMonth() == input.month && budget.getYear() == input.year)
                .findFirst()
                .orElse(null);


        // TODO : gerer exception
        if (dbBudget == null) {
            return new GetByCategoryDateOutput();
        }

        GetByCategoryDateOutput output = new GetByCategoryDateOutput();
        GetByCategoryDateOutput.MonthBudgetOutput monthBudgetOutput = new GetByCategoryDateOutput.MonthBudgetOutput();

        monthBudgetOutput.id = dbBudget.getId();
        monthBudgetOutput.budget = dbBudget.getBudget();
        monthBudgetOutput.month = dbBudget.getMonth();
        monthBudgetOutput.year = dbBudget.getYear();
        monthBudgetOutput.balanceRemaining = monthBudgetOutput.budget;

        dbBudget.getPurchases().stream()
                .filter(purchase -> purchase.getCategory().getName().equalsIgnoreCase(input.category))
                .forEach(purchase -> {
                    GetByCategoryDateOutput.MonthBudgetOutput.PurchasedOutput tmp = new GetByCategoryDateOutput.MonthBudgetOutput.PurchasedOutput();
                    tmp.id = purchase.getId();
                    tmp.amount = purchase.getAmount();
                    tmp.date = purchase.getPurchaseDate();
                    tmp.category = purchase.getCategory().getName();
                    monthBudgetOutput.balanceRemaining -= tmp.amount;
                    monthBudgetOutput.balanceTotal += tmp.amount;
                    monthBudgetOutput.Purchased.add(tmp);
                });

        output.Budgets.add(monthBudgetOutput);
        return output;
    }
}
