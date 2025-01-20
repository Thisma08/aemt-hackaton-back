package school.be.hackaton_christmas_wallet.application.Budget.command;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.Budget.command.CreateBudget.CreateBudgetCommand;
import school.be.hackaton_christmas_wallet.application.Budget.command.CreateBudget.CreateBudgetOutput;
import school.be.hackaton_christmas_wallet.application.Budget.command.UpdateBudget.UpdateBudgetCommand;
import school.be.hackaton_christmas_wallet.application.utils.ICommandHandler;
import school.be.hackaton_christmas_wallet.application.utils.IEmptyOutputCommandHandler;

@Service
public class BudgetCommandProcessor {
    private final ICommandHandler<CreateBudgetCommand, CreateBudgetOutput> createBudgetHandler;
    private final IEmptyOutputCommandHandler<UpdateBudgetCommand> updateBudgetHandler;

    public BudgetCommandProcessor(ICommandHandler<CreateBudgetCommand, CreateBudgetOutput> createBudgetHandler, IEmptyOutputCommandHandler<UpdateBudgetCommand> updateBudgetHandler) {
        this.createBudgetHandler = createBudgetHandler;
        this.updateBudgetHandler = updateBudgetHandler;
    }

    public CreateBudgetOutput create(CreateBudgetCommand command) {
        return createBudgetHandler.handle(command);
    }

    public void update(UpdateBudgetCommand command) {
        updateBudgetHandler.handle(command);
    }
}
