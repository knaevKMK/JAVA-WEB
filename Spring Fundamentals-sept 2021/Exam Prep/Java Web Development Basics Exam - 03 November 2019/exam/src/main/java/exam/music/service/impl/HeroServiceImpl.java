package exam.music.service.impl;

import exam.music.model.entity.Hero;
import exam.music.model.service.HeroServiceModel;
import exam.music.model.view.HeroViewModel;
import exam.music.repository.HeroRepository;
import exam.music.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroServiceImpl implements HeroService {

    private final ModelMapper modelMapper;
    private final HeroRepository heroRepository;

    public HeroServiceImpl(ModelMapper modelMapper, HeroRepository heroRepository) {
        this.modelMapper = modelMapper;
        this.heroRepository = heroRepository;
    }


    @Override
    public String add(HeroServiceModel model) {
        Hero hero = modelMapper.map(model, Hero.class);
        hero.setImageUrl(String.format("/img/%s.jpg", hero.getClassEnum().name().toLowerCase()));
        hero = this.heroRepository.saveAndFlush(hero);
        return hero.getId();
    }

    @Override
    public HeroServiceModel findById(String id) {
        return this.heroRepository.findById(id).map(hero -> modelMapper.map(hero, HeroServiceModel.class)).orElse(null);
    }

    @Override
    public List<HeroViewModel> findAll() {
        return this.heroRepository.findAll()
                .stream().map(hero -> {
                    HeroViewModel map = modelMapper.map(hero, HeroViewModel.class);
                //    map.setImageUrl(String.format("/img/%s.jpg", map.getClassEnum().name().toLowerCase()));
                    return map;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        this.heroRepository.deleteById(id);
    }
}
