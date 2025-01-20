package school.be.hackaton_christmas_wallet.application.Budget.command;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.Budget.command.CreateBudget.CreateBudgetCommand;
import school.be.hackaton_christmas_wallet.application.Budget.command.CreateBudget.CreateBudgetOutput;
import school.be.hackaton_christmas_wallet.application.utils.ICommandHandler;

@Service
public class BudgetCommandProcessor {
    private final ICommandHandler<CreateBudgetCommand, CreateBudgetOutput> createBudgetHandler;

    public BudgetCommandProcessor(ICommandHandler<CreateBudgetCommand, CreateBudgetOutput> createBudgetHandler) {
        this.createBudgetHandler = createBudgetHandler;
    }

    public CreateBudgetOutput create(CreateBudgetCommand command) {
        return createBudgetHandler.handle(command);
    }
}
