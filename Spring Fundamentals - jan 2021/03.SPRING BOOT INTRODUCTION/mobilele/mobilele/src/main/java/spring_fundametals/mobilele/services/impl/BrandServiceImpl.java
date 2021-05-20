package spring_fundametals.mobilele.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import spring_fundametals.mobilele.model.entites.BrandEntity;
import spring_fundametals.mobilele.model.entites.ModelEntity;
import spring_fundametals.mobilele.model.view.BrandViewModel;
import spring_fundametals.mobilele.model.view.ModelViewModel;
import spring_fundametals.mobilele.repositories.BrandRepository;
import spring_fundametals.mobilele.repositories.ModelRepository;
import spring_fundametals.mobilele.services.BrandService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;

    private final ModelMapper modelMapper;


    public BrandServiceImpl(BrandRepository brandRepository, ModelRepository modelRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandViewModel> getAllBrands() {

        List<BrandViewModel> result = new ArrayList<>();

        List<ModelEntity> allModels = modelRepository.findAll();

        ModelMapper modelMapper = new ModelMapper();

        allModels.forEach(me -> {
            BrandEntity brandEntity = me.getBrand();
            Optional<BrandViewModel> brandViewModelOptional =
                    findByName(result, brandEntity.getName());
            System.out.println(brandViewModelOptional);
            if (brandViewModelOptional.isEmpty()) {
                BrandViewModel brandViewModel = new BrandViewModel();
                modelMapper.map(brandEntity, brandViewModel);
                result.add((brandViewModel));
                brandViewModelOptional = Optional.of(brandViewModel);
            }
          //  System.out.println(brandViewModelOptional);
            ModelViewModel newModelViewModel = new ModelViewModel();
            modelMapper.map(me, newModelViewModel);
            brandViewModelOptional.get().addModel(newModelViewModel);
        });
        return result;
    }

    private static Optional<BrandViewModel> findByName(List<BrandViewModel> allModels, String name) {
        return allModels.stream()
                .filter(m -> m.getName().equals(name))
                .findAny();
    }
}
