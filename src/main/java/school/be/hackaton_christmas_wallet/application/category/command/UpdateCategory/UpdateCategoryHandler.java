package school.be.hackaton_christmas_wallet.application.category.command.UpdateCategory;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.ICommandHandler;
import school.be.hackaton_christmas_wallet.domains.exceptions.NotFoundException;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbCategories;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.ICategoriesRepository;

@Service
public class UpdateCategoryHandler implements ICommandHandler<UpdateCategoryCommand, String> {

    private final ICategoriesRepository categoryRepository;

    public UpdateCategoryHandler(ICategoriesRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String handle(UpdateCategoryCommand input) throws Exception {
        DbCategories db = categoryRepository.findById(input.id)
                .orElseThrow(() -> new NotFoundException("Categories", input.id));
        db.setName(input.name);
        return categoryRepository.save(db).getName();
    }
}
