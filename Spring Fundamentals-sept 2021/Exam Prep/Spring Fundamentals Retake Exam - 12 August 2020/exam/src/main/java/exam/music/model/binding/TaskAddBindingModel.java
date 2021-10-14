package exam.music.model.binding;

import exam.music.model.entity.Classification;
import exam.music.model.entity.ClassificationEnum;
import exam.music.model.entity.ProgressEnum;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TaskAddBindingModel {
    private String name;
    private String description;
    private LocalDate dueDate;
    private ClassificationEnum classification;

    public TaskAddBindingModel() {
    }

    @NotNull(message = "Name is required")
    @Length(min = 3, max = 20, message = "Name must be between 3 and 20 symbols")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Description is required")
    @Length(min = 3, max = 20, message = "Description must be more than  5 symbols")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @NotNull(message = "Due date required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @NotNull(message = "Classificaiton is required")
    public ClassificationEnum getClassification() {
        return classification;
    }

    public void setClassification(ClassificationEnum classification) {
        this.classification = classification;
    }
}
