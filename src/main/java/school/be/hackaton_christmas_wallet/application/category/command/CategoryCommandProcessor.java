package school.be.hackaton_christmas_wallet.application.category.command;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.category.command.UpdateCategory.UpdateCategoryCommand;
import school.be.hackaton_christmas_wallet.application.utils.ICommandHandler;

@Service
public class CategoryCommandProcessor {
    private final ICommandHandler<String, String> createCategoryHandler;
    private final ICommandHandler<UpdateCategoryCommand, String> updateCategoryHandler;

    public CategoryCommandProcessor(ICommandHandler<String, String> createCategoryHandler, ICommandHandler<UpdateCategoryCommand, String> updateCategoryHandler) {
        this.createCategoryHandler = createCategoryHandler;
        this.updateCategoryHandler = updateCategoryHandler;
    }


    public String Create(String command) throws Exception {
        return createCategoryHandler.handle(command);
    }

    public String Update(UpdateCategoryCommand command) throws Exception {
        return updateCategoryHandler.handle(command);
    }
}
