package spring_fundametals.mobilele.services;


import org.springframework.stereotype.Service;
import spring_fundametals.mobilele.model.view.BrandViewModel;

import java.util.List;

public interface BrandService {

    List<BrandViewModel> getAllBrands(Module module);
}
