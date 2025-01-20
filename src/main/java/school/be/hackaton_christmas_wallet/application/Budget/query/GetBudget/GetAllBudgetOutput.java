package school.be.hackaton_christmas_wallet.application.Budget.query.GetBudget;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GetAllBudgetOutput {
    public List<MonthBudgetOutput> Budgets = new ArrayList<>();

    public static class MonthBudgetOutput {
        public int month;
        public int year;
        public float budget;
        public List<PurchasedOutput> Purchased = new ArrayList<>();

        // Budget
        public static class PurchasedOutput {
            public LocalDateTime date;
            public float amount;
            public String category;

        }
    }
}
