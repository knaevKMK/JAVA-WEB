package knev.lern_spring_plus_db.api;


import knev.lern_spring_plus_db.models.Stundent;
import knev.lern_spring_plus_db.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/students")
public class Controller implements CommandLineRunner {
    private final Service service;



    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping
    public List<Stundent> getAllStudents() {
       return this.service.getAllStudents();
    }
    @PostMapping
    public void createStudent(Stundent stundent){
        this.service.createStudent(stundent);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

    }
}
