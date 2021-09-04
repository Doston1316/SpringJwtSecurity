package uz.doston.springjwtsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.doston.springjwtsecurity.model.Student;
import uz.doston.springjwtsecurity.model.User;
import uz.doston.springjwtsecurity.repository.StudentRepository;

import javax.swing.plaf.PanelUI;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student create(Student student){
        return studentRepository.save(student);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();

    }

}
