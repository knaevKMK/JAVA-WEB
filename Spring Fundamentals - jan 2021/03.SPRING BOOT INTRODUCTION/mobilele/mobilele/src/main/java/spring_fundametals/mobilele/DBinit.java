package spring_fundametals.mobilele;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring_fundametals.mobilele.model.entites.BaseEntity;
import spring_fundametals.mobilele.model.entites.BrandEntity;
import spring_fundametals.mobilele.model.entites.ModelEntity;
import spring_fundametals.mobilele.model.entites.enums.CategoryEnum;
import spring_fundametals.mobilele.repositories.BrandRepository;
import spring_fundametals.mobilele.repositories.ModelRepository;

import java.time.Instant;
import java.util.List;

@Component
public class DBinit implements CommandLineRunner {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public DBinit(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        BrandEntity fordBrand = new BrandEntity();
        fordBrand.setName("Ford");
        setCurrentTimestamps(fordBrand);

        ModelEntity fiesta = initModel(
                fordBrand
                , "fiesta"
                , CategoryEnum.CAR
                , "https://www.motopfohe.bg/files/news/archive/2017/08/blob-server.jpg"
                , 1976
                , null);


        BrandEntity bmwBrand = new BrandEntity();
        bmwBrand.setName("BMW");
        setCurrentTimestamps(bmwBrand);
        ModelEntity e46 = initModel(
                bmwBrand
                , "e46"
                , CategoryEnum.CAR
                , "https://cdn3.focus.bg/autodata/i/bmw/3er/3er-e46/medium/e97806ef0fcb34e9a093dc3021772ede.jpg"
                , 1996
                , 2008);
        brandRepository.saveAll(List.of(fordBrand, bmwBrand));
        modelRepository.saveAll(List.of(fiesta,e46));
    }

    private ModelEntity initModel(BrandEntity brand, String name, CategoryEnum category, String imgUrl, int startYear, Integer endYear) {
        ModelEntity model = new ModelEntity();
        model.setBrand(brand)
                .setName(name)
                .setCategory(category)
                .setImageUrl(imgUrl)
                .setStartYear(startYear)
                .setEdnYear(endYear);
        setCurrentTimestamps(model);
        return model;
    }

    private static void setCurrentTimestamps(BaseEntity baseEntity) {
        baseEntity.setCreated(Instant.now())
                .setUpdated(Instant.now());
    }
}
