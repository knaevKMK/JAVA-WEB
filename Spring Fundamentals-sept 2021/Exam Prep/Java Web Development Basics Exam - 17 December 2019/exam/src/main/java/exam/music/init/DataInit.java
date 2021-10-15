package exam.music.init;

import exam.music.service.CategoryService;
import exam.music.service.GenderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {

    private final CategoryService categoryService;
    private final GenderService genderService;

    public DataInit(CategoryService categoryService, GenderService genderService) {
        this.categoryService = categoryService;
        this.genderService = genderService;
    }


    @Override
    public void run(String... args) throws Exception {
        this.categoryService.seedData();
        this.genderService.seedData();
    }
}
