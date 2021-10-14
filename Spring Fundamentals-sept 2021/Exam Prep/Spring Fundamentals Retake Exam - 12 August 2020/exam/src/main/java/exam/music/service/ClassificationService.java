package exam.music.service;

import exam.music.model.entity.Classification;
import exam.music.model.entity.ClassificationEnum;

public interface ClassificationService
{
    void seedData();

    Classification getByName(ClassificationEnum classification);
}
