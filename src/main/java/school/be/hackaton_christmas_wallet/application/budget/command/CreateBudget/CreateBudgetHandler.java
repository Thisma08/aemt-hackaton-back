package school.be.hackaton_christmas_wallet.application.budget.command.CreateBudget;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.ICommandHandler;
import school.be.hackaton_christmas_wallet.domains.MonthBudget;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IBudgetsRepository;

@Service
public class CreateBudgetHandler implements ICommandHandler<CreateBudgetCommand, CreateBudgetOutput> {
    private final IBudgetsRepository budgetsRepository;
    private final ModelMapper modelMapper;

    public CreateBudgetHandler(IBudgetsRepository budgetsRepository, ModelMapper modelMapper) {
        this.budgetsRepository = budgetsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CreateBudgetOutput handle(CreateBudgetCommand input) {
        MonthBudget monthBudget = new MonthBudget(input.budget, input.month, input.year);

        DbBudgets dbBudgets = new DbBudgets();
        dbBudgets.setBudget(monthBudget.getBudget());
        dbBudgets.setMonth(getMonthNumber(monthBudget.getMonth()));
        dbBudgets.setYear(monthBudget.getYear());

        System.out.println("DbBudgets avant save: " + dbBudgets);

        DbBudgets dbBudgetsCreated = budgetsRepository.save(dbBudgets);

        System.out.println("DbBudgets après save: " + dbBudgetsCreated);

        CreateBudgetOutput output = new CreateBudgetOutput();
        output.setId(dbBudgetsCreated.getId());
        output.setBudget(dbBudgetsCreated.getBudget());
        output.setMonth(dbBudgetsCreated.getMonth());
        output.setYear(dbBudgetsCreated.getYear());

        System.out.println("CreateBudgetOutput: " + output);

        return output;
    }

    private int getMonthNumber(String monthName) {
        switch (monthName.toLowerCase()) {
            case "january": return 1;
            case "february": return 2;
            case "march": return 3;
            case "april": return 4;
            case "may": return 5;
            case "june": return 6;
            case "july": return 7;
            case "august": return 8;
            case "september": return 9;
            case "october": return 10;
            case "november": return 11;
            case "december": return 12;
            default: throw new IllegalArgumentException("Invalid month: " + monthName);
        }
    }
}
