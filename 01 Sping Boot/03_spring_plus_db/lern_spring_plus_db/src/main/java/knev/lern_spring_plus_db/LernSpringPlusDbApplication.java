package knev.lern_spring_plus_db;

import knev.lern_spring_plus_db.models.Stundent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

@SpringBootApplication

public class LernSpringPlusDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(LernSpringPlusDbApplication.class, args);
    }


}
