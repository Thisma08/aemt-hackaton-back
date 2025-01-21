package school.be.hackaton_christmas_wallet.application.budget.command.CreateBudget;

import lombok.Data;

@Data
public class CreateBudgetOutput {
    public long id;
    public float budget;
    public int month;
    public int year;
}
