package exam.music.service;

import exam.music.model.entity.SexEntity;

public interface GenderService {
    void seedData();

    SexEntity findByName(String name);
}
