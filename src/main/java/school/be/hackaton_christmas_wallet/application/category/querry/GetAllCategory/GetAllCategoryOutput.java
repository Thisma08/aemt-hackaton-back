package school.be.hackaton_christmas_wallet.application.category.querry.GetAllCategory;

import java.util.ArrayList;
import java.util.List;

public class GetAllCategoryOutput {
    public List<CategoryOutput> categoryOutputList = new ArrayList<>();

    public static class CategoryOutput {
        public long id;
        public String name;
    }
}
