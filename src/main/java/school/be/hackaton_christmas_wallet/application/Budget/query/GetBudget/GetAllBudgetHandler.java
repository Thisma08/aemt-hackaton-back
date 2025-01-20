package school.be.hackaton_christmas_wallet.application.Budget.query.GetBudget;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IEmptyOutputQueryHandler;

@Service
public class GetAllBudgetHandler implements IEmptyOutputQueryHandler<GetAllBudgetOutput> {
    @Override
    public void handle(GetAllBudgetOutput input) {

    }
}
