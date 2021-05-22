package softuni.judge_v2.init;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.judge_v2.service.interfaces.RoleService;


@Component
@AllArgsConstructor
public class DBinit implements CommandLineRunner {

    private final RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
    roleService.initRoles();
    }
}
