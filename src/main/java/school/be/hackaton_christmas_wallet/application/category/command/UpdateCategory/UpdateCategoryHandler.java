package school.be.hackaton_christmas_wallet.application.category.command.UpdateCategory;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.ICommandHandler;
import school.be.hackaton_christmas_wallet.domains.exceptions.NotFoundException;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbCategories;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.ICategoriesRepository;

@Service
public class UpdateCategoryHandler implements ICommandHandler<UpdateCategoryCommand, UpdateCategoryOutput> {

    private final ICategoriesRepository categoryRepository;

    public UpdateCategoryHandler(ICategoriesRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public UpdateCategoryOutput handle(UpdateCategoryCommand input) throws Exception {
        DbCategories db = categoryRepository.findById(input.id)
                .orElseThrow(() -> new NotFoundException("Categories", input.id));
        db.setName(input.name);
        db = categoryRepository.save(db);

        UpdateCategoryOutput updateCategoryOutput = new UpdateCategoryOutput();
        updateCategoryOutput.name = db.getName();
        updateCategoryOutput.id = db.getId();

        return updateCategoryOutput;
    }
}
