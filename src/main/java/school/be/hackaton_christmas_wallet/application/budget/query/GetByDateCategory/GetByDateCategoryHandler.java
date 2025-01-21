package school.be.hackaton_christmas_wallet.application.budget.query.GetByDateCategory;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IBudgetsRepository;

@Service
public class GetByDateCategoryHandler implements IQueryHandler<GetByDateCategoryQuery, GetByDateCategoryOutput> {

    private final IBudgetsRepository budgetsRepository;

    public GetByDateCategoryHandler(IBudgetsRepository budgetsRepository) {
        this.budgetsRepository = budgetsRepository;
    }

    @Override
    public GetByDateCategoryOutput handle(GetByDateCategoryQuery input) {

        DbBudgets dbBudget = budgetsRepository.findAll().stream()
                .filter(budget -> budget.getMonth() == input.month && budget.getYear() == input.year)
                .findFirst()
                .orElse(null);


        // TODO : gerer exception
        if (dbBudget == null) {
            return new GetByDateCategoryOutput();
        }

        GetByDateCategoryOutput output = new GetByDateCategoryOutput();
        GetByDateCategoryOutput.PurchasedOutput monthBudgetOutput = new GetByDateCategoryOutput.PurchasedOutput();
        output.id = dbBudget.getId();
        output.month = dbBudget.getMonth();
        output.year = dbBudget.getYear();
        output.budget = dbBudget.getBudget();
        output.balanceRemaining = dbBudget.getBudget();
        dbBudget.getPurchases().forEach(dbPurchases -> {
            GetByDateCategoryOutput.PurchasedOutput e = new GetByDateCategoryOutput.PurchasedOutput();

            e.id = dbPurchases.getId();
            e.date = dbPurchases.getPurchaseDate();
            e.category = dbPurchases.getCategory().getName();
            e.amount = dbPurchases.getAmount();
            output.balanceRemaining -= e.amount;
            
            output.Purchased.add(e);
        });

        return output;
    }
}