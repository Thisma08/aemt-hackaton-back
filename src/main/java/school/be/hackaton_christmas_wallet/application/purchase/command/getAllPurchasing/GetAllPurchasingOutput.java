package school.be.hackaton_christmas_wallet.application.purchase.command.getAllPurchasing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GetAllPurchasingOutput {
    public List<PurchasingOutput> Purchasings = new ArrayList<>();

    public static class PurchasingOutput {
        public long id;
        public LocalDateTime date;
        public float amount;
        public String category;
    }
}
