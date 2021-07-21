package io.devdezyn.devlearnrest.role;

import io.devdezyn.devlearnrest.permission.Permission;
import io.devdezyn.devlearnrest.permission.PermissionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RoleConfig {


    @Bean
    CommandLineRunner roleCommandLineRunner(RoleRepository roleRepository ) {
        return args -> {
            Role admin = new Role("Admin", "User has all permissions");
            Role student = new Role("Student", "User can view a Role or list of Roles");
            Role instructor = new Role("Instructor", "User can update a Role");
            Role auditor = new Role("Auditor", "User can delete a Role");

            roleRepository.saveAll(List.of(admin, student, instructor, auditor));
        };
    }
}
