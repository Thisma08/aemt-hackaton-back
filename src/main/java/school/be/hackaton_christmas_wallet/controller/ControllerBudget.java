package school.be.hackaton_christmas_wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.be.hackaton_christmas_wallet.application.Budget.BudgetQueryProcessor;
import school.be.hackaton_christmas_wallet.application.Budget.command.BudgetCommandProcessor;
import school.be.hackaton_christmas_wallet.application.Budget.command.CreateBudget.CreateBudgetCommand;
import school.be.hackaton_christmas_wallet.application.Budget.command.CreateBudget.CreateBudgetOutput;
import school.be.hackaton_christmas_wallet.application.Budget.query.GetBudget.GetAllBudgetOutput;

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
