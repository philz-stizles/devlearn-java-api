package io.devdezyn.devlearnrest.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents () {
        return studentRepository.findAll();
    }

    public Student createStudent (Student student) {
        Optional<Student> existingStudent = studentRepository.findByEmail(student.getEmail());
        if(existingStudent.isPresent()) {
            throw new IllegalStateException("Email is already taken");
        }

        return studentRepository.save(student);
    }

    public Optional<Student> getStudent (Long id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> getStudentByEmail (String email) {
        return studentRepository.findByEmail(email);
    }

    public void deleteStudent (Long id) {
        boolean exists = studentRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("Student not found");
        }

        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {

    }
}
