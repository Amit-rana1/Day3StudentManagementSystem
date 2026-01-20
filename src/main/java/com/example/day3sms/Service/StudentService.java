package com.example.day3sms.Service;

import com.example.day3sms.Model.StudentModel;
import com.example.day3sms.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    //create
    public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }


}
