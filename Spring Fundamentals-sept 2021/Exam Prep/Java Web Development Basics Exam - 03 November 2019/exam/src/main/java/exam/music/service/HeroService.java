package exam.music.service;

import exam.music.model.service.HeroServiceModel;
import exam.music.model.view.HeroViewModel;

import java.util.List;

public interface HeroService {
    String add(HeroServiceModel model);

    HeroServiceModel findById(String id);

    List<HeroViewModel> findAll();

    void delete(String id);
}
