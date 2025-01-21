package school.be.hackaton_christmas_wallet.application.budget.command.UpdateBudget;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UpdateBudgetCommand {
    public float budget;
    @JsonIgnore
    public int month;
    @JsonIgnore
    public int year;
}
