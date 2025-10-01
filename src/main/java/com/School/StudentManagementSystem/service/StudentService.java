package com.School.StudentManagementSystem.service;

import com.School.StudentManagementSystem.repository.StudentRepository;
import com.School.StudentManagementSystem.entity.Student;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private int temp;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findById(Integer id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()){
            return studentOptional.get();
        }
        throw new EntityNotFoundException("Student not found");
    }

    public Student save(Student student){
        return studentRepository.save(student);
    }

    public Student update(Student student){
        return studentRepository.save(student);
    }

    public void delete(Student student){
        studentRepository.delete(student);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public void deleteById(Integer id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()){
            studentRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Student not found");
        }
    }

}

