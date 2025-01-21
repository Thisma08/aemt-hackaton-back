package school.be.hackaton_christmas_wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.be.hackaton_christmas_wallet.application.category.command.CategoryCommandProcessor;
import school.be.hackaton_christmas_wallet.application.category.command.CreateCategory.CreateCategoryCommand;
import school.be.hackaton_christmas_wallet.application.category.command.CreateCategory.CreateCategoryOutput;
import school.be.hackaton_christmas_wallet.application.category.command.UpdateCategory.UpdateCategoryCommand;
import school.be.hackaton_christmas_wallet.application.category.command.UpdateCategory.UpdateCategoryOutput;
import school.be.hackaton_christmas_wallet.application.category.querry.CategoryQueryProcessor;
import school.be.hackaton_christmas_wallet.application.category.querry.GetAllCategory.GetAllCategoryOutput;
import school.be.hackaton_christmas_wallet.application.category.querry.GetByIdCategory.GetByIdCategoryOutput;

@RestController
@RequestMapping("/v1/category")
public class ControllerCategory {
    private final CategoryCommandProcessor categoryCommandProcessor;
    private final CategoryQueryProcessor categoryQueryProcessor;

    public ControllerCategory(CategoryCommandProcessor categoryCommandProcessor, CategoryQueryProcessor categoryQueryProcessor) {
        this.categoryCommandProcessor = categoryCommandProcessor;
        this.categoryQueryProcessor = categoryQueryProcessor;
    }

    @PostMapping
    public ResponseEntity<CreateCategoryOutput> Create(@RequestBody CreateCategoryCommand command) {
        try {
            return ResponseEntity.ok(categoryCommandProcessor.Create(command));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping
    public ResponseEntity<UpdateCategoryOutput> Update(@RequestBody UpdateCategoryCommand command) {
        try {
            UpdateCategoryOutput created = categoryCommandProcessor.Update(command);
            return ResponseEntity.ok(created);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdCategoryOutput> GetById(@PathVariable long id) {
        GetByIdCategoryOutput byIdCategoryOutput = categoryQueryProcessor.getByIdCategoryOutput(id);
        if (byIdCategoryOutput == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(byIdCategoryOutput);
    }

    @GetMapping
    public ResponseEntity<GetAllCategoryOutput> GetAll() {
        return ResponseEntity.ok(categoryQueryProcessor.getGetAllCategoryHandler());
    }
}
