package school.be.hackaton_christmas_wallet.application.purchase.command.updatePurchasing;

import java.time.LocalDateTime;

public class UpdatePurchasingQuery {
    public long id;
    public float amount;
    public LocalDateTime purchaseDate;
    public long categoryID;
    public long budgetId;
}
