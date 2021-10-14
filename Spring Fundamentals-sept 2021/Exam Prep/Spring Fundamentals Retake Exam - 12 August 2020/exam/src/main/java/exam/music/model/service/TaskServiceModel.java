package exam.music.model.service;

import exam.music.model.entity.ClassificationEnum;
import exam.music.model.entity.ProgressEnum;

import java.time.LocalDate;

public class TaskServiceModel {

    private String name;
    private String description;
    private ProgressEnum progress;
    private LocalDate dueDate;
    private ClassificationEnum classification;

    public TaskServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProgressEnum getProgress() {
        return progress;
    }

    public void setProgress(ProgressEnum progress) {
        this.progress = progress;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public ClassificationEnum getClassification() {
        return classification;
    }

    public void setClassification(ClassificationEnum classification) {
        this.classification = classification;
    }
}
