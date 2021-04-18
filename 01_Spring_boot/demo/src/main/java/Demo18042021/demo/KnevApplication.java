package Demo18042021.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KnevApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnevApplication.class, args);
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value="name",defaultValue="World")String name){
        return  String.format("Hello %s", name);
    }
}
