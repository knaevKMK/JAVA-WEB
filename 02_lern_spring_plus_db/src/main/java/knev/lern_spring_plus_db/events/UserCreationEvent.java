package knev.lern_spring_plus_db.events;

import knev.lern_spring_plus_db.models.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class UserCreationEvent {
    private final User user;
}
