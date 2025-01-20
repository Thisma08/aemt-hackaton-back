package school.be.hackaton_christmas_wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.be.hackaton_christmas_wallet.application.Budget.BudgetQueryProcessor;
import school.be.hackaton_christmas_wallet.application.Budget.query.GetBudget.GetAllBudgetOutput;

@RestController
@RequestMapping("/v1/Budget")
public class ControllerBudget {

    private BudgetQueryProcessor budgetQueryProcessor;

    public ControllerBudget(BudgetQueryProcessor budgetQueryProcessor) {
        this.budgetQueryProcessor = budgetQueryProcessor;
    }


    @GetMapping()
    public ResponseEntity<GetAllBudgetOutput> GetAllBudget() {
        return ResponseEntity.ok(budgetQueryProcessor.GetAllBudget());
    }
}
