package school.be.hackaton_christmas_wallet.application.purchase.command.createPurchasing;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;
import school.be.hackaton_christmas_wallet.domains.exceptions.NotFoundException;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbCategories;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbPurchases;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbUsers;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IBudgetsRepository;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.ICategoriesRepository;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IUsersRepository;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.IPurchasesRepository;

import java.util.Optional;

@Service
public class CreatePurchasingHandler implements IQueryHandler<CreatePurchasingQuery, CreatePurchasingOutput> {
    private final IPurchasesRepository purchasesRepository;
    private final IBudgetsRepository budgetsRepository;
    private final ICategoriesRepository categoriesRepository;
    private final IUsersRepository usersRepository;

    public CreatePurchasingHandler(IPurchasesRepository purchasesRepository, IBudgetsRepository budgetsRepository, ICategoriesRepository categoriesRepository, IUsersRepository dbUsersRepository) {
        this.purchasesRepository = purchasesRepository;
        this.budgetsRepository = budgetsRepository;
        this.categoriesRepository = categoriesRepository;
        this.usersRepository = dbUsersRepository;
    }

    @Override
    public CreatePurchasingOutput handle(CreatePurchasingQuery input) {


        DbPurchases db = new DbPurchases();
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

        CreatePurchasingOutput createPurchasingOutput = new CreatePurchasingOutput();
        createPurchasingOutput.id = db.getId();
        createPurchasingOutput.category = db.getCategory().getName();
        createPurchasingOutput.budget = new CreatePurchasingOutput.BudgetOutput();
        createPurchasingOutput.budget.id = db.getBudget().getId();
        createPurchasingOutput.budget.month = db.getBudget().getMonth();
        createPurchasingOutput.budget.year = db.getBudget().getYear();
        createPurchasingOutput.budget.budget = db.getBudget().getBudget();

        createPurchasingOutput.amount = db.getAmount();
        createPurchasingOutput.purchaseDate = db.getPurchaseDate();
        return createPurchasingOutput;
    }
}
