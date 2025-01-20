package school.be.hackaton_christmas_wallet.application.category.querry.GetAllCategory;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.utils.IEmptyQueryHandler;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbCategories;
import school.be.hackaton_christmas_wallet.infrastructure.repositories.ICategoriesRepository;

import java.util.List;

@Service
public class GetAllCategoryHandler implements IEmptyQueryHandler<GetAllCategoryOutput> {

    private final ICategoriesRepository categoryRepository;

    public GetAllCategoryHandler(ICategoriesRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public GetAllCategoryOutput handle() {

        List<DbCategories> dbCategories = categoryRepository.findAll();
        GetAllCategoryOutput output = new GetAllCategoryOutput();

        dbCategories.forEach(dbCategory -> {
            GetAllCategoryOutput.CategoryOutput outputTmp = new GetAllCategoryOutput.CategoryOutput();

//            outputTmp.id = dbCategory.getId();
            outputTmp.name = dbCategory.getName();

            output.categoryOutputList.add(outputTmp);
        });

        return output;
    }
}
