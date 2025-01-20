package school.be.hackaton_christmas_wallet.application.Budget.command.UpdateBudget;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IEmptyOutputCommandHandler;
import school.be.hackaton_christmas_wallet.domains.exceptions.NotFoundException;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IBudgetsRepository;

@Service
public class UpdateBudgetHandler implements IEmptyOutputCommandHandler<UpdateBudgetCommand> {
    private final IBudgetsRepository budgetsRepository;
    private final ModelMapper modelMapper;

    public UpdateBudgetHandler(IBudgetsRepository budgetsRepository, ModelMapper modelMapper) {
        this.budgetsRepository = budgetsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void handle(UpdateBudgetCommand input) {
        DbBudgets existingBudget = budgetsRepository.findByMonthAndYear(input.month, input.year)
                .orElseThrow(() -> new NotFoundException(input.month, input.year));

        existingBudget.setBudget(input.budget);

        budgetsRepository.save(existingBudget);

    }
}
