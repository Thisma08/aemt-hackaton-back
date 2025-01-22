package school.be.hackaton_christmas_wallet.application.budget.query.GetByDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GetByDateOutput {
    public long id;
    public int month;
    public int year;
    public float budget;
    public float balanceRemaining;
    public float balanceTotal;
    public List<PurchasedOutput> Purchased = new ArrayList<>();

    public static class PurchasedOutput {
        public long id;
        public LocalDateTime date;
        public float amount;
        public String category;
    }
}
