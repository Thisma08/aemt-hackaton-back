package school.be.hackaton_christmas_wallet.application.budget.command.CreateBudget;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.ICommandHandler;
import school.be.hackaton_christmas_wallet.domains.MonthBudget;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbUsers;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IBudgetsRepository;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IUsersRepository;

@Service
public class CreateBudgetHandler implements ICommandHandler<CreateBudgetCommand, CreateBudgetOutput> {
    private final IBudgetsRepository budgetsRepository;
    private final IUsersRepository usersRepository;

    public CreateBudgetHandler(IBudgetsRepository budgetsRepository, IUsersRepository usersRepository) {
        this.budgetsRepository = budgetsRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public CreateBudgetOutput handle(CreateBudgetCommand input) {
        MonthBudget monthBudget = new MonthBudget(input.budget, input.month, input.year);

        DbBudgets dbBudgets = new DbBudgets();
        dbBudgets.setBudget(monthBudget.getBudget());
        dbBudgets.setMonth(getMonthNumber(monthBudget.getMonth()));
        dbBudgets.setYear(monthBudget.getYear());
        dbBudgets.setUser(usersRepository.findById(1L).orElse(new DbUsers()));
        System.out.println("Users : "+dbBudgets.getUser());

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
        return switch (monthName.toLowerCase()) {
            case "january" -> 1;
            case "february" -> 2;
            case "march" -> 3;
            case "april" -> 4;
            case "may" -> 5;
            case "june" -> 6;
            case "july" -> 7;
            case "august" -> 8;
            case "september" -> 9;
            case "october" -> 10;
            case "november" -> 11;
            case "december" -> 12;
            default -> throw new IllegalArgumentException("Invalid month: " + monthName);
        };
    }
}
