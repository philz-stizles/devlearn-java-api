package io.devdezyn.devlearnrest.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/management/api/v1/students")
public class StudentManagementController {
    private final StudentService studentService;

    @Autowired
    public StudentManagementController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents () {
        return studentService.getStudents();
    }

    @PostMapping
    public void createStudent (@RequestBody Student student) {
        studentService.createStudent(student);
    }

    @GetMapping(path = "{studentId}")
    public Optional<Student> getStudent (@PathVariable("studentId") Long studentId) {
        return studentService.getStudent(studentId);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent (@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent (
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        studentService.updateStudent(studentId, name, email);
    }
}
