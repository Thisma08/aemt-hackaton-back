package school.be.hackaton_christmas_wallet.application.category.command.CreateCategory;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.ICommandHandler;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbCategories;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.ICategoriesRepository;

@Service
public class CreateCategoryHandler implements ICommandHandler<CreateCategoryCommand, CreateCategoryOutput> {

    private final ICategoriesRepository categoryRepository;

    public CreateCategoryHandler(ICategoriesRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CreateCategoryOutput handle(CreateCategoryCommand input) {
        DbCategories dbCategories = new DbCategories();
        dbCategories.setName(input.name);

        DbCategories savedCategory = categoryRepository.save(dbCategories);

        CreateCategoryOutput createCategoryOutput = new CreateCategoryOutput();
        createCategoryOutput.id = savedCategory.getId();
        createCategoryOutput.name = savedCategory.getName();

        return createCategoryOutput;
    }
}
