package school.be.hackaton_christmas_wallet.application.budget.query.GetBudgetById;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IBudgetsRepository;

import java.util.stream.Collectors;

@Service
public class GetBudgetByIdHandler implements IQueryHandler<Long, GetBudgetByIdOutput> {
    private final IBudgetsRepository budgetsRepository;

    public GetBudgetByIdHandler(IBudgetsRepository budgetsRepository) {
        this.budgetsRepository = budgetsRepository;
    }

    @Override
    public GetBudgetByIdOutput handle(Long id) {
        DbBudgets dbBudgets = budgetsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("budget not found for ID: " + id));

        GetBudgetByIdOutput output = new GetBudgetByIdOutput();
        output.id = dbBudgets.getId();
        output.month = dbBudgets.getMonth();
        output.year = dbBudgets.getYear();
        output.budget = dbBudgets.getBudget();

        output.Purchased = dbBudgets.getPurchases().stream()
                .map(purchase -> {
                    GetBudgetByIdOutput.PurchasedOutput purchasedOutput = new GetBudgetByIdOutput.PurchasedOutput();
                    purchasedOutput.id = purchase.getId();
                    purchasedOutput.date = purchase.getPurchaseDate();
                    purchasedOutput.amount = purchase.getAmount();
                    purchasedOutput.category = purchase.getCategory() != null ? purchase.getCategory().getName() : null;
                    return purchasedOutput;
                }).collect(Collectors.toList());

        return output;
    }
}

