package school.be.hackaton_christmas_wallet.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.be.hackaton_christmas_wallet.application.Budget.command.BudgetCommandProcessor;
import school.be.hackaton_christmas_wallet.application.Budget.command.CreateBudget.CreateBudgetCommand;
import school.be.hackaton_christmas_wallet.application.Budget.command.CreateBudget.CreateBudgetOutput;
import school.be.hackaton_christmas_wallet.application.Budget.command.UpdateBudget.UpdateBudgetCommand;
import school.be.hackaton_christmas_wallet.application.Budget.query.BudgetQueryProcessor;
import school.be.hackaton_christmas_wallet.application.Budget.query.GetBudget.GetAllBudgetOutput;
import school.be.hackaton_christmas_wallet.application.Budget.query.GetBudgetById.GetBudgetByIdHandler;
import school.be.hackaton_christmas_wallet.application.Budget.query.GetBudgetById.GetBudgetByIdOutput;
import school.be.hackaton_christmas_wallet.application.Budget.query.balanceRemaining.BalanceRemainingOutput;
import school.be.hackaton_christmas_wallet.application.Budget.query.balanceRemainingByCategory.BalanceRemainingByCategoryHandler;
import school.be.hackaton_christmas_wallet.application.Budget.query.balanceRemainingByCategory.BalanceRemainingByCategoryOutput;
import school.be.hackaton_christmas_wallet.application.Budget.query.balanceRemainingByCategory.BalanceRemainingByCategoryQuery;
import school.be.hackaton_christmas_wallet.domains.exceptions.NotFoundException;

@RestController
@RequestMapping("/v1/Budget")
public class ControllerBudget {
    private final BudgetCommandProcessor budgetCommandProcessor;
    private final BudgetQueryProcessor budgetQueryProcessor;
    private final BalanceRemainingByCategoryHandler balanceRemainingByCategoryHandler;

    public ControllerBudget(BudgetCommandProcessor budgetCommandProcessor, BudgetQueryProcessor budgetQueryProcessor, BalanceRemainingByCategoryHandler balanceRemainingByCategoryHandler) {
        this.budgetCommandProcessor = budgetCommandProcessor;
        this.budgetQueryProcessor = budgetQueryProcessor;
        this.balanceRemainingByCategoryHandler = balanceRemainingByCategoryHandler;
    }


    @GetMapping()
    public ResponseEntity<GetAllBudgetOutput> GetAllBudget() {
        return ResponseEntity.ok(budgetQueryProcessor.GetAllBudget());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetBudgetByIdOutput> GetAllBudget(@PathVariable long id) {
        return ResponseEntity.ok(budgetQueryProcessor.GetBudgetById(id));
    }

    @PostMapping
    public ResponseEntity<CreateBudgetOutput> createBudget(@RequestBody CreateBudgetCommand command) {
        CreateBudgetOutput createdBudget = budgetCommandProcessor.create(command);
        return ResponseEntity.ok(createdBudget);
    }

    @PatchMapping("/{month}/{year}")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Budget successfully updated"),
            @ApiResponse(responseCode = "404", description = "Budget not found")
    })
    public ResponseEntity<Void> update(@PathVariable int month, @PathVariable int year, @RequestBody UpdateBudgetCommand command) {
        try {
            command.month = month;
            command.year = year;
            budgetCommandProcessor.update(command);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/balanceRemaining/{id}")
    public ResponseEntity<BalanceRemainingOutput> balanceRemaining(@PathVariable Long id) {
        return ResponseEntity.ok(budgetQueryProcessor.balanceRemaining(id));
    }
    @GetMapping("/balanceRemainingByCategory/{id}")
    public ResponseEntity<BalanceRemainingByCategoryOutput> BalanceRemainingByCategory(@PathVariable Long id, String name) {
        BalanceRemainingByCategoryQuery input = new BalanceRemainingByCategoryQuery();

        input.id = id;
        input.name = name;

        return ResponseEntity.ok(budgetQueryProcessor.balanceRemainingByCategory(input));
    }
}
