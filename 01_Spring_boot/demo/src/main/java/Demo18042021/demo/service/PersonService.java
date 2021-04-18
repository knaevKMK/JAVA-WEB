package Demo18042021.demo.service;

import Demo18042021.demo.dao.PersonDao;
import Demo18042021.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
//@Component

public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(  Person person) {
        return personDao.insertPerson(person);

    }

    public List<Person> getAllPeople(){
        return personDao.getAllPeople();
    }

    public int deletePersonById(UUID id){
        return personDao.deletePersonById(id);
    }

    public int editPersonById(UUID id, Person person){
        return  personDao.updatePersonById(id,person);
    }

    public Optional<Person> getPersonById(UUID id){
        return  personDao.selectPesonById(id);
    }
}
