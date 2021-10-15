package exam.music.service.impl;

import exam.music.model.entity.SexEntity;
import exam.music.model.entity.SexEnum;
import exam.music.repository.GenderRepository;
import exam.music.service.GenderService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class GenderServiceImpl implements GenderService {
    private final GenderRepository genderRepository;

    public GenderServiceImpl(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @Override
    public void seedData() {
        if (this.genderRepository.count() == 0) {
            Arrays.stream(SexEnum.values()).forEach(sexEnum -> {
                this.genderRepository.saveAndFlush(new SexEntity(sexEnum.name()));
            });
        }
    }

    @Override
    public SexEntity findByName(String name) {

        return this.genderRepository.findByGender(name);
    }
}
