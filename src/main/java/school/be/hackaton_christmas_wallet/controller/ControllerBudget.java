package school.be.hackaton_christmas_wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.be.hackaton_christmas_wallet.application.Budget.command.BudgetCommandProcessor;
import school.be.hackaton_christmas_wallet.application.Budget.command.CreateBudget.CreateBudgetCommand;
import school.be.hackaton_christmas_wallet.application.Budget.command.CreateBudget.CreateBudgetOutput;

@RestController
@RequestMapping("/v1/Budget")
public class ControllerBudget {
    private final BudgetCommandProcessor budgetCommandProcessor;

    public ControllerBudget(BudgetCommandProcessor budgetCommandProcessor) {
        this.budgetCommandProcessor = budgetCommandProcessor;
    }

    @GetMapping()
    public ResponseEntity<String> GetBudget() {
        return ResponseEntity.ok("test");
    }

    @PostMapping
    public ResponseEntity<CreateBudgetOutput> createBudget(@RequestBody CreateBudgetCommand command) {
        CreateBudgetOutput createdBudget = budgetCommandProcessor.create(command);
        return ResponseEntity.ok(createdBudget);
    }
}
