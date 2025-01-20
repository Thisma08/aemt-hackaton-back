package school.be.hackaton_christmas_wallet.domains;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MonthBudget {
    private String month;
    private int year;
    private float budget;
    private List<Purchase> purchases;

    public MonthBudget(String month, int year, float budget, List<Purchase> purchases) {
        this.budget = budget;
        this.purchases = purchases;
        this.month = month;
        this.year = year;

        if (budget <= 0)
            throw new IllegalArgumentException("Budget too low");

        if (!(month.equalsIgnoreCase("January") ||
                month.equalsIgnoreCase("February") ||
                month.equalsIgnoreCase("March") ||
                month.equalsIgnoreCase("April") ||
                month.equalsIgnoreCase("May") ||
                month.equalsIgnoreCase("June") ||
                month.equalsIgnoreCase("July") ||
                month.equalsIgnoreCase("August") ||
                month.equalsIgnoreCase("September") ||
                month.equalsIgnoreCase("October") ||
                month.equalsIgnoreCase("November") ||
                month.equalsIgnoreCase("December")))
            throw new IllegalArgumentException("Invalid month");

        if (year < 2001 || year > LocalDate.now().getYear() + 1)
            throw new IllegalArgumentException("Invalid year");
    }

    public MonthBudget(int month, int year, float budget, List<Purchase> purchases) {
        this("Invalid month", year, budget, purchases);
        switch (month) {
            case 1:
                this.month = "January";
                break;
            case 2:
                this.month = "February";
                break;
            case 3:
                this.month = "March";
                break;
            case 4:
                this.month = "April";
                break;
            case 5:
                this.month = "May";
                break;
            case 6:
                this.month = "June";
                break;
            case 7:
                this.month = "July";
                break;
            case 8:
                this.month = "August";
                break;
            case 9:
                this.month = "September";
                break;
            case 10:
                this.month = "October";
                break;
            case 11:
                this.month = "November";
                break;
            case 12:
                this.month = "December";
                break;
            default:
                throw new IllegalArgumentException("Invalid month");
        }
    }

    public MonthBudget(int month, int year, float budget) {
        this("Invalid month", year, budget, new ArrayList<Purchase>());
        switch (month) {
            case 1:
                this.month = "January";
                break;
            case 2:
                this.month = "February";
                break;
            case 3:
                this.month = "March";
                break;
            case 4:
                this.month = "April";
                break;
            case 5:
                this.month = "May";
                break;
            case 6:
                this.month = "June";
                break;
            case 7:
                this.month = "July";
                break;
            case 8:
                this.month = "August";
                break;
            case 9:
                this.month = "September";
                break;
            case 10:
                this.month = "October";
                break;
            case 11:
                this.month = "November";
                break;
            case 12:
                this.month = "December";
                break;
            default:
                throw new IllegalArgumentException("Invalid month");
        }
    }

    private boolean purchase(Purchase purchase) {
        return purchases.add(purchase);
    }

    private float GetRemainingAmount() {
        float output = this.budget;
        for (Purchase purchase : purchases) {
            output -= purchase.getAmount();
        }
        return output;
    }
}
