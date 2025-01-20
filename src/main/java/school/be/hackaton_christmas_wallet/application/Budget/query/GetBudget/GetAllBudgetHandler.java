package school.be.hackaton_christmas_wallet.application.Budget.query.GetBudget;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IEmptyQueryHandler;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IBudgetsRepository;

import java.io.Console;
import java.util.List;
import java.util.logging.Logger;

@Service
public class GetAllBudgetHandler implements IEmptyQueryHandler<GetAllBudgetOutput> {
    private ModelMapper modelMapper;
    private IBudgetsRepository budgetsRepository;

    public GetAllBudgetHandler(ModelMapper modelMapper, IBudgetsRepository budgetsRepository) {
        this.modelMapper = modelMapper;
        this.budgetsRepository = budgetsRepository;
    }

    @Override
    public GetAllBudgetOutput handle() {
        List<DbBudgets> dbBudgets = budgetsRepository.findAll();
        GetAllBudgetOutput output = new GetAllBudgetOutput();
        dbBudgets.forEach(dbBudget -> {
            GetAllBudgetOutput.MonthBudgetOutput monthBudgetOutput = new GetAllBudgetOutput.MonthBudgetOutput();

            monthBudgetOutput.budget = dbBudget.getBudget();
            monthBudgetOutput.month = dbBudget.getMonth();
            monthBudgetOutput.year = dbBudget.getYear();
            System.out.println(dbBudget.getPurchases());
//           dbBudget.getPurchases().forEach(purchase -> {
//                GetAllBudgetOutput.MonthBudgetOutput.PurchasedOutput tmp = new GetAllBudgetOutput.MonthBudgetOutput.PurchasedOutput();
//                tmp.amount = purchase.getAmount();
//                tmp.date = purchase.getPurchaseDate();
//                tmp.category = purchase.getCategory().getName();
//                monthBudgetOutput.Purchased.add(tmp);
//            });

            output.Budgets.add(monthBudgetOutput);
        });
        return output;
    }

}
