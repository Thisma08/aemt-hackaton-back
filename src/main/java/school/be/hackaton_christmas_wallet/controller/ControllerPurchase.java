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
import school.be.hackaton_christmas_wallet.application.budget.query.balanceRemaining.BalanceRemainingOutput;
import school.be.hackaton_christmas_wallet.application.budget.query.balanceRemainingByCategory.BalanceRemainingByCategoryHandler;
import school.be.hackaton_christmas_wallet.application.budget.query.balanceRemainingByCategory.BalanceRemainingByCategoryOutput;
import school.be.hackaton_christmas_wallet.application.budget.query.balanceRemainingByCategory.BalanceRemainingByCategoryQuery;
import school.be.hackaton_christmas_wallet.application.purchase.command.PurchaseCommandProcessor;
import school.be.hackaton_christmas_wallet.application.purchase.command.getAllPurchasing.GetAllPurchasingOutput;
import school.be.hackaton_christmas_wallet.domains.exceptions.NotFoundException;

@RestController
@RequestMapping("/v1/purchase")
public class ControllerPurchase {
    private final PurchaseCommandProcessor purchaseCommandProcessor;

    public ControllerPurchase(PurchaseCommandProcessor purchaseCommandProcessor) {
        this.purchaseCommandProcessor = purchaseCommandProcessor;
    }


    @GetMapping()
    public ResponseEntity<GetAllPurchasingOutput> GetAllBudget() {
        return ResponseEntity.ok(purchaseCommandProcessor.getAllPurchasing());
    }

}
