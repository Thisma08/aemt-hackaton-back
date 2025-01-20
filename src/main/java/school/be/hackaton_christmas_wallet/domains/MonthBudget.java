package school.be.hackaton_christmas_wallet.domains;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MonthBudget {
    @Getter
    private float budget;
    @Getter
    private String month;
    @Getter
    private int year;
    private List<Purchase> purchases;

    public MonthBudget(float budget, String month, int year, List<Purchase> purchases) {
        this.budget = budget;
        this.month = month;
        this.year = year;
        this.purchases = purchases;


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

    public MonthBudget(float budget, int month, int year, List<Purchase> purchases) {
        this(budget, "Invalid month", year, purchases);
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

    public MonthBudget(float budget, int month, int year) {
        this.budget = budget;

        if (budget <= 0) {
            throw new IllegalArgumentException("Budget too low");
        }

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month");
        }

        this.month = switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> throw new IllegalArgumentException("Invalid month");
        };

        if (year < 2001 || year > LocalDate.now().getYear() + 1) {
            throw new IllegalArgumentException("Invalid year");
        }

        this.year = year;
        this.purchases = new ArrayList<>();
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
