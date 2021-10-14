package exam.music.service.impl;

import exam.music.model.entity.Classification;
import exam.music.model.entity.ClassificationEnum;
import exam.music.repository.ClassificationRepository;
import exam.music.service.ClassificationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    private final ClassificationRepository classificationRepository;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }


    @Override
    public void seedData() {
        if (this.classificationRepository.count() == 0) {

           Arrays.stream(ClassificationEnum.values())
           .forEach(classificationEnum -> {

            this.classificationRepository.save(new Classification(classificationEnum,String.format("Description for %s", classificationEnum.name())));
           });

        }
    }

    @Override
    public Classification getByName(ClassificationEnum classification) {
        return
                this.classificationRepository.findByClassificationName(classification);
    }
}
