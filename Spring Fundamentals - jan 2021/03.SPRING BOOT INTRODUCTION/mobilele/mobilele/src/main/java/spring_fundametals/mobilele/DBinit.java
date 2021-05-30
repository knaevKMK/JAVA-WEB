package spring_fundametals.mobilele;


import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring_fundametals.mobilele.model.entites.*;
import spring_fundametals.mobilele.model.entites.enums.CategoryEnum;
import spring_fundametals.mobilele.model.entites.enums.EngineEnum;
import spring_fundametals.mobilele.model.entites.enums.TransmissionEnum;
import spring_fundametals.mobilele.repositories.BrandRepository;
import spring_fundametals.mobilele.repositories.ModelRepository;
import spring_fundametals.mobilele.repositories.OfferRepository;
import spring_fundametals.mobilele.repositories.UserRepository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Component
public class DBinit implements CommandLineRunner {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final OfferRepository offerRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public DBinit(ModelRepository modelRepository, BrandRepository brandRepository,
                  OfferRepository offerRepository, PasswordEncoder pe,
                  UserRepository userRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.offerRepository = offerRepository;
        this.passwordEncoder = pe;
        this.userRepository = userRepository;
    }


    @Transactional
    @Override
    public void run(String... args) throws Exception {
        BrandEntity fordBrand = new BrandEntity();
        fordBrand.setName("Ford");
        setCurrentTimestamps(fordBrand);


        BrandEntity bmwBrand = new BrandEntity();
        bmwBrand.setName("BMW");
        setCurrentTimestamps(bmwBrand);

        brandRepository.saveAll(List.of(fordBrand, bmwBrand));

        ModelEntity fiesta = initModel(
                fordBrand
                , "fiesta"
                , CategoryEnum.CAR
                , "https://www.motopfohe.bg/files/news/archive/2017/08/blob-server.jpg"
                , 1976
                , null);

        ModelEntity transit = initModel(
                fordBrand
                , "Transit"
                , CategoryEnum.BUSS
                , "https://st.mascus.com/imagetilewm/product/vehoalkali/ford-transit,aw102165_1.jpg"
                , 1987
                , null);

        ModelEntity e46 = initModel(
                bmwBrand
                , "e46"
                , CategoryEnum.CAR
                , "https://cdn3.focus.bg/autodata/i/bmw/3er/3er-e46/medium/e97806ef0fcb34e9a093dc3021772ede.jpg"
                , 1996
                , 2020);
        ModelEntity s100rr = initModel(
                bmwBrand
                , "S1000RR"
                , CategoryEnum.MOTORCYCLE
                , "https://www.bmw-motorrad.bg/content/dam/bmwmotorradnsc/common/images/models/modeloverview/2020/nsc-master-modeloverview-m1000rr-P0N3H_600x360.jpg.asset.1600851390437.jpg"
                , 2011
                , null);

        modelRepository.saveAll(List.of(fiesta, transit, e46, s100rr));

        createOffer(fiesta
                , EngineEnum.GASOLINE
                , "https://autobild.bg/wp-content/uploads/2020/02/Ford-Fiesta-ST-2016-Gebraucht-MK7-PS-Turbo-474x316-2a9fa0357398d94c.jpg"
                , 15000
                , new BigDecimal(12000)
                , 2019
                , "Deutche grany drive it. Stay in garage"
                , TransmissionEnum.MANUAL);

        createOffer(e46
                , EngineEnum.DIESEL
                , "https://www.nastarta.com/wp-content/uploads/2019/05/30-years-of-BMW-M3-E46-M3-CSL.jpg"
                , 150000
                , new BigDecimal(3000)
                , 2007
                , "Deutche grany drive it. Stay in garage"
                , TransmissionEnum.AUTOMATIC);

        initAdmin();

    }

    private void initAdmin() {
        UserEntity admin = new UserEntity();

        admin.setFirstName("Peter")
                .setLastName("Smith")
                .setUsername("admin")
                .setPassword(this.passwordEncoder.encode("top"));
        userRepository.save(admin);
    }

    private void createOffer(ModelEntity model, EngineEnum engine, String imgUrl, int millage, BigDecimal price, int year,
                             String descritpition, TransmissionEnum transmision) {
        OfferEntity offer = new OfferEntity();
        offer.setModel(model)
                .setEngine(engine)
                .setImageUrl(imgUrl)
                .setMileage(millage)
                .setPrice(price)
                .setYear(year)
                .setDescription(descritpition)
                .setTransmission(transmision);
        setCurrentTimestamps(offer);
        offerRepository.save(offer);
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
