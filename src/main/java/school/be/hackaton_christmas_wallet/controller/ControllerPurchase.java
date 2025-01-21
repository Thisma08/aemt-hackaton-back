package school.be.hackaton_christmas_wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.be.hackaton_christmas_wallet.application.purchase.command.PurchasingCommandProcessor;
import school.be.hackaton_christmas_wallet.application.purchase.query.PurchaseQueryProcessor;
import school.be.hackaton_christmas_wallet.application.purchase.query.getAllPurchasing.GetAllPurchasingOutput;
import school.be.hackaton_christmas_wallet.application.purchase.command.createPurchasing.CreatePurchasingOutput;
import school.be.hackaton_christmas_wallet.application.purchase.command.createPurchasing.CreatePurchasingQuery;
import school.be.hackaton_christmas_wallet.application.purchase.command.updatePurchasing.UpdatePurchasingOutput;
import school.be.hackaton_christmas_wallet.application.purchase.command.updatePurchasing.UpdatePurchasingQuery;

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

}
