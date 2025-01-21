package school.be.hackaton_christmas_wallet.application.budget.query.GetBudget;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IEmptyQueryHandler;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IBudgetsRepository;

import java.util.List;

@Service
public class GetAllBudgetHandler implements IEmptyQueryHandler<GetAllBudgetOutput> {
    private final IBudgetsRepository budgetsRepository;

    public GetAllBudgetHandler(IBudgetsRepository budgetsRepository) {
        this.budgetsRepository = budgetsRepository;
    }

    @Override
    public GetAllBudgetOutput handle() {
        List<DbBudgets> dbBudgets = budgetsRepository.findAll();
        GetAllBudgetOutput output = new GetAllBudgetOutput();
        dbBudgets.forEach(dbBudget -> {
            GetAllBudgetOutput.MonthBudgetOutput monthBudgetOutput = new GetAllBudgetOutput.MonthBudgetOutput();

            monthBudgetOutput.id = dbBudget.getId();
            monthBudgetOutput.budget = dbBudget.getBudget();
            monthBudgetOutput.month = dbBudget.getMonth();
            monthBudgetOutput.year = dbBudget.getYear();
            dbBudget.getPurchases().forEach(purchase -> {
                GetAllBudgetOutput.MonthBudgetOutput.PurchasedOutput tmp = new GetAllBudgetOutput.MonthBudgetOutput.PurchasedOutput();
                tmp.id = purchase.getId();
                tmp.amount = purchase.getAmount();
                tmp.date = purchase.getPurchaseDate();
                tmp.category = purchase.getCategory().getName();
                monthBudgetOutput.Purchased.add(tmp);
            });

            output.Budgets.add(monthBudgetOutput);
        });
        return output;
    }

}
