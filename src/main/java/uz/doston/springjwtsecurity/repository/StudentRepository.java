package uz.doston.springjwtsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.doston.springjwtsecurity.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
