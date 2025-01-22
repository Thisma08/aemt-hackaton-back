package school.be.hackaton_christmas_wallet.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.be.hackaton_christmas_wallet.application.budget.command.BudgetCommandProcessor;
import school.be.hackaton_christmas_wallet.application.budget.command.CreateBudget.CreateBudgetCommand;
import school.be.hackaton_christmas_wallet.application.budget.command.CreateBudget.CreateBudgetOutput;
import school.be.hackaton_christmas_wallet.application.budget.command.UpdateBudget.UpdateBudgetCommand;
import school.be.hackaton_christmas_wallet.application.budget.query.BudgetQueryProcessor;
import school.be.hackaton_christmas_wallet.application.budget.query.GetBudget.GetAllBudgetOutput;
import school.be.hackaton_christmas_wallet.application.budget.query.GetBudgetById.GetBudgetByIdOutput;
import school.be.hackaton_christmas_wallet.application.budget.query.GetByCategoryDate.GetByCategoryDateOutput;
import school.be.hackaton_christmas_wallet.application.budget.query.GetByCategoryDate.GetByCategoryDateQuery;
import school.be.hackaton_christmas_wallet.application.budget.query.GetByDate.GetByDateOutput;
import school.be.hackaton_christmas_wallet.application.budget.query.GetByDate.GetByDateQuery;
import school.be.hackaton_christmas_wallet.application.budget.query.GetCategoriesStats.GetCategoriesStatsOutput;
import school.be.hackaton_christmas_wallet.application.budget.query.GetCategoriesStats.GetCategoriesStatsQuery;
import school.be.hackaton_christmas_wallet.application.budget.query.balanceRemaining.BalanceRemainingOutput;
import school.be.hackaton_christmas_wallet.application.budget.query.balanceRemainingByCategory.BalanceRemainingByCategoryHandler;
import school.be.hackaton_christmas_wallet.application.budget.query.balanceRemainingByCategory.BalanceRemainingByCategoryOutput;
import school.be.hackaton_christmas_wallet.application.budget.query.balanceRemainingByCategory.BalanceRemainingByCategoryQuery;
import school.be.hackaton_christmas_wallet.domains.exceptions.NotFoundException;

@RestController
@RequestMapping("/v1/Budget")
public class ControllerBudget {
    private final BudgetCommandProcessor budgetCommandProcessor;
    private final BudgetQueryProcessor budgetQueryProcessor;

    public ControllerBudget(BudgetCommandProcessor budgetCommandProcessor, BudgetQueryProcessor budgetQueryProcessor, BalanceRemainingByCategoryHandler balanceRemainingByCategoryHandler) {
        this.budgetCommandProcessor = budgetCommandProcessor;
        this.budgetQueryProcessor = budgetQueryProcessor;
    }


    @GetMapping()
    public ResponseEntity<GetAllBudgetOutput> GetAllBudget() {
        return ResponseEntity.ok(budgetQueryProcessor.GetAllBudget());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetBudgetByIdOutput> GetAllBudget(@PathVariable long id) {
        return ResponseEntity.ok(budgetQueryProcessor.GetBudgetById(id));
    }

    @GetMapping("/getCategoryStats/{month}/{year}")
    public GetCategoriesStatsOutput getCategoryStats(@PathVariable int month, @PathVariable int year) {
        GetCategoriesStatsQuery query = new GetCategoriesStatsQuery(year, month);
        return budgetQueryProcessor.GetCategoriesStats(query);
    }

    @PostMapping
    public ResponseEntity<CreateBudgetOutput> createBudget(@RequestBody CreateBudgetCommand command) {
        CreateBudgetOutput createdBudget = budgetCommandProcessor.create(command);
        return ResponseEntity.ok(createdBudget);
    }

    @PatchMapping("/{month}/{year}")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "budget successfully updated"),
            @ApiResponse(responseCode = "404", description = "budget not found")
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

    @PostMapping("/GetByCategoryDate/")
    public ResponseEntity<GetByCategoryDateOutput> GetByCategoryAndDateCategory(@RequestBody GetByCategoryDateQuery input) {
        return ResponseEntity.ok(budgetQueryProcessor.GetByCategoryAndDateCategory(input));
    }
    @PostMapping("/GetByDate/")
    public ResponseEntity<GetByDateOutput> GetByDateCategory(@RequestBody GetByDateQuery input) {
        return ResponseEntity.ok(budgetQueryProcessor.GetByDateCategory(input));
    }
}
