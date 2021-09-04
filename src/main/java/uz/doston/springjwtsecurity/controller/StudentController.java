package uz.doston.springjwtsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.doston.springjwtsecurity.model.Student;
import uz.doston.springjwtsecurity.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity create(@RequestBody Student student){
        return ResponseEntity.ok(studentService.create(student));
    }

    @GetMapping("/student")
    public List<Student>findAll(){
        return studentService.findAll();
    }


}
