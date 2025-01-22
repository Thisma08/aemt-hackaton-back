package school.be.hackaton_christmas_wallet.application.budget.query.GetCategoriesStats;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;
import school.be.hackaton_christmas_wallet.domains.MonthBudget;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IBudgetsRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GetCategoriesStatsHandler implements IQueryHandler<GetCategoriesStatsQuery, GetCategoriesStatsOutput> {

    private final IBudgetsRepository budgetsRepository;

    public GetCategoriesStatsHandler(IBudgetsRepository budgetsRepository) {
        this.budgetsRepository = budgetsRepository;
    }

    @Override
    public GetCategoriesStatsOutput handle(GetCategoriesStatsQuery query) {
        DbBudgets dbBudget = budgetsRepository.findAll().stream()
                .filter(budget -> budget.getMonth() == query.month && budget.getYear() == query.year)
                .findFirst()
                .orElse(null);

        if (dbBudget == null) {
            throw new IllegalArgumentException("No budget found for the given month and year.");
        }

        Map<String, Float> categoryTotals = dbBudget.getPurchases().stream()
                .collect(Collectors.groupingBy(
                        purchase -> purchase.getCategory().getName(),
                        Collectors.summingDouble(purchase -> purchase.getAmount())
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().floatValue()));

        GetCategoriesStatsOutput output = new GetCategoriesStatsOutput();
        categoryTotals.forEach((category, total) -> {
            GetCategoriesStatsOutput.CategoryStats stats = new GetCategoriesStatsOutput.CategoryStats();
            stats.categoryName = category;
            stats.totalAmount = total;
            output.categoryStats.add(stats);
        });

        return output;
    }
}
