package school.be.hackaton_christmas_wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.be.hackaton_christmas_wallet.application.category.command.CategoryCommandProcessor;
import school.be.hackaton_christmas_wallet.application.category.command.UpdateCategory.UpdateCategoryCommand;
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
    public ResponseEntity<String> Create(@RequestBody String command) {
        try {
            String created = categoryCommandProcessor.Create(command.substring(1, command.length() - 1));
            return ResponseEntity.ok(created);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> Update(@RequestBody UpdateCategoryCommand command) {
        try {
            String created = categoryCommandProcessor.Update(command);
            return ResponseEntity.ok(created);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
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
