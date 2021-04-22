package knev.lern_spring_plus_db.service;

import knev.lern_spring_plus_db.models.Stundent;
import knev.lern_spring_plus_db.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;


//@Component
@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private Repository repository;
    @Autowired
    EntityManager  entityManager;


    public List<Stundent> getAllStudents() {
        return this.repository.findAll();
    }

    public void createStudent(Stundent stundent) {
        this.repository.save(stundent);
                //.add(new Stundent(stundent.getName(), stundent.getEmail(), stundent.getDob(), stundent.getAge()));
    }
}
