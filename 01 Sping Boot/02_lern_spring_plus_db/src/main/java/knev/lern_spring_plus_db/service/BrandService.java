package knev.lern_spring_plus_db.service;

import knev.lern_spring_plus_db.models.Brand;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface BrandService {
    Collection<Brand> getBrands();
    Brand getBrandById(UUID id);
    Brand createBrand(Brand post);
    Brand updateBrand(Brand post);
    Brand deleteBrand(UUID id);
    long getBrandsCount();
    List<Brand> createBrandsBatch(List<Brand> posts);
}
