package exam.music.init;

import exam.music.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {
    public DataInit(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    private final CategoryService categoryService;

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.seedData();
    }
}
