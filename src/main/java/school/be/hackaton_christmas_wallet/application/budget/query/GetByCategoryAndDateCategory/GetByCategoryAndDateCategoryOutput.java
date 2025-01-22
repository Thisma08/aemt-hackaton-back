package school.be.hackaton_christmas_wallet.application.budget.query.GetByCategoryAndDateCategory;

import school.be.hackaton_christmas_wallet.application.budget.query.GetBudget.GetAllBudgetOutput;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GetByCategoryAndDateCategoryOutput {
    public List<MonthBudgetOutput> Budgets = new ArrayList<>();

    public static class MonthBudgetOutput {
        public long id;
        public int month;
        public int year;
        public float budget;
        public float balanceRemaining;
        public float balanceTotal;
        public List<PurchasedOutput> Purchased = new ArrayList<>();

        // budget
        public static class PurchasedOutput {
            public long id;
            public LocalDateTime date;
            public float amount;
            public String category;
        }
    }
}
