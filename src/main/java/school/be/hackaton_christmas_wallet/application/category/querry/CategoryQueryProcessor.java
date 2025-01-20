package school.be.hackaton_christmas_wallet.application.category.querry;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.category.querry.GetAllCategory.GetAllCategoryOutput;
import school.be.hackaton_christmas_wallet.application.category.querry.GetByIdCategory.GetByIdCategoryOutput;
import school.be.hackaton_christmas_wallet.application.utils.IEmptyQueryHandler;
import school.be.hackaton_christmas_wallet.application.utils.IQueryHandler;

@Service
public class CategoryQueryProcessor {

    private final IEmptyQueryHandler<GetAllCategoryOutput> getAllCategoryHandler;
    private final IQueryHandler<Long, GetByIdCategoryOutput> getByIdCategoryHandler;

    public CategoryQueryProcessor(IEmptyQueryHandler<GetAllCategoryOutput> getAllCategoryHandler,
                                  IQueryHandler<Long, GetByIdCategoryOutput> getByIdCategoryHandler) {
        this.getAllCategoryHandler = getAllCategoryHandler;
        this.getByIdCategoryHandler = getByIdCategoryHandler;
    }

    public GetAllCategoryOutput getGetAllCategoryHandler() {
        return getAllCategoryHandler.handle();
    }

    public GetByIdCategoryOutput getByIdCategoryOutput(long id) {
        return getByIdCategoryHandler.handle(id);
    }
}
