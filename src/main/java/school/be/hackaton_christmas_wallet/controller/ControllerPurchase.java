package school.be.hackaton_christmas_wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.be.hackaton_christmas_wallet.application.purchase.command.PurchaseCommandProcessor;
import school.be.hackaton_christmas_wallet.application.purchase.command.getAllPurchasing.GetAllPurchasingOutput;
import school.be.hackaton_christmas_wallet.application.purchase.query.PurchasingQueryProcessor;
import school.be.hackaton_christmas_wallet.application.purchase.query.createPurchasing.CreatePurchasingOutput;
import school.be.hackaton_christmas_wallet.application.purchase.query.createPurchasing.CreatePurchasingQuery;

@RestController
@RequestMapping("/v1/purchase")
public class ControllerPurchase {
    private final PurchaseCommandProcessor purchaseCommandProcessor;
    private final PurchasingQueryProcessor purchasingQueryProcessor;

    public ControllerPurchase(PurchaseCommandProcessor purchaseCommandProcessor, PurchasingQueryProcessor purchasingQueryProcessor) {
        this.purchaseCommandProcessor = purchaseCommandProcessor;
        this.purchasingQueryProcessor = purchasingQueryProcessor;
    }


    @GetMapping()
    public ResponseEntity<GetAllPurchasingOutput> GetAllBudget() {
        return ResponseEntity.ok(purchaseCommandProcessor.getAllPurchasing());
    }

    @PostMapping()
    public ResponseEntity<CreatePurchasingOutput> CreatePurchasing(@RequestBody CreatePurchasingQuery query) {
        return ResponseEntity.ok(purchasingQueryProcessor.CreatePurchasing(query));
    }

}
