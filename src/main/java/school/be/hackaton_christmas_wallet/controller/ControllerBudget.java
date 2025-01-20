package school.be.hackaton_christmas_wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.be.hackaton_christmas_wallet.application.Budget.BudgetQueryProcessor;

@RestController
@RequestMapping("/v1/Budget")
public class ControllerBudget {
    private final BudgetCommandProcessor budgetCommandProcessor;
    private final BudgetQueryProcessor budgetQueryProcessor;
    public ControllerBudget(BudgetCommandProcessor budgetCommandProcessor,BudgetQueryProcessor budgetQueryProcessor) {
        this.budgetCommandProcessor = budgetCommandProcessor;
        this.budgetQueryProcessor = budgetQueryProcessor;
    }


    @GetMapping()
    public ResponseEntity<GetAllBudgetOutput> GetAllBudget() {
        return ResponseEntity.ok(budgetQueryProcessor.GetAllBudget());
    }

    @PostMapping
    public ResponseEntity<CreateBudgetOutput> createBudget(@RequestBody CreateBudgetCommand command) {
        CreateBudgetOutput createdBudget = budgetCommandProcessor.create(command);
        return ResponseEntity.ok(createdBudget);
    }
}
