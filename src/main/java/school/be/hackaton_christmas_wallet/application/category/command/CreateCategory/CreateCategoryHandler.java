package school.be.hackaton_christmas_wallet.application.category.command.CreateCategory;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.ICommandHandler;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbCategories;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.ICategoriesRepository;

@Service
public class CreateCategoryHandler implements ICommandHandler<String, String> {

    private final ICategoriesRepository categoryRepository;

    public CreateCategoryHandler(ICategoriesRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String handle(String input) {
        DbCategories dbCategories = new DbCategories();
        dbCategories.setName(input);
        DbCategories savedCategory = categoryRepository.save(dbCategories);
        return savedCategory.getName();
    }
}
