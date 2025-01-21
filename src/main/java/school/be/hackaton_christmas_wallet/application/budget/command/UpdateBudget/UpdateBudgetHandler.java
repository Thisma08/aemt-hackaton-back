package school.be.hackaton_christmas_wallet.application.budget.command.UpdateBudget;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IEmptyOutputCommandHandler;
import school.be.hackaton_christmas_wallet.domains.exceptions.NotFoundException;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IBudgetsRepository;

import java.time.LocalDate;

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
        LocalDate currentDate = LocalDate.now();

        if (input.year < currentDate.getYear() ||
                (input.year == currentDate.getYear() && input.month < currentDate.getMonthValue()) ||
                (input.month == currentDate.getMonthValue() && input.year == currentDate.getYear())) {
            throw new IllegalArgumentException("Impossible de modifier un budget pour un mois passé ou pour le mois courant.");
        }

        DbBudgets existingBudget = budgetsRepository.findByMonthAndYear(input.month, input.year)
                .orElseThrow(() -> new NotFoundException(input.month, input.year));

        existingBudget.setBudget(input.budget);

        budgetsRepository.save(existingBudget);

    }
}
