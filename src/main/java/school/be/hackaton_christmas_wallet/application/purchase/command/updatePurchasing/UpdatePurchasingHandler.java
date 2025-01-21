package school.be.hackaton_christmas_wallet.application.purchase.command.updatePurchasing;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;
import school.be.hackaton_christmas_wallet.domains.exceptions.NotFoundException;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbCategories;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbPurchases;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IBudgetsRepository;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.ICategoriesRepository;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IPurchasesRepository;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IUsersRepository;

import java.util.Optional;

@Service
public class UpdatePurchasingHandler implements IQueryHandler<UpdatePurchasingQuery, UpdatePurchasingOutput> {
    private final IPurchasesRepository purchasesRepository;
    private final IBudgetsRepository budgetsRepository;
    private final ICategoriesRepository categoriesRepository;
    private final IUsersRepository usersRepository;

    public UpdatePurchasingHandler(IPurchasesRepository purchasesRepository, IBudgetsRepository budgetsRepository, ICategoriesRepository categoriesRepository, IUsersRepository dbUsersRepository) {
        this.purchasesRepository = purchasesRepository;
        this.budgetsRepository = budgetsRepository;
        this.categoriesRepository = categoriesRepository;
        this.usersRepository = dbUsersRepository;
    }

    @Override
    public UpdatePurchasingOutput handle(UpdatePurchasingQuery input) {


        Optional<DbPurchases> dbPurchases = purchasesRepository.findById(input.id);
        if (dbPurchases.isEmpty())
            throw new NotFoundException("Budget", input.budgetId);
        DbPurchases db = dbPurchases.get();

        db.setAmount(input.amount);
        db.setPurchaseDate(input.purchaseDate);

        Optional<DbBudgets> dbBudgets = budgetsRepository.findById(input.budgetId);
        if (dbBudgets.isEmpty())
            throw new NotFoundException("Budget", input.budgetId);
        db.setBudget(dbBudgets.get());

        Optional<DbCategories> dbCategories = categoriesRepository.findById(input.categoryID);
        if (dbCategories.isEmpty())
            throw new NotFoundException("Categories", input.categoryID);
        db.setCategory(dbCategories.get());

        db = purchasesRepository.save(db);

        UpdatePurchasingOutput updatePurchasingOutput = new UpdatePurchasingOutput();
        updatePurchasingOutput.id = db.getId();
        updatePurchasingOutput.category = db.getCategory().getName();
        updatePurchasingOutput.budget = new UpdatePurchasingOutput.BudgetOutput();
        updatePurchasingOutput.budget.id = db.getBudget().getId();
        updatePurchasingOutput.budget.month = db.getBudget().getMonth();
        updatePurchasingOutput.budget.year = db.getBudget().getYear();
        updatePurchasingOutput.budget.budget = db.getBudget().getBudget();

        updatePurchasingOutput.amount = db.getAmount();
        updatePurchasingOutput.purchaseDate = db.getPurchaseDate();
        return updatePurchasingOutput;
    }
}
