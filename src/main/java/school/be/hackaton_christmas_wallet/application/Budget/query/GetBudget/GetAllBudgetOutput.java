package school.be.hackaton_christmas_wallet.application.Budget.query.GetBudget;

import java.util.Date;
import java.util.List;

public class GetAllBudgetOutput {
    public List<MonthBudgetOutput> Budgets;

    public class MonthBudgetOutput {
        public String month;
        public int year;
        public float budget;
        public List<PurchassingOutput> Purchassings;
        // Budget
        public class PurchassingOutput {
            public Date date;
            public float amount;
            public float category;

        }
    }
}
