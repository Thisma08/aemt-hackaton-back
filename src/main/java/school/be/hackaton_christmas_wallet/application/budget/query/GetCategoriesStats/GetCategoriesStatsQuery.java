package school.be.hackaton_christmas_wallet.application.budget.query.GetCategoriesStats;

public class GetCategoriesStatsQuery {
    public int year;
    public int month;

    public GetCategoriesStatsQuery(int year, int month) {
        this.year = year;
        this.month = month;
    }
}
