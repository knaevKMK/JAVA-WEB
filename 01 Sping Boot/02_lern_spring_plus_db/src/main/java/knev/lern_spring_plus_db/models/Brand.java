package knev.lern_spring_plus_db.models;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Brand extends BaseEntity{

    @NonNull
    @Length(min = 2, max = 40)
    private String name;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Model> models = new ArrayList<>();

    public static Brand create(String name, Set<Model> models) {
        Brand brand = new Brand(name);
        models.stream().forEach(model -> {
            model.setBrand(brand);
            brand.getModels().add(model);
        });
        return brand;
    }

}
