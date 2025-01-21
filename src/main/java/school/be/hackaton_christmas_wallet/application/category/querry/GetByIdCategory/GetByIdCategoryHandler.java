package school.be.hackaton_christmas_wallet.application.category.querry.GetByIdCategory;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbCategories;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.ICategoriesRepository;

import java.util.Optional;

@Service
public class GetByIdCategoryHandler implements IQueryHandler<Long, GetByIdCategoryOutput> {

    private final ICategoriesRepository categoryRepository;

    public GetByIdCategoryHandler(ICategoriesRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public GetByIdCategoryOutput handle(Long input) {
        GetByIdCategoryOutput getByIdCategoryOutput = new GetByIdCategoryOutput();
        Optional<DbCategories> byId = categoryRepository.findById(input);

        if (byId.isEmpty())
            return null;
        else{
            getByIdCategoryOutput.name = byId.get().getName();
            getByIdCategoryOutput.id = byId.get().getId();
        }

        return getByIdCategoryOutput;
    }
}
