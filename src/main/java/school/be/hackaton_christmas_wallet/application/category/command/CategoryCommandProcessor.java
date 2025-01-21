package school.be.hackaton_christmas_wallet.application.category.command;

import org.springframework.stereotype.Service;
import school.be.hackaton_christmas_wallet.application.category.command.CreateCategory.CreateCategoryOutput;
import school.be.hackaton_christmas_wallet.application.category.command.UpdateCategory.UpdateCategoryCommand;
import school.be.hackaton_christmas_wallet.application.category.command.UpdateCategory.UpdateCategoryOutput;
import school.be.hackaton_christmas_wallet.application.utils.ICommandHandler;

@Service
public class CategoryCommandProcessor {
    private final ICommandHandler<String, CreateCategoryOutput> createCategoryHandler;
    private final ICommandHandler<UpdateCategoryCommand, UpdateCategoryOutput> updateCategoryHandler;

    public CategoryCommandProcessor(ICommandHandler<String, CreateCategoryOutput> createCategoryHandler, ICommandHandler<UpdateCategoryCommand, UpdateCategoryOutput> updateCategoryHandler) {
        this.createCategoryHandler = createCategoryHandler;
        this.updateCategoryHandler = updateCategoryHandler;
    }


    public CreateCategoryOutput Create(String command) throws Exception {
        return createCategoryHandler.handle(command);
    }

    public UpdateCategoryOutput Update(UpdateCategoryCommand command) throws Exception {
        return updateCategoryHandler.handle(command);
    }
}
