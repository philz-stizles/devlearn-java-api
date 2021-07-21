package io.devdezyn.devlearnrest.permission;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PermissionConfig {


    @Bean
    CommandLineRunner permissionCommandLineRunner(PermissionRepository permissionRepository ) {
        return args -> {
            Permission createStudent = new Permission("student:create", "User can create a student");
            Permission readStudent = new Permission("student:read", "User can view a student or list of students");
            Permission updateStudent = new Permission("student:update", "User can update a student");
            Permission deleteStudent = new Permission("student:delete", "User can delete a student");

            permissionRepository.saveAll(List.of(createStudent, readStudent, updateStudent, deleteStudent));
        };
    }
}
