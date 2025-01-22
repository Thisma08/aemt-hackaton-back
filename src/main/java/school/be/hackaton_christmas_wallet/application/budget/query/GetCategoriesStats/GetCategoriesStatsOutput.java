package school.be.hackaton_christmas_wallet.application.budget.query.GetCategoriesStats;

import java.util.ArrayList;
import java.util.List;

public class GetCategoriesStatsOutput {
    public List<CategoryStats> categoryStats = new ArrayList<>();

    public static class CategoryStats {
        public String categoryName;
        public float totalAmount;
    }
}