package school.be.hackaton_christmas_wallet.application.purchase.command.updatePurchasing;

import java.time.LocalDateTime;

public class UpdatePurchasingOutput {

    public long id;
    public float amount;
    public LocalDateTime purchaseDate;
    public String category;
    public BudgetOutput budget;
    public static class BudgetOutput{
        public long id;
        public float budget;
        public int month;
        public int year;
    }
}
