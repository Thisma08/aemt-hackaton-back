package school.be.hackaton_christmas_wallet.application.budget.query.GetBudgetById;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GetBudgetByIdOutput {
    public Long id;
    public int month;
    public int year;
    public float budget;
    public List<PurchasedOutput> Purchased = new ArrayList<>();

    public static class PurchasedOutput {
        public Long id;
        public LocalDateTime date;
        public float amount;
        public String category;
    }
}
