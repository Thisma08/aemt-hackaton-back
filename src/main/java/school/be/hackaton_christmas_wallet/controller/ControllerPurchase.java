package school.be.hackaton_christmas_wallet.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.be.hackaton_christmas_wallet.application.purchase.command.PurchasingCommandProcessor;
import school.be.hackaton_christmas_wallet.application.purchase.query.PurchaseQueryProcessor;
import school.be.hackaton_christmas_wallet.application.purchase.query.getAllPurchasing.GetAllPurchasingOutput;
import school.be.hackaton_christmas_wallet.application.purchase.command.createPurchasing.CreatePurchasingOutput;
import school.be.hackaton_christmas_wallet.application.purchase.command.createPurchasing.CreatePurchasingQuery;
import school.be.hackaton_christmas_wallet.application.purchase.command.updatePurchasing.UpdatePurchasingOutput;
import school.be.hackaton_christmas_wallet.application.purchase.command.updatePurchasing.UpdatePurchasingQuery;
import school.be.hackaton_christmas_wallet.domains.exceptions.NotFoundException;

@RestController
@RequestMapping("/v1/purchase")
public class ControllerPurchase {
    private final PurchaseQueryProcessor purchaseQueryProcessor;
    private final PurchasingCommandProcessor purchasingQueryProcessor;

    public ControllerPurchase(PurchaseQueryProcessor purchaseQueryProcessor, PurchasingCommandProcessor purchasingQueryProcessor) {
        this.purchaseQueryProcessor = purchaseQueryProcessor;
        this.purchasingQueryProcessor = purchasingQueryProcessor;
    }


    @GetMapping()
    public ResponseEntity<GetAllPurchasingOutput> GetAllBudget() {
        return ResponseEntity.ok(purchaseQueryProcessor.getAllPurchasing());
    }

    @PostMapping()
    public ResponseEntity<CreatePurchasingOutput> CreatePurchasing(@RequestBody CreatePurchasingQuery query) {
        return ResponseEntity.ok(purchasingQueryProcessor.CreatePurchasing(query));
    }
    @PatchMapping()
    public ResponseEntity<UpdatePurchasingOutput> UpdatePurchasing(@RequestBody UpdatePurchasingQuery query) {
        return ResponseEntity.ok(purchasingQueryProcessor.UpdatePurchasing(query));
    }

    @DeleteMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Todo successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Todo not found")
    })
    public ResponseEntity<Void> delete(@PathVariable long id) {
        try {
            purchasingQueryProcessor.delete(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
