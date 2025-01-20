package school.be.hackaton_christmas_wallet.application.Budget.query.GetBudgetById;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.Budget.query.GetBudget.GetAllBudgetOutput;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IBudgetsRepository;

import java.util.stream.Collectors;

@Service
public class GetBudgetByIdHandler {
    private final ModelMapper modelMapper;
    private final IBudgetsRepository budgetsRepository;

    public GetBudgetByIdHandler(IBudgetsRepository budgetsRepository, ModelMapper modelMapper) {
        this.budgetsRepository = budgetsRepository;
        this.modelMapper = modelMapper;
    }

    public GetBudgetByIdOutput handle(long id) {
        DbBudgets dbBudgets = budgetsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Budget not found for ID: " + id));

        GetBudgetByIdOutput output = new GetBudgetByIdOutput();
        output.month = dbBudgets.getMonth();
        output.year = dbBudgets.getYear();
        output.budget = dbBudgets.getBudget();

        output.Purchased = dbBudgets.getPurchases().stream()
                .map(purchase -> {
                    GetAllBudgetOutput.MonthBudgetOutput.PurchasedOutput purchasedOutput = new GetAllBudgetOutput.MonthBudgetOutput.PurchasedOutput();
                    purchasedOutput.date = purchase.getPurchaseDate();
                    purchasedOutput.amount = purchase.getAmount();
                    purchasedOutput.category = purchase.getCategory() != null ? purchase.getCategory().getName() : null;
                    return purchasedOutput;
                }).collect(Collectors.toList());

        return output;
    }
}
