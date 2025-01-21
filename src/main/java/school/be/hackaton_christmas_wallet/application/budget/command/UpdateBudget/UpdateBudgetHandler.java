package school.be.hackaton_christmas_wallet.application.budget.command.UpdateBudget;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IEmptyOutputCommandHandler;
import school.be.hackaton_christmas_wallet.domains.exceptions.NotFoundException;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IBudgetsRepository;

import java.time.LocalDate;

@Service
public class UpdateBudgetHandler implements IEmptyOutputCommandHandler<UpdateBudgetCommand> {
    private final IBudgetsRepository budgetsRepository;

    public UpdateBudgetHandler(IBudgetsRepository budgetsRepository) {
        this.budgetsRepository = budgetsRepository;
    }

    @Override
    public void handle(UpdateBudgetCommand input) {
        LocalDate currentDate = LocalDate.now();

        if (input.year < currentDate.getYear() ||
                (input.year == currentDate.getYear() && input.month < currentDate.getMonthValue()) ||
                (input.month == currentDate.getMonthValue() && input.year == currentDate.getYear())) {
            throw new IllegalArgumentException("Impossible to modify a budget for a past month or for the current month.");
        }

        DbBudgets existingBudget = budgetsRepository.findByMonthAndYear(input.month, input.year)
                .orElseThrow(() -> new NotFoundException(input.month, input.year));

        existingBudget.setBudget(input.budget);

        budgetsRepository.save(existingBudget);

    }
}
