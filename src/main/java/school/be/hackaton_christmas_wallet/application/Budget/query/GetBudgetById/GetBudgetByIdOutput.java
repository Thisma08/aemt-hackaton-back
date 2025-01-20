package school.be.hackaton_christmas_wallet.application.Budget.query.GetBudgetById;

import school.be.hackaton_christmas_wallet.application.Budget.query.GetBudget.GetAllBudgetOutput;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GetBudgetByIdOutput {
    public int month;
    public int year;
    public float budget;
    public List<GetAllBudgetOutput.MonthBudgetOutput.PurchasedOutput> Purchased = new ArrayList<>();

    public static class PurchasedOutput {
        public LocalDateTime date;
        public float amount;
        public String category;
    }
}
