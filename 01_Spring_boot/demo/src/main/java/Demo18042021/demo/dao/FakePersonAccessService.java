package Demo18042021.demo.dao;

import Demo18042021.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")

public class FakePersonAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();


    @Override
    public int insertPerson(UUID id, Person person) {
        try {
            DB.add(new Person(id, person.getName()));
            return 200;
        } catch (Error err) {
            return 400;
        }
    }


    @Override
    public List<Person> getAllPeople() {
        return DB;
    }

    @Override
    public int deletePersonById(UUID id) {
        boolean result = DB.removeIf(p -> p.getId().equals(id));
        return result ? 200 : 405;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {

        return selectPesonById(id)
                .map(p -> {
                    int index = DB.indexOf(p);
                    if (index >= 0) {
                        DB.set(index, new Person(id,person.getName()));
                        return 200;
                    }
                    return index;
                })
                .orElse(405);
    }

    @Override
    public Optional<Person> selectPesonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

}
